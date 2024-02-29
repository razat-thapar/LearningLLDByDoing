package com.lld.one.h_synchronization_with_semaphores.c_partial_fix2_semaphores;

public class Item {
    private static int counter = 0;
    private String type ;
    private int serial_no ;
    public Item(String type){
        synchronized (Item.class){
            counter++;
            this.serial_no = counter;
        }
        this.type = type;
    }
    public static int getCounter(){
        return counter;
    }
    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", serial_no=" + serial_no +
                '}';
    }
}
