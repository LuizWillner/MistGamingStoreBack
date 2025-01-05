package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")  // http://localhost:8080/category
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping  // POST http://localhost:8080/category
    public CategoryModel createCategory(@RequestBody CategoryModel category) {
        return this.categoryService.createCategory(category);
    }
}
