package com.lld.one.h_synchronization_with_semaphores.d_bestfix2_semaphores_concurrent_datastructures;

public class Item {
    private static int counter = 0;
    private String type ;
    private int serial_no ;
    public Item(String type){
        //class level locking.
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
