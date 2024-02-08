package com.lld.three.factories;

import com.lld.three.exceptions.InvalidDifficultyLevelException;
import com.lld.three.models.enums.DifficultyLevel;
import com.lld.three.strategies.bot.BotMovingStrategy;
import com.lld.three.strategies.bot.GptMovingStrategy;
import com.lld.three.strategies.bot.MinMaxMovingStrategy;
import com.lld.three.strategies.bot.RandomMovingStrategy;

public class BotMovingStrategyFactory {
    public static BotMovingStrategy createBotMovingStrategy(DifficultyLevel difficultyLevel){
        switch(difficultyLevel){
            case EASY : return RandomMovingStrategy.getInstance();
            case MEDIUM: return MinMaxMovingStrategy.getInstance();
            case HARD: return GptMovingStrategy.getInstance();
            default: throw new InvalidDifficultyLevelException("Invalid Difficulty level");
        }
    }
}
