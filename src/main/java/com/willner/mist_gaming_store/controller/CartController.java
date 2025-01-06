package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CartModel;
import com.willner.mist_gaming_store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/cart")  // http://localhost:8080/user/cart
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping  // GET http://localhost:8080/user/cart?cartId=1&userId=1
    public CartModel getCartByIdFromUser(
            @RequestParam(name = "cartId") Long cartId,
            @RequestParam(name = "userId") Long userId
    ) {
        return cartService.getCartByIdFromUser(cartId, userId);
    }

    @DeleteMapping  // DELETE http://localhost:8080/user/cart?cartId=1&userId=1
    public CartModel deleteCartByIdFromUser(
            @RequestParam(name = "cartId") Long cartId,
            @RequestParam(name = "userId") Long userId
    ) {
        CartModel cart = cartService.getCartByIdFromUser(cartId, userId);
        cartService.deleteCart(cartId);
        return cart;
    }
}
