package com.willner.mist_gaming_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "category")
public class CategoryModel {  // TODO: Sessão
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany (mappedBy = "category", fetch = FetchType.LAZY)  // "category" se referencia ao atributo category de GameModel
    private List<GameModel> games;

    public CategoryModel(String name) {
        this.name = name;
    }
}
