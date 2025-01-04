package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.service.CategoryService;
import com.willner.mist_gaming_store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
