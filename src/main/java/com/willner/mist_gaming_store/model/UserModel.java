package com.willner.mist_gaming_store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter  // Anotação do Lombok para gerar automaticamente os métodos getters dos atributos de UserModel
@Setter  // Anotação do Lombok para gerar automaticamente os métodos setters dos atributos de UserModel
// @Data // Gera automaticamente tanto os métodos getters quanto os setters dos atributos de UserModel
@Entity(name = "user")  // Indica que a classe UserModel é uma entidade do banco de dados
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    // @NotEmpty(message = "O 'Nome' deve ser informado.")
    private String email;

    private String username;

    private String password;

    @CreationTimestamp
    private LocalDateTime created_at;

//    public UserModel(String email, String username, String password) {
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }

}
