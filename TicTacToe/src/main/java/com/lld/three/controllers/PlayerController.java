package com.lld.three.controllers;
import com.lld.three.dtos.BotPlayerRequestDTO;
import com.lld.three.dtos.HumanPlayerRequestDTO;
import com.lld.three.models.Player;
import com.lld.three.strategies.input.CommandLineInputStrategy;
import com.lld.three.services.PlayerService;
//Just a Facade.
//DTO's are used only at controller layer, service layer needs primitive,Model classes as parameters.
public class PlayerController {

    public Player createHumanPlayer(HumanPlayerRequestDTO humanPlayerRequestDTO){
        return PlayerService.createHumanPlayer(humanPlayerRequestDTO.getName(),humanPlayerRequestDTO.getSymbol(), CommandLineInputStrategy.getInstance());
    }

    public Player createBotPlayer(BotPlayerRequestDTO botPlayerRequestDTO) {
        return PlayerService.createBotPlayer(botPlayerRequestDTO.getName(),botPlayerRequestDTO.getSymbol(),botPlayerRequestDTO.getDifficultyLevel());
    }
}
