package com.lld.three.strategies.winning;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NInAColWinningStrategy implements WinningStrategy{
    private List<Map<Character,Integer>> colsList;
    private int size;
    public NInAColWinningStrategy(int size){
        this.size = size;
        this.colsList = new ArrayList<>();
        //initialize size count of HashMap<>
        for(int i=0;i<size;i++){
            colsList.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkWin(Board board, Cell currentCell) {
        //approach: using currentCell col  and symbol, we will iterate over current col and check if every cell is non-empty and have same symbol.
        //TC: O(N) SC: O(1)
        //idea 2: Maintain HashMap<Symbol,Integer> for all N cols and check if after adding currentCell, it have count = N or not for that col.
        //TC: O(1) SC: O(N*players)

        //update the rowsList using currentCell.
        Map<Character,Integer> map = colsList.get(currentCell.getCol());
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
