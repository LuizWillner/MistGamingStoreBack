package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.exception.TransientEntityException;
import com.willner.mist_gaming_store.model.CartItemModel;
import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.repository.ICartItemRepository;
import com.willner.mist_gaming_store.repository.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    private ICartItemRepository cartItemRepository;

    public CartItemModel createCartItem(CartItemModel cartItem) {
        return this.cartItemRepository.save(cartItem);
    }

    public CartItemModel getCartItemByIdFromCart(Long cartItemId, Long cartId) {
        return cartItemRepository.findByIdAndCartId(cartItemId, cartId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Item de carrinho número " + cartItemId + " não encontrado no carrinho."));
    }

    @Transactional
    public CartItemModel updateCartItem(CartItemModel cartItem) {
        if (cartItem.getCartItemId() != null) {
            CartItemModel oldCartItem = cartItemRepository.findById(cartItem.getCartItemId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Item não encontrado.")
                    );
            cartItem.setCreatedAt(oldCartItem.getCreatedAt());
            cartItem.setCart(oldCartItem.getCart());
            cartItem.setGame(oldCartItem.getGame());
            return cartItemRepository.save(cartItem);
        }
        else {
            throw new TransientEntityException("Tentando alterar um objeto transiente.");
        }
    }

    public void deleteCartItem(Long cartItem) {
        cartItemRepository.deleteById(cartItem);
    }
}
