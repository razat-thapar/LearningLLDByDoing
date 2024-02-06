package com.lld.three.models.strategies.winning;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NInARowWinningStrategy implements WinningStrategy{
    private List<Map<Character,Integer>> rowsList;
    private int size;
    public NInARowWinningStrategy(int size){
        this.size = size;
        this.rowsList = new ArrayList<>();
        //initialize size count of HashMap<>
        for(int i=0;i<size;i++){
            rowsList.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkWin(Board board, Cell currentCell) {
        //approach: using currentCell row  and symbol, we will iterate over current row and check if every cell is non-empty and have same symbol.
        //TC: O(N) SC: O(1)
        //idea 2: Maintain HashMap<Symbol,Integer> for all N rows and check if after adding currentCell, it have count = N or not for that row.
        //TC: O(1) SC: O(N*players)

        //update the rowsList using currentCell.
        Map<Character,Integer> map = rowsList.get(currentCell.getRow());
        Character currentSymbol = currentCell.getSymbol();
        if(map.containsKey(currentSymbol)){
            map.put(currentSymbol,1 + map.get(currentSymbol));
        }else{
            map.put(currentSymbol,1);
        }
        //check if count = size.
        if(map.get(currentSymbol) == size){
            return true;
        }else{
            return false;
        }
    }
}
