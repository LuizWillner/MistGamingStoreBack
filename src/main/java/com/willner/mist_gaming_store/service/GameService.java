package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.exception.TransientEntityException;
import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.repository.IGameRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;


@Service
public class GameService {
    @Autowired
    private IGameRepository gameRepository;

    @Autowired
    private CategoryService categoryService;

    public GameModel createGame(GameModel game) {
        return this.gameRepository.save(game);
    }

    public List<GameModel> getAllGames() {
        return gameRepository.findAllGames();
    }

    public GameModel getGameByName(String gameName) {
        return gameRepository.findByName(gameName);
    }

    public List<GameModel> getGamesByCategoryId(Long categoryId) {
        return gameRepository.findByCategoryId(categoryId);
    }

    public List<GameModel> getGamesByCategoryName(String categoryName) {
        CategoryModel category = this.categoryService.getCategoryByName(categoryName);
        return gameRepository.findByCategoryId(category.getCategoryId());
    }

    public Page<GameModel> getGamesPageable(String name, String sort, String order, Pageable pageable) {
        Sort sortOrder;
        if ("discountPrice".equals(sort)) {
            sortOrder = JpaSort.unsafe(Sort.Direction.fromString(order), "g.price * (1 - g.discount)");
        } else if ("category".equals(sort)) {
            sortOrder = Sort.by(Sort.Direction.fromString(order), "category.name");
        } else {
            sortOrder = Sort.by(Sort.Direction.fromString(order), sort);
        }
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortOrder);
        return gameRepository.findGamesPageable(name, sortedPageable);

    }

    public Page<GameModel> getGamesPageableByCategoryId(int categoryId, Pageable pageable) {
        return gameRepository.findGamesPageableByCategoryId(categoryId, pageable);
    }

    public Page<GameModel> getGamesPageableByCategoryName(String categoryName, Pageable pageable) {
        return gameRepository.findGamesPageableByCategoryName(categoryName, pageable);
    }

    public Page<GameModel> getGamesPageableByReleaseDate(LocalDate dateMin, LocalDate dateMax, Pageable pageable) {
        if (dateMin == null && dateMax == null) {
            return gameRepository.findGamesPageableByCategoryName("", pageable);
        } else if (dateMin == null) {
            dateMin = LocalDate.MIN;
        } else if (dateMax == null) {
            dateMax = LocalDate.MAX;
        }
        return gameRepository.findGamesPageableByCReleaseDate(dateMin, dateMax, pageable);
    }

    public Page<GameModel> getGamesPageableByDiscount(Double discountMin, Double discountMax, Pageable pageable) {
        if (discountMin == null && discountMax == null) {
            return gameRepository.findGamesPageableByCategoryName("", pageable);
        } else if (discountMin == null) {
            discountMin = 0.0;
        } else if (discountMax == null) {
            discountMax = 1.0;
        }
        return gameRepository.findGamesPageableByDiscount(discountMin, discountMax, pageable);
    }

    public GameModel findGameById(Long gameId) {
        return this.gameRepository.findById(gameId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Game não encontrado com id: " + gameId)
                );
    }

    @Transactional  // it ensures that the annotated method runs within a transaction context.
    // If any exception occurs within the method, the transaction will be rolled back,
    // ensuring data consistency. If the method completes successfully, the transaction will be committed.
    public GameModel updateGame(GameModel game) {
        if (game.getGameId() != null) {
//          produtoRepository.recuperarProdutoPorIdComLock(produto.getId())
            GameModel oldGame = gameRepository.findById(game.getGameId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Game não encontrado com id " + game.getGameId())
                    );
            game.setCreatedAt(oldGame.getCreatedAt());
            return gameRepository.save(game);
        }
        else {
            throw new TransientEntityException("Tentando alterar um objeto transiente.");
        }
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
