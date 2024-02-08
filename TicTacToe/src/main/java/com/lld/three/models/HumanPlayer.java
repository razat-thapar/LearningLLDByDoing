package com.lld.three.models;

import com.lld.three.strategies.input.HumanPlayerInputStrategy;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class HumanPlayer extends Player{
    private String email;
    private HumanPlayerInputStrategy humanPlayerInputStrategy;
    @Override
    public Move makeMove(Board board) {
        return humanPlayerInputStrategy.makeMove(board);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Human { name: ");
        sb.append(this.getUser().getName());
        sb.append(" }");
        return sb.toString();
    }
}
