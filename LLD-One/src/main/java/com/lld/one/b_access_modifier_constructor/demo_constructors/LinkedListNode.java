package com.lld.one.b_access_modifier_constructor.demo_constructors;

import javax.sound.sampled.Line;

public class LinkedListNode {
    private int data;
    private LinkedListNode next;

    //default constructor
    public LinkedListNode(){

    }
    //parameterized constructor.
    public LinkedListNode(int data){
        this(data,null);
    }
    public LinkedListNode(int data, LinkedListNode next){
        this.data=data;
        this.next= next;
    }
    //copy constructor with deepCopy
    public LinkedListNode(LinkedListNode other){
        //assumption: given node other, do deepCopy of LinkedList node.
        this.data = other.data;
        if(other.next==null){
            this.next = null;
        }else{
            this.next = new LinkedListNode(other.next);
        }
    }

    //insert a new node with given data at tail of given LinkedList.
    public static void insertAtTail(LinkedListNode head, int data) throws NullPointerException{
        LinkedListNode newN = new LinkedListNode(data);
        LinkedListNode curr = head;
        if(curr==null){
            throw new NullPointerException("head can't be null");
        }
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newN;
    }
}
