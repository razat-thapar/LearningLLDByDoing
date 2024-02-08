package com.lld.three.strategies.bot;

import com.lld.three.models.Board;
import com.lld.three.models.Move;

public class GptMovingStrategy implements BotMovingStrategy {

    private static GptMovingStrategy instance = null;
    private GptMovingStrategy(){

    }
    public static GptMovingStrategy getInstance(){
        //double check locking.
        if(instance == null){
            synchronized (GptMovingStrategy.class){
                if(instance == null){
                    instance = new GptMovingStrategy();
                    return instance;
                }
            }
        }
        return instance;
    }
    @Override
    public Move makeMove(Board board) {
        //TODO: implement Hard bot strategy.
        return null;
    }
}
