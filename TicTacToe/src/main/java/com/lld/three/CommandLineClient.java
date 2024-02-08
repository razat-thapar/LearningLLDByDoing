package com.lld.three;

import com.lld.three.controllers.GameController;
import com.lld.three.controllers.PlayerController;
import com.lld.three.dtos.BotPlayerRequestDTO;
import com.lld.three.dtos.HumanPlayerRequestDTO;
import com.lld.three.dtos.InitiateGameRequestDTO;
import com.lld.three.exceptions.InvalidPlayerCountException;
import com.lld.three.models.*;
import com.lld.three.models.enums.DifficultyLevel;
import com.lld.three.models.enums.GameState;
import com.lld.three.models.enums.WinningStrategyType;
import com.lld.three.factories.WinningStrategyFactory;
import com.lld.three.strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLineClient {
    private static Scanner sc = new Scanner(System.in);
    private static PlayerController playerController = new PlayerController();
    private static GameController gameController = new GameController();
    public static void main(String[] args) {
        //Command Line Client.

        //This will interact with players and interact with controller.
        System.out.println("Welcome to TicTacToe Commandline Interface!");
        //ask user to provide size of board
        System.out.println("Please provide the size of Board: ");
        int size = sc.nextInt();
        int players;
        while(true){
            System.out.println("Please provide no of Players : ");
            players = sc.nextInt();
            try{
                if(players>=size){
                    throw new InvalidPlayerCountException("Re-enter : Player count exceeds board size, only size-1 players allowed!");
                }
                if(players==1){
                    throw new InvalidPlayerCountException("Re-enter : Atleast 2 players are required to play TicTacToe!");
                }
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //player details .
        List<Player> playerList = askPlayerDetails(players);

        //Winning Strategy
        List<WinningStrategy> winningStrategyList = askWinningStrategy(size);

        //initiate the game.
        System.out.println("Creating a new Tic Tac Toe Game...");
        Game game = gameController.initiateGame(InitiateGameRequestDTO
                .builder()
                .playerList(playerList)
                .winningStrategyList(winningStrategyList)
                .size(size)
                .build());
        //start the game.
        //Steps:
        //1. we have to alternate between players until board is full.
        //2. we have to execute nextMove() behavior of each player.
        //2. for human player, we need to take row,col from the command line and pass to player.
        //3. then checkWin() will be triggered after nextMove()
        //start --> while(board.hasEmptyCells()){
        //  game.nextMove()
        // }
        GameState gameState = gameController.startGame(game);
        //display the final board.
        System.out.println(game.getBoard());
        if(gameState==GameState.SUCCESS){
            System.out.printf("%s won the game!%n",game.getWinner());
        }else{
            System.out.println("The Game Ended in Draw!");
        }
        //TODO: Undo operation.
        //TODO: Replay the moves.
    }
    private static List<Player> askPlayerDetails(int players){
        List<Player> playerList = new ArrayList<>();
        for(int i=0;i<players;i++){
            System.out.printf("Please enter details of Players : %d %n",i+1);
            System.out.println("name : ");
            String name = sc.next();
            System.out.println("symbol: ");
            Character symbol = sc.next().toCharArray()[0]; // get 1st character.
            System.out.println("Is it a bot or not ? y or n");
            String isBot = sc.next();
            if(isBot.equals("y")){
                System.out.printf("Difficulty Level of Bot ? Press %n");
                Arrays.stream(DifficultyLevel.values()).forEach((lvl)->{
                    System.out.printf("%d : %s %n",lvl.ordinal(),lvl);
                });
                int level = sc.nextInt();
                Player player = playerController.createBotPlayer(BotPlayerRequestDTO
                        .builder()
                        .difficultyLevel(DifficultyLevel.values()[level])
                        .name(name)
                        .symbol(symbol)
                        .build());
                playerList.add(player);
            }else {
                Player player = playerController.createHumanPlayer(HumanPlayerRequestDTO
                        .builder()
                        .name(name)
                        .symbol(symbol)
                        .build());
                playerList.add(player);
            }
        }
        return playerList;
    }
    private static List<WinningStrategy> askWinningStrategy(int size){
        //option to choose default winning or custom winning strategies.
        System.out.printf("Do you want custom winning strategy? y or n %n");
        char ch = sc.next().charAt(0);
        List< WinningStrategy> winningStrategyList = new ArrayList<>();
        if(ch=='y'){
            //pick the winning strategies.
            System.out.println("Please choose the winning strategies!");
            Arrays.stream(WinningStrategyType.values()).forEach((type)->{
                System.out.printf(" %d : %s %n",type.ordinal(),type);
            });
            System.out.println("Please enter the count followed by corresponding strategy numbers in same line!");
            int count = sc.nextInt();
            WinningStrategyType type;
            while(count>0){
                //get the enum type from ordinal.
                type = WinningStrategyType.values()[sc.nextInt()];
                winningStrategyList.add(WinningStrategyFactory.createWinningStrategy(type,size));
                count--;
            }
        }else{
            //add all winning strategies available.
            Arrays.stream(WinningStrategyType.values()).forEach((type)->{
                winningStrategyList.add(WinningStrategyFactory.createWinningStrategy(type,size));
            });
        }
        return winningStrategyList;
    }
}
