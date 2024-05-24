package com.lld.one.h_concurrency_volatile;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SharedVariable {
    private volatile boolean doPrint;
    public SharedVariable() {
        this.doPrint=true;
    }
    public void setDoPrint(boolean doPrint) {
        this.doPrint = doPrint;
        System.out.printf("%s has updated value to false!%n",Thread.currentThread().getName());
    }
}
