package com.lld.three.controllers;
import com.lld.three.dtos.BotPlayerRequestDTO;
import com.lld.three.dtos.HumanPlayerRequestDTO;
import com.lld.three.models.BotPlayer;
import com.lld.three.models.HumanPlayer;
import com.lld.three.models.Player;
import com.lld.three.models.User;
import com.lld.three.services.PlayerService;
//Just a Facade.
//DTO's are used only at controller layer, service layer needs primitive,Model classes as parameters.
public class PlayerController {
    public PlayerService playerService;
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    public Player createHumanPlayer(HumanPlayerRequestDTO humanPlayerRequestDTO){
        return playerService.createHumanPlayer(humanPlayerRequestDTO.getName(),humanPlayerRequestDTO.getSymbol());
    }

    public Player createBotPlayer(BotPlayerRequestDTO botPlayerRequestDTO) {
        return playerService.createBotPlayer(botPlayerRequestDTO.getName(),botPlayerRequestDTO.getSymbol(),botPlayerRequestDTO.getDifficultyLevel());
    }
}
