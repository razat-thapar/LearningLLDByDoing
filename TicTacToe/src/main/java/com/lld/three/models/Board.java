package com.lld.three.models;

import com.lld.three.models.enums.CellState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int size; //N  means N*N square matrix.
    private List<List<Cell>> cells;
    private int emptyCells;//get's updated by updateBoardCell.

    public Board(int size){
        this.size = size;
        this.cells = createBoard(size);
        this.emptyCells = size*size;
    }
    private List<List<Cell>> createBoard(int size){
        List<List<Cell>> cells = new ArrayList<>();
        List<Cell> rowList ;
        for(int row=0;row<size;row++){
            //add a row.
            rowList = new ArrayList<>();
            for(int col=0;col<size;col++){
                //add cells in same row.
                rowList.add(new Cell(row,col, CellState.EMPTY));
            }
            cells.add(rowList);
        }
        return cells;
    }
    public String displayBoard(){
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                //board[i][j] cell.
                sb.append("| ");
                sb.append(cells.get(row).get(col).getSymbol());
                sb.append(" ");
            }
            sb.append("|");
            sb.append("\n");
        }
        return sb.toString();
    }
    public boolean hasEmptyCells(){
        if(emptyCells>0){
            return true;
        }
        return false;
    }
    public void decrementEmptyCells(){
        this.emptyCells--;
    }
    @Override
    public String toString(){
        return displayBoard();
    }
}
