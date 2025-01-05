package com.willner.mist_gaming_store.model;

import jakarta.persistence.*;
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

    @Column(length = 1000)
    @NotEmpty(message = "A 'Descrição' deve ser informada.")
    private String description;

    private String developer;
    private String publisher;

    @NotNull(message = "O 'Preço' deve ser informado.")
    private BigDecimal price;

    private LocalDate releaseDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotNull(message = "A 'Categoria' deve ser informada.")
    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)  // category_id referencia o nome da coluna NO BANCO
    private CategoryModel category;

    @Min(value=0, message = "A 'Quantidade em estoque' deve ser maior ou igual a 0.")
    @Column(columnDefinition = "int default 0")
    private int stockQuantity = 0;

    public GameModel(
            String name,
            String image,
            String description,
            String developer,
            String publisher,
            BigDecimal price,
            LocalDate releaseDate,
            int stockQuantity,
            CategoryModel category
    ) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.developer = developer;
        this.publisher = publisher;
        this.price = price;
        this.releaseDate = releaseDate;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }
}
