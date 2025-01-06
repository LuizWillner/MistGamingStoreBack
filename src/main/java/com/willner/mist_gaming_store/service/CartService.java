package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.model.CartModel;
import com.willner.mist_gaming_store.repository.ICartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartService {

    @Autowired
    private ICartRepository cartRepository;

    public CartModel getCartByIdFromUser(Long cartId, Long userId) {
        return cartRepository.findByCartIdAndUserId(cartId, userId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Carrinho número " + cartId + " do usuário número " + userId + " não encontrado."));
    }

    @Transactional
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
