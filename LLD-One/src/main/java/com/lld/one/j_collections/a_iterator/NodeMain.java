package com.lld.one.j_collections.a_iterator;

import java.util.ArrayList;

public class NodeMain {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail = head;
        for(int i=2;i<=10;i++){
            tail.next = new Node(i);
            //move tail.
            tail = tail.next;
        }
        //iterate over node using iterator.

    }
}
