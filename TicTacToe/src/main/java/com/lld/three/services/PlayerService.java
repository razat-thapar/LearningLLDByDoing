package com.lld.three.services;

import com.lld.three.controllers.PlayerController;
import com.lld.three.dtos.BotPlayerRequestDTO;
import com.lld.three.dtos.HumanPlayerRequestDTO;
import com.lld.three.models.BotPlayer;
import com.lld.three.models.HumanPlayer;
import com.lld.three.models.Player;
import com.lld.three.models.User;
import com.lld.three.models.factories.BotMovingStrategyFactory;

public class PlayerService {
    public Player createHumanPlayer(HumanPlayerRequestDTO humanPlayerRequestDTO){
        //we can perform complex validations here.
        return HumanPlayer
                .builder()
                .user(
                        User
                                .builder()
                                .name(humanPlayerRequestDTO.getName())
                                .build()
                )
                .symbol(humanPlayerRequestDTO.getSymbol())
                .build();
    }

    public Player createBotPlayer(BotPlayerRequestDTO botPlayerRequestDTO){
        //we can perform complex validations here.
        return BotPlayer
                .builder()
                .difficultyLevel(botPlayerRequestDTO.getDifficultyLevel())
                .botMovingStrategy(BotMovingStrategyFactory.createBotMovingStrategy(botPlayerRequestDTO.getDifficultyLevel()))
                .user(
                        User
                                .builder()
                                .name(botPlayerRequestDTO.getName())
                                .build()
                )
                .symbol(botPlayerRequestDTO.getSymbol())
                .build();
    }
}
