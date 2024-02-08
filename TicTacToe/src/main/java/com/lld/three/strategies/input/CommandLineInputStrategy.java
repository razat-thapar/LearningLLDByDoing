package com.lld.three.strategies.input;

import com.lld.three.models.Board;
import com.lld.three.models.Move;
import com.lld.three.models.enums.CellState;
import java.util.Scanner;
//Use singleton design to get only one instance. 
public class CommandLineInputStrategy implements HumanPlayerInputStrategy{
    private static CommandLineInputStrategy instance = null;
    private CommandLineInputStrategy(){

    }
    public static CommandLineInputStrategy getInstance(){
        //double check locking.
        if(instance == null){
            synchronized (CommandLineInputStrategy.class){
                if(instance == null){
                    instance = new CommandLineInputStrategy();
                    return instance;
                }
            }
        }
        return instance;
    }
    @Override
    public Move makeMove(Board board) {
        //based on commandLine.
        Scanner sc = new Scanner(System.in);
        int row,col,boardSize = board.getSize();
        do{
            System.out.printf("enter the row number (1-based) : %n");
            row = sc.nextInt();
            System.out.printf("enter the column number (1-based) : %n");
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
}
