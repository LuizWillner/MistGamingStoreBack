package com.willner.mist_gaming_store.controller;

import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.service.UserService;
import com.willner.mist_gaming_store.util.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")  // http://localhost:8080/user
public class UserController {

    @Autowired  // indica ao Spring que ele deve fazer o gerenciamento do ciclo de vida instância
    private UserService userService;

    @PostMapping("/create")  // POST http://localhost:8080/user/create
    public ResponseEntity createUser(@RequestBody UserModel user) {
        var userCreated = this.userService.createUser(user);
        if (userCreated == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User já existe.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/login")  // GET http://localhost:8080/user/login
    public TokenResponse login(@RequestBody UserModel user) {
        // return new TokenResponse("token");
        UserModel userLoggedIn = this.userService.login(user);
        if (userLoggedIn != null) {
            return new TokenResponse(userLoggedIn.getEmail());
        } else {
            return new TokenResponse("");
        }
    }
}
