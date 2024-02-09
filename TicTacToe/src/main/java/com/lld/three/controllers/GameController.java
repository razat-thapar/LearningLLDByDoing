package com.lld.three.controllers;

import com.lld.three.dtos.InitiateGameRequestDTO;
import com.lld.three.models.Game;
import com.lld.three.models.enums.GameState;
import com.lld.three.services.GameService;

import java.util.List;

public class GameController {
    public Game initiateGame(InitiateGameRequestDTO initiateGameRequestDTO){
        return GameService.buildGame("TicTacToe",initiateGameRequestDTO.getSize(),initiateGameRequestDTO.getWinningStrategyList(),initiateGameRequestDTO.getPlayerList());
    }

    public GameState startGame(Game game){
        return GameService.startGame(game);
    }

    public List<String> replayGame(Game game){
        return GameService.replayGame(game);
    }
}
