package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.f_comparator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Car {
    private CarBrand carBrand;
    private double speed;
    private double price;
}
