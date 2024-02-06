package com.lld.three.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

//This class act as a placerholder for the [row,col] pair returned by player.
//We didn't use Cell as we might need to fill symbol and other attributes as well.
@AllArgsConstructor
@Getter
public class Move {
    private Integer row;
    private Integer col;
}
