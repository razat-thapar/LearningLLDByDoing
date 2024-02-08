package com.lld.three.strategies.bot;

import com.lld.three.models.Board;
import com.lld.three.models.Move;

public interface BotMovingStrategy {
    Move makeMove(Board board);
}
