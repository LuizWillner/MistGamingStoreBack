package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.CartItemModel;
import com.willner.mist_gaming_store.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICartItemRepository extends JpaRepository<CartItemModel, Long> {

    @Query("select ci from cart_item ci where ci.cartItemId = :cartItemId AND ci.cart.cartId = :cartId")
    Optional<CartItemModel> findByIdAndCartId(Long cartItemId, Long cartId);

    @Query("select ci from cart_item ci where ci.cart.cartId = :cartId AND ci.game.gameId = :gameId")
    CartItemModel findByCartIdAndGameId(Long cartId, Long gameId);

    @Modifying  // Por alguma razão, tive que redefinir o deleteById pois o original não funcionava
    @Query("delete from cart_item ci where ci.cartItemId = :cartItemId")
    void deleteById(Long cartItemId);
}
