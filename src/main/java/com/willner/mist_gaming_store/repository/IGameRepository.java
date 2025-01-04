package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


// Primeiro param do Generator <> é o tipo da classe que o repository representa e o segundo é o tipo do ID
public interface IGameRepository extends JpaRepository<GameModel, Long> {
    @Query("select g from game g")
    List<GameModel> findAllGames();

    @Query("select g from game g where g.name = :gameName")
    GameModel findByName(String gameName);

    @Query("select g from game g where g.category.categoryId = :categoryId")
    List<GameModel> findByCategoryId(Long categoryId);

    @Query(
            value = "SELECT g FROM game g LEFT JOIN FETCH g.category c WHERE c.categoryId = :categoryId",
            countQuery = "SELECT COUNT(g) FROM game g LEFT JOIN g.category c WHERE c.categoryId = :categoryId"
    )
    Page<GameModel> findGamesPageableByCategoryId(int categoryId, Pageable pageable);

    @Query(
            value = "SELECT g FROM game g LEFT JOIN FETCH g.category c WHERE c.name LIKE %:categoryName%",
            countQuery = "SELECT COUNT(g) FROM game g LEFT JOIN g.category c WHERE c.name LIKE %:categoryName%"
    )
    Page<GameModel> findGamesPageableByCategoryName(String categoryName, Pageable pageable);

    @Query(
            value = "SELECT g FROM game g WHERE g.releaseDate BETWEEN :dateMin AND :dateMax ORDER BY g.releaseDate DESC",
            countQuery = "SELECT count(g) FROM game g WHERE g.releaseDate BETWEEN :dateMin AND :dateMax"
    )
    Page<GameModel> findGamesPageableByCReleaseDate(LocalDate dateMin, LocalDate dateMax, Pageable pageable);
}
