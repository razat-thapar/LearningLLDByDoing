package com.lld.three.services;

import com.lld.three.controllers.PlayerController;
import com.lld.three.dtos.BotPlayerRequestDTO;
import com.lld.three.dtos.HumanPlayerRequestDTO;
import com.lld.three.models.BotPlayer;
import com.lld.three.models.HumanPlayer;
import com.lld.three.models.Player;
import com.lld.three.models.User;
import com.lld.three.models.enums.DifficultyLevel;
import com.lld.three.models.factories.BotMovingStrategyFactory;

public class PlayerService {
    public Player createHumanPlayer(String name, Character symbol){
        //we can perform complex validations here.
        return HumanPlayer
                .builder()
                .user(
                        User
                                .builder()
                                .name(name)
                                .build()
                )
                .symbol(symbol)
                .build();
    }

    public Player createBotPlayer(String name, Character symbol, DifficultyLevel difficultyLevel){
        //we can perform complex validations here.
        return BotPlayer
                .builder()
                .difficultyLevel(difficultyLevel)
                .botMovingStrategy(BotMovingStrategyFactory.createBotMovingStrategy(difficultyLevel))
                .user(
                        User
                                .builder()
                                .name(name)
                                .build()
                )
                .symbol(symbol)
                .build();
    }
}
