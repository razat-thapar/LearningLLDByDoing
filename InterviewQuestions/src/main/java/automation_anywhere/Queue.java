package automation_anywhere;

class Queue<E>{
    private Node head;
    private Node tail;
    class Node{
        E data;
        Node next;
        public Node(E data){
            this.data = data;
        }
    }
    public Queue(){
        this.head = null;
        this.tail = null;
    }
    public void enqueue(E element){
        //add to tail.
        if(head == null){
            head = new Node(element);
            tail = head;
        }else{
            tail.next = new Node(element);
            //move tail.
            tail = tail.next;
        }
    }
    public E dequeue(){
        if(head==null){
            return null;
        }
        E temp = head.data;
        //move
        head = head.next;
        return temp;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public static void main(String[] args){
        Queue<Integer> q = new Queue<>();
        //
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
    }
}
