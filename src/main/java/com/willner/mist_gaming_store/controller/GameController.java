package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.service.CategoryService;
import com.willner.mist_gaming_store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")  // http://localhost:8080/game
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public GameModel createGame(@RequestBody GameModel game) {
        CategoryModel category = this.categoryService.findCategoryById(game.getCategory().getCategoryId());
        game.setCategory(category);
        return this.gameService.createGame(game);
    }

    @PutMapping
    public GameModel updateGame(@RequestBody GameModel game) {
        return gameService.updateGame(game);
    }
}
