package com.willner.mist_gaming_store.model;

import jakarta.persistence.*;
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
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @Column(unique = true)
    @NotEmpty(message = "O 'Nome' do jogo deve ser informado.")
    private String name;

    private String image;

    @NotEmpty(message = "A 'Descrição' deve ser informada.")
    private String description;

    @NotNull(message = "O 'Preço' deve ser informado.")
    private BigDecimal price;

    private LocalDate releaseDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotNull(message = "A 'Categoria' deve ser informada.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)  // category_id referencia o nome da coluna NO BANCO
    private CategoryModel category;

    public GameModel(String name, String image, String description, BigDecimal price, LocalDate releaseDate) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.releaseDate = releaseDate;
    }
}
