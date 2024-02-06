package com.lld.three.models.factories;

import com.lld.three.models.enums.WinningStrategyType;
import com.lld.three.models.strategies.winning.NInAColWinningStrategy;
import com.lld.three.models.strategies.winning.NInADiagWinningStrategy;
import com.lld.three.models.strategies.winning.NInARowWinningStrategy;
import com.lld.three.models.strategies.winning.WinningStrategy;

//a simple factory pattern.
public class WinningStrategyFactory {
    public static WinningStrategy createWinningStrategy(WinningStrategyType winningStrategyType, int boardSize){
        switch (winningStrategyType){
            case N_IN_A_COL : return new NInAColWinningStrategy(boardSize);
            case N_IN_A_ROW : return new NInARowWinningStrategy(boardSize);
            case N_IN_A_DIAG : return new NInADiagWinningStrategy(boardSize);
            default: throw new RuntimeException("Invalid strategy Type!");
        }
    }
}
