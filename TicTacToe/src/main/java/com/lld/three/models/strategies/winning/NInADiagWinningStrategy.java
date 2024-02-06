package com.lld.three.models.strategies.winning;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;

import java.util.HashMap;
import java.util.Map;

public class NInADiagWinningStrategy implements WinningStrategy{
    private Integer size;
    private Map<Character,Integer> map ;
    public NInADiagWinningStrategy(int size){
        //intiailize map.
        map = new HashMap<>();
        this.size = size;
    }

    @Override
    public boolean checkWin(Board board, Cell currentCell) {
        //approach 1: for currentCell, check if it's a diagonal cell. if yes then iterate over the every cell in diagonal (row-col = 0 ) and verify if same symbol or not.
        //TC: O(N)  SC: O(1)
        //approach 2: Maintain HashMap<Symbol,Integer> to store symbol,count for all diagonal cells.
        // if current cell is a diagonal cell, then we can update the map and then check if count == size.
        //TC: O(1) SC: O(N*no of players)

        //check if diagonal cell. (row,col) where row==col.
        Character currentSymbol = currentCell.getSymbol();
        int row = currentCell.getRow();
        int col = currentCell.getCol();
        if(row!=col){
            return false;
        }
        //update map.
        if(map.containsKey(currentSymbol)){
            map.put(currentSymbol, 1 + map.get(currentSymbol));
        }else{
            map.put(currentSymbol,1);
        }
        //check if count == size.
        if(map.get(currentSymbol) == size){
            return true;
        }else{
            return false;
        }
    }
}
