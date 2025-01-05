package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.repository.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public CategoryModel createCategory(CategoryModel category) {
        return this.categoryRepository.save(category);
    }

    public CategoryModel findCategoryById(Long categoryId) {
        return this.categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category não encontrada com id: " + categoryId)
                );
    }

    public CategoryModel getCategoryByName(String categoryName) {
        return this.categoryRepository.findByName(categoryName);
    }
}
