package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.model.CartItemModel;
import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.repository.ICartItemRepository;
import com.willner.mist_gaming_store.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    private ICartItemRepository cartItemRepository;

    public CartItemModel createCartItem(CartItemModel cartItem) {
        return this.cartItemRepository.save(cartItem);
    }
}
