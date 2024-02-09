package com.lld.three.services;

import com.lld.three.models.*;
import com.lld.three.models.enums.CellState;
import com.lld.three.models.enums.GameState;
import com.lld.three.strategies.winning.WinningStrategy;

import java.util.ArrayList;
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
            //add this move in List<Move>
            game.getMoves().add(move);
            //ask human player if need to undo last move?
            if(CommandLineService.askIfNeedToUndoLastMove(game,move)){
                //remove last move from List<Move> if human did undo.
                game.getMoves().remove(game.getMoves().size()-1);
            }
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
    static void undoLastMove(Game game, Move recentMove){
        //revert
        //nextPlayerIndex.
        game.moveBackNextPlayerIndex();
        //Board state.
        BoardService.emptyBoardCell(game.getBoard(), recentMove);
    }

    private static Move makeMove(Game game){
        //get the nextPlayer.
        int nextPlayerIndex = game.getNextPlayerIndex();
        Player nextPlayer = game.getPlayerList().get(nextPlayerIndex);
        System.out.printf("%s turn!%n",nextPlayer.getUser().getName());
        //invoke makeMove() behavior of nextPlayer.
        Move move = nextPlayer.makeMove(game.getBoard());
        //update board.
        BoardService.updateBoardCell(game.getBoard(),move,nextPlayer);
        //update nextPlayerIndex()
        game.moveNextPlayerIndex();
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

    public static List<String> replayGame(Game game){
        List<String> snapshots = new ArrayList<>();
        //replay board.
        Board replayBoard = new Board(game.getBoard().getSize());
        //game board.
        Board gameBoard = game.getBoard();
        Cell cell;
        for(Move move : game.getMoves()){
            cell = replayBoard.getCells().get(move.getRow()).get(move.getCol());
            //set symbol.
            cell.setSymbol(gameBoard.getCells().get(move.getRow()).get(move.getCol()).getSymbol());
            snapshots.add(replayBoard.displayBoard());
        }
        return snapshots;
    }


}
