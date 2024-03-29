package com.lld.one.h_synchronization_with_semaphores.a_producer_consumer_problem;

public class Item {
    private static int counter = 0;
    private String type ;
    private int serial_no ;
    public Item(String type){
        counter++;
        this.serial_no = counter;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", serial_no=" + serial_no +
                '}';
    }
}
