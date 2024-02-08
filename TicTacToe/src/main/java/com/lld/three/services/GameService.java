package com.lld.three.services;

import com.lld.three.models.*;
import com.lld.three.models.enums.GameState;
import com.lld.three.strategies.winning.WinningStrategy;

import java.util.List;

public class GameService {
    public static Game buildGame(String name, int size,List<WinningStrategy> winningStrategyList,List<Player> playerList){
        return new Game(name  ,size,winningStrategyList,playerList);
    }
    public static GameState startGame(Game game){
        //change the state of game to IN_PROGRESS.
        game.setGameStatus(GameState.IN_PROGRESS);
        return executeGame(game);
    }
    private static GameState executeGame(Game game){
        Board board = game.getBoard();
        //will keep checking.
        while(board.hasEmptyCells()){
            //display board.
            System.out.println(board.displayBoard());
            //trigger makeMove for the game.
            Move move = makeMove(game);
            //TriggerCheckwin()
            if(checkWin(game,move)){
                game.setGameStatus(GameState.SUCCESS);
                //set the winner.
                game.setWinner(board.getCells().get(move.getRow()).get(move.getCol()).getPlayer());
                return GameState.SUCCESS;
            }
        }
        //change the state of game to DRAW.
        game.setGameStatus(GameState.DRAW);
        return GameState.DRAW;
    }

    private static Move makeMove(Game game){
        //get the nextPlayer.
        int nextPlayerIndex = game.getNextPlayerIndex();
        List<Player> playerList = game.getPlayerList();
        Player nextPlayer = playerList.get(nextPlayerIndex);
        System.out.printf("%s turn!%n",nextPlayer.getUser().getName());
        //invoke makeMove() behavior of nextPlayer.
        Move move = nextPlayer.makeMove(game.getBoard());
        //update board.
        BoardService.updateBoardCell(game.getBoard(),move,nextPlayer);
        //update nextPlayerIndex()
        game.updateNextPlayerIndex();
        return move;
    }
    private static boolean checkWin(Game game, Move move){
        Board board = game.getBoard();
        Cell cell = board.getCells().get(move.getRow()).get(move.getCol());
        for(WinningStrategy winningStrategy : game.getWinningStrategyList()){
            if(winningStrategy.checkWin(board,cell)){
                return true;
            }
        }
        return false;
    }


}
