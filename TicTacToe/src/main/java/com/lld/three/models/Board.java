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
        String singleTab = "\t";
        String doubleTab = "\t\t";
        String pipeWithTab = "|\t";
        String pipe = "|";
        sb.append("\n");
        for(int row=-1;row<size;row++){
            for(int col=-1;col<size;col++){
                if(row==-1 && col==-1){
                    sb.append(doubleTab);
                    sb.append(singleTab);
                    //sb.append(singleTab);
                }else if(row==-1){
                    //print col number.
                    sb.append(singleTab);
                    sb.append(col+1);
                    sb.append(singleTab);
                }else if(col==-1){
                    //print row number.
                    sb.append(doubleTab);
                    sb.append(row+1);
                    sb.append(singleTab);
                }else{
                    //board[i][j] cell.
                    sb.append(pipeWithTab);
                    sb.append(cells.get(row).get(col).getSymbol());
                    sb.append(singleTab);
                }
            }
            if(row!=-1){
                sb.append(pipe);
                sb.append("\n");
            }
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
    public void incrementEmptyCells() { this.emptyCells++;}
    @Override
    public String toString(){
        return displayBoard();
    }
}
