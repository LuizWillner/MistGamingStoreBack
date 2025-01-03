package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;


// Primeiro param do Generator <> é o tipo da classe que o repository representa e o segundo é o tipo do ID
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long> {
}
