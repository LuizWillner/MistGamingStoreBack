package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.CartItemDTO;
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
    @PostMapping
    public CartItemModel createCartItem(@RequestBody CartItemDTO cartItemDTO) {
        var game = this.gameService.findGameById(cartItemDTO.gameId());
        var cart = this.cartService.getCartByIdFromUser(cartItemDTO.cartId(), cartItemDTO.userId());
        CartItemModel cartItem = new CartItemModel(cartItemDTO.quantity(), cart, game);
        return this.cartItemService.createCartItem(cartItem);
    }

    // Alterar quantidade de um produto no carrinho
    @PutMapping
    public CartItemModel updateCartItem(@RequestBody CartItemModel cartItem) {
        return cartItemService.updateCartItem(cartItem);
    }

    // Remover item carrinho
    @DeleteMapping("{cartItemId}")  // DELETE http://localhost:8080/user/cart/item/1
    public CartItemModel deleteCartItem(
            @PathVariable(name= "cartItemId") Long cartItemId
    ) {
        CartItemModel cartItem = cartItemService.getCartItemById(cartItemId);
        cartItemService.deleteCartItem(cartItemId);
        return cartItem;
    }
}
