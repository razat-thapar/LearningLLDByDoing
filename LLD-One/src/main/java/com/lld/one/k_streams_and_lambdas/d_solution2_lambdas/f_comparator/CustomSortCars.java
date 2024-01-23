package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.f_comparator;

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
        //custom sort this list of cars based on price in descending order using Lamdas.
        Collections.sort(carList,(car1,car2)->{
            if(car1.getPrice()>car2.getPrice()){
                return -1; //car 1 comes first.
            }else if(car1.getPrice()<car2.getPrice()){
                return 1; //car 2 comes first
            }else{
                return 0; //both are equal.
            }
        });
        System.out.println(carList);
    }
}
