package com.lld.one.k_streams_and_lambdas.c_functional_interface;

import com.lld.one.k_streams_and_lambdas.c_functional_interface.iterable_example.Node;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;

public class ImportantFunctionalInterfaces {
    public static void main(String[] args) {
        // Here is the List of important functional interfaces.

        //Runnable
            //Purpose: To run any task and is used by Threads.
            //Method Signature : void run()
        //Callable
            //Purpose: To run any task that return something and throw CheckedException and is used by Threads.
            //Method Signature : V call() throws Exception;

        //Comparable
            //Purpose: Natural Sorting of objects without explicitly defining Comparator<> for custom sorting.
            /*
            Lists (and arrays) of objects that implement this interface can be sorted automatically by Collections.sort (and Arrays.sort).
            Objects that implement this interface can be used as keys in a sorted map or as elements in a sorted set, without the need to specify a comparator.
            */
            //Method Signature:  public int compareTo(T t);
            // compares   :   this  with  input
            // e.g.,
            Integer i = 2;
            switch (i.compareTo(5)){
                case -1 :
                    System.out.println("Less than input");
                    break;
                case 0 :
                    System.out.println("equals to input");
                    break;
                case 1:
                    System.out.println("greater than input");
                    break;
            }
            //Returns: a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.

        //Comparator
            //Purpose: Custom Sorting
            /*
            Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order.
            Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a natural ordering.
             */
            //Method Signature: int compare(T o1, T o2);
            List<Integer> integerList = new ArrayList<>();
            integerList.add(-1);
            integerList.add(2);
            integerList.add(3);
            //custom sort based on value order by descending order.
            Collections.sort(integerList, new Comparator<Integer>(){
                @Override
                public int compare(Integer a , Integer b){
                    if(a.intValue() > b.intValue()){
                        return -1; // a comes first.
                    }else if(a.intValue() < b.intValue()){
                        return 1; // b comes first.
                    }else {
                        return 0;
                    }
                }
            });
            System.out.println(integerList);

        //Iterable
            //Purpose: Implementing this interface allows an object to be the target of the enhanced for statement (sometimes called the "for-each loop" statement).
            //Method Signature: Iterator<T> iterator();
        //e.g., following is my custom Node class that implements Iterable.
        Node head ;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        for(Node node : head){
            System.out.println(node.data);
        }

        //Consumer
            //PURPOSE : to accept one or two parameters and return nothing.
            //Method Signature : void accept(T t)
        //BiConsumer
            //Method Signature : void accept(T1 t1, T2 t2)

        //Predicate
            //Purpose: to test one or two generic parameters and return boolean.
            //Method Signature : boolean test(T t);
        //BiPredicate
            //Method Signature : boolean test(T1 t1, T2 t2);

        //Function
            //Purpose: to apply one or two generic parameters and return any generic type.
            //Method Signature : R apply(T t);
        //BiFunction
            //Method Signature : R apply(T1 t1, T2 t2);

        //UnaryOperator
            //Purpose: to apply one generic parameter and return same type.
            //Method Signature : T apply(T t);
        //BinaryOperator
            //Purpose: to apply two generic parameters of same type and return same type.
            //Method Signature : T apply(T1 t1, T2 t2);
    }
}
