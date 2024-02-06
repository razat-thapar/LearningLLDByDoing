package com.lld.three.models.strategies.bot;

import com.lld.three.models.Board;
import com.lld.three.models.Move;

public class GptMovingStrategy implements BotMovingStrategy {
    //TODO: Implement medium strategy

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
        return null;
    }
}
