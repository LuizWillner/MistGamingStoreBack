package com.willner.mist_gaming_store.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // TODO: ver e entender no de Marina como ela faz os relacionamentos
//    @JsonIgnore
//    @OneToMany (mappedBy = "categoria")
//    private List<Produto> produtos;

    public CategoryModel(String nome) {
        this.nome = nome;
    }
}
