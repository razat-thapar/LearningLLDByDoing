package com.lld.three.models.strategies.bot;

import com.lld.three.models.Board;
import com.lld.three.models.Move;

public class MinMaxMovingStrategy implements BotMovingStrategy {
    //TODO: Implement HARD strategy.

    private static MinMaxMovingStrategy instance = null;
    private MinMaxMovingStrategy(){

    }
    public static MinMaxMovingStrategy getInstance(){
        //double check locking.
        if(instance == null){
            synchronized (MinMaxMovingStrategy.class){
                if(instance == null){
                    instance = new MinMaxMovingStrategy();
                    return instance;
                }
            }
        }
        return instance;
    }
    @Override
    public Move makeMove(Board board) {
        return null;
    }
}
