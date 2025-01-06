package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.CartItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItemModel, Long> {
}
