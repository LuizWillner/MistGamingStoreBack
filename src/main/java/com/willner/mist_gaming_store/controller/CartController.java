package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.exception.InsuficientStockException;
import com.willner.mist_gaming_store.model.CartModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.service.CartItemService;
import com.willner.mist_gaming_store.service.CartService;
import com.willner.mist_gaming_store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/cart")  // http://localhost:8080/user/cart
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private GameService gameService;
    @Autowired
    private CartItemService cartItemService;

    @GetMapping  // GET http://localhost:8080/user/cart?cartId=1&userId=1
    public CartModel getCartByIdFromUser(
            @RequestParam(name = "cartId") Long cartId,
            @RequestParam(name = "userId") Long userId
    ) {
        return cartService.getCartByIdFromUser(cartId, userId);
    }

    @GetMapping("/total")  // GET http://localhost:8080/user/cart/total?cartId=1&userId=1
    public Double getTotalPriceFromCart(
            @RequestParam(name = "cartId") Long cartId,
            @RequestParam(name = "userId") Long userId
    ) {
        return cartService.getCartByIdFromUser(cartId, userId).getTotalPrice();
    }

    @PutMapping("/purchase")  // PUT http://localhost:8080/user/cart/purchase?cartId=1&userId=1
    public CartModel finalizePurchase(
            @RequestParam(name = "cartId") Long cartId,
            @RequestParam(name = "userId") Long userId
    ) {
        CartModel cart = cartService.getCartByIdFromUser(cartId, userId);
        cart.getCartItems().forEach(cartItem -> {
            GameModel game = cartItem.getGame();
            if (game.getStockQuantity() < cartItem.getQuantity()) {
                throw new InsuficientStockException(
                        "Quantidade insuficiente em estoque para o jogo " + game.getName()
                );
            }
            game.setStockQuantity(game.getStockQuantity() - cartItem.getQuantity());
            gameService.updateGame(game);
            cartItemService.deleteCartItem(cartItem.getCartItemId());
        });
        return cart;
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
