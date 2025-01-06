package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.CartModel;
import com.willner.mist_gaming_store.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICartRepository extends JpaRepository<CartModel, Long> {

    @Query("select  c from cart c where c.cartId = :cartId AND c.user.userId = :userId")
    Optional<CartModel> findByCartIdAndUserId(Long cartId, Long userId);

    @Modifying  // Por alguma razão, tive que redefinir o deleteById pois o original não funcionava
    @Query("delete from cart c where c.cartId = :cartId")
    void deleteById(Long cartId);
}
