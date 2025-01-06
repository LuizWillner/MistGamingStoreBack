package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<CartModel, Long> {
}
