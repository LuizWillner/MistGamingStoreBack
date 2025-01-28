package com.willner.mist_gaming_store.model;


public record CartItemDTO(Long gameId, int quantity, Long cartId, Long userId) {

}

