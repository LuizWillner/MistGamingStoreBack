package com.willner.mist_gaming_store.repository;

import com.willner.mist_gaming_store.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Primeiro param do Generator <> é o tipo da classe que o repository representa e o segundo é o tipo do ID
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    // Spring automaticamente entende a semântica do nome "findByEmail" e cria a query adequadamente
    UserModel findByEmail(String email);

    UserModel findByEmailAndPassword(String email, String password);
}
