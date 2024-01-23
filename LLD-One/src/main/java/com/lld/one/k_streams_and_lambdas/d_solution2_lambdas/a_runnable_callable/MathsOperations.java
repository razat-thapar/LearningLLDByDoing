package com.lld.one.k_streams_and_lambdas.d_solution2_lambdas.a_runnable_callable;
@FunctionalInterface
public interface MathsOperations<E> {
    public abstract E operate(E a , E b);
}
