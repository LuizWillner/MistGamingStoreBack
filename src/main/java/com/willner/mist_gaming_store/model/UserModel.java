package com.willner.mist_gaming_store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter  // Anotação do Lombok para gerar automaticamente os métodos getters dos atributos de UserModel
@Setter  // Anotação do Lombok para gerar automaticamente os métodos setters dos atributos de UserModel
// @Data // Gera automaticamente tanto os métodos getters quanto os setters dos atributos de UserModel
@Entity(name = "user")  // Indica que a classe UserModel é uma entidade do banco de dados
@ToString
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    @NotEmpty(message = "O 'Email' deve ser informado.")
    private String email;

    @NotEmpty(message = "O 'Username' deve ser informado.")
    private String username;

    @NotEmpty(message = "A 'Senha' deve ser informada.")
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public UserModel(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
