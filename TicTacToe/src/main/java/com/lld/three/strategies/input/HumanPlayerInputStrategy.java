package com.lld.three.strategies.input;

import com.lld.three.models.Board;
import com.lld.three.models.Move;
public interface HumanPlayerInputStrategy {
    public Move makeMove(Board board);
}
