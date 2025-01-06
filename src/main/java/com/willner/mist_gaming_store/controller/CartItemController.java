package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CartItemModel;
import com.willner.mist_gaming_store.service.CartItemService;
import com.willner.mist_gaming_store.service.CartService;
import com.willner.mist_gaming_store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/cart/item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private GameService gameService;



    // Add produto ao carrinho
    @PostMapping  // POST http://localhost:8080/user/cart/item?userId=1&cartId=1&gameId=1&quantity=1
    public CartItemModel createCartItem(
            @RequestParam(name = "userId") Long userId,
            @RequestParam(name= "cartId") Long cartId,
            @RequestParam(name= "gameId") Long gameId,
            @RequestParam(name= "quantity", defaultValue = "1") int quantity
    ) {
        var game = this.gameService.findGameById(gameId);
        var cart = this.cartService.getCartByIdFromUser(cartId, userId);
        CartItemModel cartItem = new CartItemModel(quantity, cart, game);
        return this.cartItemService.createCartItem(cartItem);
    }
}
