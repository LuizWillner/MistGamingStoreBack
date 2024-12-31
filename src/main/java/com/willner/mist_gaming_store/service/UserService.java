package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserModel createUser(UserModel user) {
        UserModel userCreated = this.userRepository.save(user);
        System.out.println("User " + user.getUsername() + " created");
        return userCreated;
    }
}
