package com.lld.three.models.strategies.winning;

import com.lld.three.models.Board;
import com.lld.three.models.Cell;

public interface WinningStrategy {
    boolean checkWin(Board board, Cell currentCell);
}
