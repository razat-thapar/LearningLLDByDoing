package com.lld.three.models;

import com.lld.three.models.enums.DifficultyLevel;
import com.lld.three.models.strategies.bot.BotMovingStrategy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@SuperBuilder
public class BotPlayer extends Player{
    private DifficultyLevel difficultyLevel;
    private BotMovingStrategy botMovingStrategy;
    @Override
    public Move makeMove(Board board) {
        //delegation.
        return botMovingStrategy.makeMove(board);
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Bot { name: ");
        sb.append(this.getUser().getName());
        sb.append(" }");
        return sb.toString();
    }
}
