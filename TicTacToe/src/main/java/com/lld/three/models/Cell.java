package com.lld.three.models;

import com.lld.three.models.enums.CellState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private Integer row;
    private Integer col;
    private CellState cellState= CellState.EMPTY; //default value.
    private Character symbol = ' '; //default value. //to track the symbol placed.
    private Player player = null; //default value. //to track which player placed the symbol.

    public Cell(Integer row, Integer col, CellState cellState){
        this.row = row;
        this.col = col;
        this.cellState = cellState;
    }
}
