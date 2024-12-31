package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")  // http://localhost:8080/teste
public class UserController {

    @Autowired  // indica ao Spring que ele deve fazer o gerenciamento do ciclo de vida instância
    private UserService userService;

    @PostMapping("/")  // POST http://localhost:8080/user/
    public UserModel createUser(@RequestBody UserModel user) {
        return this.userService.createUser(user);
    }
}
