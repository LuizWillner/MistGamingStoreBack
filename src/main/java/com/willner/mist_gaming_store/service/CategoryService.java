package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.exception.TransientEntityException;
import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.repository.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    @Transactional  // it ensures that the annotated method runs within a transaction context.
    // If any exception occurs within the method, the transaction will be rolled back,
    // ensuring data consistency. If the method completes successfully, the transaction will be committed.
    public CategoryModel updateCategory(CategoryModel category) {
        if (category.getCategoryId() != null) {
//          produtoRepository.recuperarProdutoPorIdComLock(produto.getId())
            CategoryModel oldCategory = categoryRepository.findById(category.getCategoryId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Categoria não encontrada com id " + category.getCategoryId())
                    );
            category.setCreatedAt(oldCategory.getCreatedAt());
            return categoryRepository.save(category);
        }
        else {
            throw new TransientEntityException("Tentando alterar um objeto transiente.");
        }
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
