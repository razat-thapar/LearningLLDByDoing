package com.lld.three.services;

import com.lld.three.models.BotPlayer;
import com.lld.three.models.HumanPlayer;
import com.lld.three.models.Player;
import com.lld.three.models.User;
import com.lld.three.models.enums.DifficultyLevel;
import com.lld.three.factories.BotMovingStrategyFactory;
import com.lld.three.strategies.input.HumanPlayerInputStrategy;

public class PlayerService {
    public static Player createHumanPlayer(String name, Character symbol, HumanPlayerInputStrategy humanPlayerInputStrategy){
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
                .humanPlayerInputStrategy(humanPlayerInputStrategy)
                .build();
    }

    public static Player createBotPlayer(String name, Character symbol, DifficultyLevel difficultyLevel){
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
