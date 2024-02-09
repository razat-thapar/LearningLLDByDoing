package com.lld.three.services;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;
import com.lld.three.models.Move;
import com.lld.three.models.Player;
import com.lld.three.models.enums.CellState;

public class BoardService {
    public static void updateBoardCell(Board board, Move move, Player player){
        Cell cell = board.getCells().get(move.getRow()).get(move.getCol());
        //update player and cellstate.
        cell.setCellState(CellState.OCCUPIED);
        cell.setSymbol(player.getSymbol());
        cell.setPlayer(player);
        //decrement board empty cell count.
        board.decrementEmptyCells();
    }
    public static void emptyBoardCell(Board board, Move move){
        Cell cell = board.getCells().get(move.getRow()).get(move.getCol());
        //update player and cellstate.
        cell.setCellState(CellState.EMPTY);
        cell.setSymbol(' ');
        cell.setPlayer(null);
        //increment board empty cell count.
        board.incrementEmptyCells();
    }
}
