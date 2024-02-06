package com.lld.three.models;

import com.lld.three.models.enums.CellState;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Getter
@Setter
@SuperBuilder
public class HumanPlayer extends Player{
    private String email;
    //TODO : implement play method of humanPlayer.
    @Override
    public Move makeMove(Board board) {
        //based on commandLine.
        Scanner sc = new Scanner(System.in);
        String name = this.getUser().getName();
        int row,col,boardSize = board.getSize();
        do{
            System.out.printf("%s enter the row number (1-based) : %n",name);
            row = sc.nextInt();
            System.out.printf("%s enter the column number (1-based) : %n",name);
            col = sc.nextInt();
            if(validateCellInput(row,col,board)){
                break;
            }
            System.out.println("Please re-enter the cell!");
        }while(true);
        return new Move(row-1,col-1);
    }
    private boolean validateCellInput(int row, int col, Board board){
        int boardSize = board.getSize();
        if(row>=1 && row<=boardSize
                && col>=1 && col<=boardSize
                    && board.getCells().get(row-1).get(col-1).getCellState() == CellState.EMPTY){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Human { name: ");
        sb.append(this.getUser().getName());
        sb.append(" }");
        return sb.toString();
    }
}
