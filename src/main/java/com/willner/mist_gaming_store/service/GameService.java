package com.willner.mist_gaming_store.service;

import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.repository.IGameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {
    @Autowired
    private IGameRepository gameRepository;

    public GameModel createGame(GameModel game) {
        return this.gameRepository.save(game);
    }

    public GameModel findGameById(Long gameId) {
        return this.gameRepository.findById(gameId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category não encontrada com id: " + gameId)
                );
    }
}
