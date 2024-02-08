package com.lld.three.strategies.winning;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;

import java.util.HashMap;
import java.util.Map;

public class NInAAntiDiagWinningStrategy implements WinningStrategy{
    private Map<Character,Integer> map;
    public NInAAntiDiagWinningStrategy(){
        this.map = new HashMap<>();
    }
    @Override
    public boolean checkWin(Board board, Cell currentCell) {
        //Approach 1: check if currentCell is part of anti-diag , if yes then traverse the anti diag and compare symbol of currentCell with each cell and get countMatching cells and if count==size return true.
        //TC: O(N) SC: O(1)
        //Approach 2: Maintain HashMap<Character,Integer> map, for every currentCell, we will check
        // 1. if currentCell is part of anti-diag or not. if no , return false else update map.
        // 2. validate if currentCell symbol have count == size , if yes return true else return false.
        //TC: O(1) SC: O(N*no of players)

        //check if anti-diagonal cell. (row,col) where row+col = size-1
        Character currentSymbol = currentCell.getSymbol();
        int row = currentCell.getRow();
        int col = currentCell.getCol();
        if(row+col!= (board.getSize()-1)){
            return false;
        }
        //update map.
        if(map.containsKey(currentSymbol)){
            map.put(currentSymbol, 1 + map.get(currentSymbol));
        }else{
            map.put(currentSymbol,1);
        }
        //check if count == size.
        if(map.get(currentSymbol) == board.getSize()){
            return true;
        }else{
            return false;
        }
    }
}
