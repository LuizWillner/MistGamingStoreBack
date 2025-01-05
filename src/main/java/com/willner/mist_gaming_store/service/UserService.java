package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.exception.TransientEntityException;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserModel createUser(UserModel user) {
        UserModel userCreated = null;
        var existingUser = this.userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            userCreated = this.userRepository.save(user);
        }
        return userCreated;
    }

    public UserModel login(UserModel user) {
        return this.userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    @Transactional  // it ensures that the annotated method runs within a transaction context.
    // If any exception occurs within the method, the transaction will be rolled back,
    // ensuring data consistency. If the method completes successfully, the transaction will be committed.
    public UserModel updateUser(UserModel user) {
        if (user.getUserId() != null) {
//          produtoRepository.recuperarProdutoPorIdComLock(produto.getId())
            UserModel oldUser = userRepository.findById(user.getUserId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Usuário não encontrado com id " + user.getUserId())
                    );
            user.setCreatedAt(oldUser.getCreatedAt());
            return userRepository.save(user);
        }
        else {
            throw new TransientEntityException("Tentando alterar um objeto transiente.");
        }
    }
}
