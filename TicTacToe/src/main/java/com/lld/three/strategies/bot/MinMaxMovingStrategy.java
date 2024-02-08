package com.lld.three.strategies.bot;

import com.lld.three.models.Board;
import com.lld.three.models.Move;

public class MinMaxMovingStrategy implements BotMovingStrategy {

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
        //TODO: implement Medium bot strategy.
        return null;
    }
}
