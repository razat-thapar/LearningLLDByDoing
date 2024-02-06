package com.lld.three.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Player {
    private Character symbol;
    private User user; //flyweight
    public abstract Move makeMove(Board board);
}
