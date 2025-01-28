package com.willner.mist_gaming_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "game")
public class GameModel {  //TODO: Ingresso, Produto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @Column(unique = true)
    @NotEmpty(message = "O 'Nome' do jogo deve ser informado.")
    private String name;

    private String image;

    private String trailer;

    @Column(length = 1000)
    @NotEmpty(message = "A 'Descrição' deve ser informada.")
    private String description;

    private String developer;
    private String publisher;

    @NotNull(message = "O 'Preço' deve ser informado.")
    private BigDecimal price;

    @Min(value=0, message = "O 'Desconto' deve ser maior ou igual a 0.")
    @Max(value=1, message = "O 'Desconto' deve ser menor ou igual a 1.")
    @Column(columnDefinition = "double default 1.0")
    private Double discount = 1.0;

    private LocalDate releaseDate;

    @Min(value=0, message = "A 'Quantidade em estoque' deve ser maior ou igual a 0.")
    @Column(columnDefinition = "int default 0")
    private int stockQuantity = 0;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotNull(message = "A 'Categoria' deve ser informada.")
    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)  // category_id referencia o nome da coluna NO BANCO
    private CategoryModel category;

    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItemModel> cartItens;

    public GameModel(
            String name,
            String image,
            String trailer,
            String description,
            String developer,
            String publisher,
            BigDecimal price,
            Double discount,
            LocalDate releaseDate,
            int stockQuantity,
            CategoryModel category
    ) {
        this.name = name;
        this.image = image;
        this.trailer = trailer;
        this.description = description;
        this.developer = developer;
        this.publisher = publisher;
        this.price = price;
        this.discount = discount;
        this.releaseDate = releaseDate;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public BigDecimal getDiscountPrice() {
        // game.price * (1 - game.discount)
        BigDecimal bigDecimalDiscountPrice = this.price.multiply(
                BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(this.discount))
        );
        return bigDecimalDiscountPrice;
    }
}
