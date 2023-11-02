package com.lld.one.b_access_modifier_constructor.demo_constructors;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class ClientLinkedListDemo {
    public static void main(String[] args){
        //Scenario 1: Creating a new Linked List.
        int size=6;
        //creating a new node using parameterized constructor.
        LinkedListNode head1 = new LinkedListNode(1);
        int i=2;
        while(i<=size){
            LinkedListNode.insertAtTail(head1,i);
            i++;
        }
        System.out.println(head1);
        //Scenario 2: Creating a deep copy of head1 using copy constructor.
        LinkedListNode head2 = new LinkedListNode(head1);
        System.out.println(head2);
    }
}
