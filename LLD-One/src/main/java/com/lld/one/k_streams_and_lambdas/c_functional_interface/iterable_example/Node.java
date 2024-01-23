package com.lld.one.k_streams_and_lambdas.c_functional_interface.iterable_example;

import java.util.Iterator;

public class Node implements Iterable<Node>{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data ;
        this.next = null;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(this);
    }
    public class NodeIterator implements Iterator<Node>{
        private Node currNode;
        public NodeIterator(Node currNode){
            this.currNode = currNode;
        }

        @Override
        public boolean hasNext() {
            return (currNode.next!=null);
        }

        @Override
        public Node next() {
            //we need to traverse to next node of currNode
            Node temp = currNode;
            //move currNode.
            currNode = currNode.next;
            //return temp
            return temp;
        }
    }

}
