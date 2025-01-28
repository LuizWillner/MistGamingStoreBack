package com.willner.mist_gaming_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "cart_item")
@Table(name = "cart_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cart_id", "game_id"})
})  // Combinação de cart_id e game_id deve ser única
public class CartItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @Min(value=0, message = "A 'Quantidade do item' deve ser maior ou igual a 0.")
    private int quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)  // cart_id referencia o nome da coluna NO BANCO
    @JsonIgnore
    private CartModel cart;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)  // category_id referencia o nome da coluna NO BANCO
    private GameModel game;

    public CartItemModel(int quantity, CartModel cart, GameModel game) {
        this.quantity = quantity;
        this.cart = cart;
        this.game = game;
    }

    public Double getCartItemPrice() {
        // quantity * game.getDiscountPrice()
        BigDecimal bigDecimalItemPrice = BigDecimal.valueOf(this.quantity).multiply(
                this.game.getDiscountPrice()
        );
        return bigDecimalItemPrice.doubleValue();
    }
}
