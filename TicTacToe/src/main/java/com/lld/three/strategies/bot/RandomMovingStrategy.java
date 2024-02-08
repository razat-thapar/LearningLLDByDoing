package com.lld.three.strategies.bot;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;
import com.lld.three.models.Move;
import com.lld.three.models.enums.CellState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//singleton design pattern since, we need only one instance.
public class RandomMovingStrategy implements BotMovingStrategy {
    private List<Move> availableMoveList;
    private static RandomMovingStrategy instance = null;
    private RandomMovingStrategy(){

    }
    public static RandomMovingStrategy getInstance(){
        //double check locking.
        if(instance == null){
            synchronized (RandomMovingStrategy.class){
                if(instance == null){
                    instance = new RandomMovingStrategy();
                    return instance;
                }
            }
        }
        return instance;
    }
    private static Random random = new Random();
    @Override
    public Move makeMove(Board board) {
        //approach 1 : traverse the board and then populate List<Move> of empty cells and then pick any random move using Random class in java.
        //TC: O(N*N) SC: O(N*N)
        //approach 2: Maintain List<Move> --> to store all empty cells
        //            for every call, we will first iterate over list and delete all non-emtpy cells from List<Move> and update Set
        //                            pick any random index and return the move.
        //TC: O(N*N) SC: O(N*N)
        List<List<Cell>> cells = board.getCells();
        //populate the availableMoveList if it's null.
        if(availableMoveList == null){
            availableMoveList = new ArrayList<>();
            for(int row=0;row<cells.size();row++){
                for(int col=0;col<cells.get(0).size();col++){
                    if(cells.get(row).get(col).getCellState() == CellState.EMPTY){
                        availableMoveList.add(new Move(row,col));
                    }
                }
            }
//            cells.stream().forEach((rowCells)->{
//                rowCells.stream().forEach((cell)->{
//                    if(cell.getCellState()==CellState.EMPTY){
//                        availableMoveList.add(new Move(cell.getRow(),cell.getCol()));
//                    }
//                });
//            });
        }
        //remove all non-empty cells.
        Move move;
        int i=0;
        while(i<availableMoveList.size()){
            move = availableMoveList.get(i);
            //if non-empty
            if(cells.get(move.getRow()).get(move.getCol()).getCellState()!=CellState.EMPTY){
                //swap current Move with last Move in list
                swapMoves(i,availableMoveList.size()-1);
                //remove last.
                availableMoveList.remove(availableMoveList.size()-1);
            }else{
                //empty cell. //skip it.
                i++;
            }
        }
        //pick random.
        int idx = random.nextInt(availableMoveList.size());
        return availableMoveList.get(idx);
    }
    //helper method.
    public void swapMoves(int i, int j){
        Move temp = availableMoveList.get(i);
        availableMoveList.set(i,availableMoveList.get(j));
        availableMoveList.set(j,temp);
    }
}
