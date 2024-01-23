package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.g_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomSortCars {
    public static void main(String[] args) {
        //create a list of cars.
        List<Car> carList = new ArrayList<>();
        carList.add(Car
                .builder()
                        .carBrand(CarBrand.AUDI)
                        .price(4000000)
                        .speed(250.5)
                .build()
        );
        carList.add(Car
                .builder()
                .carBrand(CarBrand.BUGGATI)
                .price(1000000)
                .speed(300.0)
                .build()
        );
        carList.add(Car
                .builder()
                .carBrand(CarBrand.SUZUKI)
                .price(3000000)
                .speed(150)
                .build()
        );
        carList.add(Car
                .builder()
                .carBrand(CarBrand.BMW)
                .price(9999993.3)
                .speed(340.5)
                .build()
        );
        //sort Cars based on  natural ordering of cars i.e., based on speed in ascending order.
        Collections.sort(carList);
        System.out.println(carList);
    }
}
