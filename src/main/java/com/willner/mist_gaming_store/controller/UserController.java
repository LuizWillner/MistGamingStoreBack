package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.UserModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")  // http://localhost:8080/teste
public class UserController {

    @PostMapping("/")  // POST http://localhost:8080/user/
    public void createUser(@RequestBody UserModel user) {
        // @RequestBody: indica que o objeto será passado no corpo da requisição
        System.out.println("User " + user.getUsername() + " created");
    }
}
