package com.lld.three.controllers;

import com.lld.three.dtos.InitiateGameRequestDTO;
import com.lld.three.models.Game;
import com.lld.three.models.enums.GameState;
import com.lld.three.services.GameService;

public class GameController {
    private GameService gameService;
    public GameController(GameService gameService){
        this.gameService = gameService;
    }
    public Game initiateGame(InitiateGameRequestDTO initiateGameRequestDTO){
        return gameService.buildGame("TicTacToe",initiateGameRequestDTO.getSize(),initiateGameRequestDTO.getWinningStrategyList(),initiateGameRequestDTO.getPlayerList());
    }

    public GameState startGame(Game game){
        return gameService.startGame(game);
    }
}
