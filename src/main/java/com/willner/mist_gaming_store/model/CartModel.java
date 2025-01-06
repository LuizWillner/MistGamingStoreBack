package com.willner.mist_gaming_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItemModel> cartItems;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public CartModel(UserModel user) {
        this.user = user;
    }

}
