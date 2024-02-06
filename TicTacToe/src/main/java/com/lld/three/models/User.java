package com.lld.three.models;

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
    private Byte[] image;
}
