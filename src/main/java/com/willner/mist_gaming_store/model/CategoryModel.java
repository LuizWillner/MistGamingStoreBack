package com.willner.mist_gaming_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String nome;

    // TODO: ver e entender no de Marina como ela faz os relacionamentos
    @JsonIgnore
    @OneToMany (mappedBy = "category", fetch = FetchType.LAZY)  // "category" se referencia ao atributo categoru de GameModel
    private List<GameModel> games;

    public CategoryModel(String nome) {
        this.nome = nome;
    }
}
