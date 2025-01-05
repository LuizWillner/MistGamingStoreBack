package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")  // http://localhost:8080/category
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping  // POST http://localhost:8080/category
    public CategoryModel createCategory(@RequestBody CategoryModel category) {
        return this.categoryService.createCategory(category);
    }

    @GetMapping  // GET http://localhost:8080/category
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{categoryId}")  // GET http://localhost:8080/category/1
    public CategoryModel getCategoryById(@PathVariable("categoryId") Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping("name/{categoryName}")         // GET http://localhost:8080/category/name/CRPG
    public CategoryModel getCategoryByName(@PathVariable("categoryName") String categoryName) {
        System.out.println("categoryName: " + categoryName);
        return categoryService.getCategoryByName(categoryName);
    }

    @PutMapping  // PUT http://localhost:8080/category
    public CategoryModel updateCategory(@RequestBody CategoryModel category) {
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping("{categoryId}")  // DELETE http://localhost:8080/category/1
    public CategoryModel deleteCategory(@PathVariable("categoryId") Long categoryId) {
        CategoryModel category = categoryService.findCategoryById(categoryId);
        categoryService.deleteCategory(categoryId);
        return category;
    }
}
