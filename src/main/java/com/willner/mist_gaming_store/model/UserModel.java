package com.willner.mist_gaming_store.model;

import lombok.Getter;
import lombok.Setter;


@Getter  // Anotação do Lombok para gerar automaticamente os métodos getters dos atributos de UserModel
@Setter  // Anotação do Lombok para gerar automaticamente os métodos setters dos atributos de UserModel
// @Data // Gera automaticamente tanto os métodos getters quanto os setters dos atributos de UserModel
public class UserModel {
    // @NotEmpty(message = "O 'Nome' deve ser informado.")
    private String email;
    private String username;
    private String password;

    public UserModel(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
