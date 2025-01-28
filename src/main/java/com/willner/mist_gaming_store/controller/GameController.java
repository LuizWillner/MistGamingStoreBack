package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.service.CategoryService;
import com.willner.mist_gaming_store.service.GameService;
import com.willner.mist_gaming_store.util.ResultadoPaginado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/game")  // http://localhost:8080/game
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping  // POST http://localhost:8080/game
    public GameModel createGame(@RequestBody GameModel game) {
        CategoryModel category = this.categoryService.findCategoryById(game.getCategory().getCategoryId());
        game.setCategory(category);
        return this.gameService.createGame(game);
    }

    @GetMapping  // GET http://localhost:8080/game
    public List<GameModel> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("{gameId}")  // GET http://localhost:8080/game/1
    public GameModel getGameById(@PathVariable("gameId") Long gameId) {
        return gameService.findGameById(gameId);
    }

    @GetMapping("title/{gameName}")         // GET http://localhost:8080/game/title/Baldur's Gate 3
    public GameModel getGameByName(@PathVariable("gameName") String gameName) {
        return gameService.getGameByName(gameName);
    }

    @GetMapping("category/{categoryId}")         // GET http://localhost:8080/game/category/3
    public List<GameModel> getGamesByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return gameService.getGamesByCategoryId(categoryId);
    }

    @GetMapping("category/name/{categoryName}")         // GET http://localhost:8080/game/category/name/Coop
    public List<GameModel> getGamesByCategoryName(@PathVariable("categoryName") String categoryName) {
        return gameService.getGamesByCategoryName(categoryName);
    }

    @GetMapping("pageable")  // GET http://localhost:8080/game/pageable?page=0&size=3&name=Cyberpunk
    public ResultadoPaginado<GameModel> getGamesPageable(
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "3") int size,
            @RequestParam(name="name", defaultValue = "") String name
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameModel> paginaDeProduto = gameService.getGamesPageable(name, pageable);
        ResultadoPaginado<GameModel> resultadoPaginado = new ResultadoPaginado<>(
                paginaDeProduto.getTotalElements(),
                paginaDeProduto.getTotalPages(),
                paginaDeProduto.getNumber(),
                paginaDeProduto.getContent()
        );
        return resultadoPaginado;
    }


    @GetMapping("pageable/category/")   // GET http://localhost:8080/game/pageable/category?page=0&size=5&categoryId=1
    public ResultadoPaginado<GameModel> getGamesPageableByCategoryId(
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "3") int size,
            @RequestParam(name="categoryId", defaultValue = "") int categoryId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameModel> paginaDeProduto = gameService.getGamesPageableByCategoryId(categoryId, pageable);
        ResultadoPaginado<GameModel> resultadoPaginado = new ResultadoPaginado<>(
                paginaDeProduto.getTotalElements(),
                paginaDeProduto.getTotalPages(),
                paginaDeProduto.getNumber(),
                paginaDeProduto.getContent()
        );
        return resultadoPaginado;
    }

    @GetMapping("pageable/category/name")   // GET http://localhost:8080/game/pageable/category/name?page=0&size=5&categoryName=Ação e Aventura
    public ResultadoPaginado<GameModel> getGamesPageableByCategoryName(
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "3") int size,
            @RequestParam(name="categoryName", defaultValue = "") String categoryName
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameModel> paginaDeProduto = gameService.getGamesPageableByCategoryName(categoryName, pageable);
        ResultadoPaginado<GameModel> resultadoPaginado = new ResultadoPaginado<>(
            paginaDeProduto.getTotalElements(),
            paginaDeProduto.getTotalPages(),
            paginaDeProduto.getNumber(),
            paginaDeProduto.getContent()
        );
        return resultadoPaginado;
    }

    @GetMapping("pageable/releaseDate")   // GET http://localhost:8080/game/pageable/releaseDate?page=0&size=5
    public ResultadoPaginado<GameModel> getGamesPageableByReleaseDate(
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "3") int size,
            @RequestParam(name="dateMin", defaultValue = "") LocalDate dateMin,
            @RequestParam(name="dateMax", defaultValue = "") LocalDate dateMax
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameModel> paginaDeProduto = gameService.getGamesPageableByReleaseDate(dateMin, dateMax, pageable);
        ResultadoPaginado<GameModel> resultadoPaginado = new ResultadoPaginado<>(
                paginaDeProduto.getTotalElements(),
                paginaDeProduto.getTotalPages(),
                paginaDeProduto.getNumber(),
                paginaDeProduto.getContent()
        );
        return resultadoPaginado;
    }

    @GetMapping("pageable/discount")   // GET http://localhost:8080/game/pageable/discount?page=0&size=5
    public ResultadoPaginado<GameModel> getGamesPageableByDiscount(
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "3") int size,
            @RequestParam(name="discountMin", defaultValue = "0") Double discountMin,
            @RequestParam(name="discountMax", defaultValue = "1") Double discountMax
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameModel> paginaDeProduto = gameService.getGamesPageableByDiscount(discountMin, discountMax, pageable);
        ResultadoPaginado<GameModel> resultadoPaginado = new ResultadoPaginado<>(
                paginaDeProduto.getTotalElements(),
                paginaDeProduto.getTotalPages(),
                paginaDeProduto.getNumber(),
                paginaDeProduto.getContent()
        );
        return resultadoPaginado;
    }

    @PutMapping  // PUT http://localhost:8080/game
    public GameModel updateGame(@RequestBody GameModel game) {
        return gameService.updateGame(game);
    }

    @DeleteMapping("{gameId}")  // DELETE http://localhost:8080/game/1
    public GameModel deleteGame(@PathVariable("gameId") Long gameId) {
        GameModel game = gameService.findGameById(gameId);
        gameService.deleteGame(gameId);
        return game;
    }
}
