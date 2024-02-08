package com.lld.three.factories;

import com.lld.three.models.enums.WinningStrategyType;
import com.lld.three.strategies.winning.*;

//a simple factory pattern.
public class WinningStrategyFactory {
    public static WinningStrategy createWinningStrategy(WinningStrategyType winningStrategyType, int boardSize){
        return switch (winningStrategyType) {
            case N_IN_A_COL -> new NInAColWinningStrategy(boardSize);
            case N_IN_A_ROW -> new NInARowWinningStrategy(boardSize);
            case N_IN_A_DIAG -> new NInADiagWinningStrategy();
            case N_IN_A_ANTI_DIAG -> new NInAAntiDiagWinningStrategy();
            default -> throw new RuntimeException("Invalid strategy Type!");
        };
    }
}
