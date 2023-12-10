package com.lld.one.j_collections.a_iterator;

import java.util.Iterator;

public class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    static class NodeIterator implements Iterator<Integer> {
        private Node curr;
        @Override
        public boolean hasNext() {
            return curr!=null;
        }

        @Override
        public Integer next() {
            int temp = curr.data;
            //move
            curr=curr.next;
            return temp;
        }
    }
}
