package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")  // http://localhost:8080/teste
public class UserController {

    @Autowired  // indica ao Spring que ele deve fazer o gerenciamento do ciclo de vida instância
    private IUserRepository userRepository;

    @PostMapping("/")  // POST http://localhost:8080/user/
    public UserModel createUser(@RequestBody UserModel user) {
        // @RequestBody: indica que o objeto será passado no corpo da requisição
        UserModel userCreated = this.userRepository.save(user);
        System.out.println("User " + user.getUsername() + " created");
        return userCreated;
    }
}
