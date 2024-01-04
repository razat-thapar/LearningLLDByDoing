package com.lld.two.d_prototype_registry_pattern.b_prototype_pattern.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BackgroundObject implements GraphicalObject{
    private double x ;
    private double y ;
    private double z ;
    private BackgroundObjectType type ;
    private List<Integer> pixels ;

    //Step 3: Create a copy constructor.
    public BackgroundObject(BackgroundObject other){
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.type = other.type;
        //deep copy list.
        this.pixels = other.pixels.stream().collect(Collectors.toList());
    }
    @Override
    public BackgroundObject clone() {
        return new BackgroundObject(this);
    }
}
