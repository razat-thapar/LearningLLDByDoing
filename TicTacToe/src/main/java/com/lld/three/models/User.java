package com.lld.three.models;

import com.lld.three.models.enums.PlayerType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//holds intrinsic properties of a player.
//flyweight
@Getter
@Setter
@Builder
public class User {
    private String name;
    private PlayerType playerType;
    private Byte[] image;
}
