package com.lld.three.models;
import com.lld.three.models.enums.GameState;
import com.lld.three.strategies.winning.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Game {

    private String name ;
    private Board board ;
    private List<Player> playerList;
    private GameState gameStatus;
    private List<WinningStrategy> winningStrategyList;
    private int nextPlayerIndex ; // to alternate between players.
    private Player winner = null; //to store the winner of the game.
    //to create a game instance
    public Game(String name , int size, List<WinningStrategy> winningStrategyList, List<Player> playerList){
        this.name = name;
        this.board = new Board(size);
        this.playerList = playerList;
        this.winningStrategyList = winningStrategyList;
        this.gameStatus = GameState.INITIAL;
        this.nextPlayerIndex = 0; //first player.
    }
    public void moveNextPlayerIndex(){
        nextPlayerIndex = (nextPlayerIndex+1)%playerList.size();
    }
    public void moveBackNextPlayerIndex(){
        nextPlayerIndex = ((nextPlayerIndex-1)%playerList.size()+playerList.size())%playerList.size();
    }
}
