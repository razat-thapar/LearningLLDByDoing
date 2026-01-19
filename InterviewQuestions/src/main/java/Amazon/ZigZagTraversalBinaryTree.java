package Amazon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversalBinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static Node createTree() {
        //creating a new tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static void main(String[] args) {
        Node root = createTree();
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Node root){

        Deque<Node> dq = new LinkedList<>();
        boolean isRight = false;
        boolean isFront = true;
        int nodesInLevel = 0;
        //kick start
        dq.addLast(root);
        //nodesInLevel++;
        nodesInLevel = dq.size();

        Node node;
        while(!dq.isEmpty()){
            //front
            if(isFront){
                node = dq.removeFirst();
                nodesInLevel--;
            }else{
                node = dq.removeLast();
                nodesInLevel--;
            }
            //print
            System.out.print(node.data + " " );
            //push children.
            if(isRight){
                if(node.right!=null){
                    if(isFront){
                        dq.addLast(node.right);
                    }else{
                        dq.addFirst(node.right);
                    }
                }
                if(node.left!=null){
                    if(isFront){
                        dq.addLast(node.left);
                    }else{
                        dq.addFirst(node.left);
                    }
                }
            }else{
                if(node.left!=null){
                    if(isFront){
                        dq.addLast(node.left);
                    }else{
                        dq.addFirst(node.left);
                    }
                }
                if(node.right!=null){
                    if(isFront){
                        dq.addLast(node.right);
                    }else{
                        dq.addFirst(node.right);
                    }
                }
            }
            //reset.
            if(nodesInLevel == 0){
                nodesInLevel = dq.size();
                isRight = !isRight;
                isFront = !isFront;
            }
        }
    }
}

