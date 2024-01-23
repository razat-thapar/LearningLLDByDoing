package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.g_comparable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Car implements Comparable<Car>{
    private CarBrand carBrand;
    private double speed;
    private double price;

    @Override
    public int compareTo(Car o) {
        if(this.getSpeed()<o.getSpeed()){
            return -1;//this comes first.
        }else if(this.getSpeed() > o.getSpeed()){
            return 1; //input comes first.
        }else{
            return 0; //both are equal.
        }
    }
}
