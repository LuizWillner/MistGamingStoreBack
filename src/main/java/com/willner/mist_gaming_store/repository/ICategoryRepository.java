package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// Primeiro param do Generator <> é o tipo da classe que o repository representa e o segundo é o tipo do ID
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long> {

    @Query("select c from category c")
    List<CategoryModel> findAllCategories();

    // Spring automaticamente entende a semântica do nome "findByName" e cria a query adequadamente
    CategoryModel findByName(String categoryName);
}
