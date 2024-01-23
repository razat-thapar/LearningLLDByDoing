package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.e_operator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        //demo for unary operator.
        UnaryOperator<Integer> additiveInverse = (num) -> { return -1*num;};
        System.out.printf("Additive Inverse of %d is : %d%n",2,additiveInverse.apply(2));

        //demo for binary operator.
        BinaryOperator<Integer> addition = (num1,num2) -> { return num1+num2;};
        System.out.printf("Addition of %d & %d is : %d",2,3,addition.apply(2,3));
    }
}
