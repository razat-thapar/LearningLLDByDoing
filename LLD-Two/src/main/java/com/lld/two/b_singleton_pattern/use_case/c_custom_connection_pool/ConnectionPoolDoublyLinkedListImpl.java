package com.lld.two.b_singleton_pattern.use_case.c_custom_connection_pool;
import java.util.Map; 
import java.util.HashMap;


//Data Structure: Two Doubly Linked Lists + HashMap<DatabaseConnection, Node>
//PROS: All insert, delete, search operations in O(1) time.
//CONS: Understandability and Maintainability could be improved.
// Due to more no lines of code than required, we are making code reviews for seniors challenging.
// it may be hard to understand for other new developers.
public class ConnectionPoolDoublyLinkedListImpl implements ConnectionPool {
    //approach for part 1: Double check locking. 
    //approach for Part 2: Maintain two Doubly LinkedList used, available and maintain HashMap<Connection,Node> for used connections.
    private Node usedHead ;
    private Node usedTail;
    private Node availableHead;
    private Node availableTail;
    private Map<DatabaseConnection,Node> map;
    private int availableCount;
    private int maxConnections;
    private static ConnectionPoolDoublyLinkedListImpl instance = null;
    private ConnectionPoolDoublyLinkedListImpl(int maxConnections){
        this.usedHead = null;
        this.usedTail = null;
        this.availableHead = null;
        this.availableTail = null;
        this.map = new HashMap<>();
        this.availableCount = 0;
        this.maxConnections = maxConnections;
    }
    @Override
    public void initializePool() {
        while(availableCount < maxConnections){
            DatabaseConnection dbconn = new DatabaseConnection();
            Node newN = new Node(dbconn);
            boolean insertInAvailable = true;
            //inserts a given node in available linked list. 
            Node.insert(this,newN,insertInAvailable);
            availableCount++;
        }
    }

    @Override
    public synchronized DatabaseConnection getConnection() {
        if(availableCount > 0){
            //we need to remove head node from available linked list and return. 
            boolean removeFromAvailable = true;
            Node node = Node.remove(this,this.availableHead,removeFromAvailable);
            this.availableCount--;
            //we need to insert this node into used linked list. 
            boolean insertInAvailable = false;
            Node.insert(this,node,insertInAvailable);
            //we need to update the hm . 
            map.put(node.data,node);
            return node.data;
        }
        return null;
    }

    @Override
    public synchronized void releaseConnection(DatabaseConnection connection) {
        //validate if connection exist in used linked list. using map. 
        if(availableCount < maxConnections && map.containsKey(connection)){
            Node node = map.get(connection);
            //remove the node from the used linked list 
            boolean removeFromAvailable = false;
            Node.remove(this,node,removeFromAvailable);
            //remove from map. 
            map.remove(connection);
            //insert this node into available Linked list. 
            boolean insertInAvailable = true;
            Node.insert(this,node,insertInAvailable);
            this.availableCount++;
        }
    }

    @Override
    public int getAvailableConnectionsCount() {
        return availableCount;
    }

    @Override
    public int getTotalConnectionsCount() {
        return maxConnections;
    }

    public static ConnectionPool getInstance(int maxConnections){
        if(instance == null){
            synchronized(ConnectionPoolDoublyLinkedListImpl.class){
                if(instance == null){
                    instance = new ConnectionPoolDoublyLinkedListImpl(maxConnections);
                    return instance;
                }
            }
        }
        return instance;
    }

    public static void resetInstance(){
        instance = null;
    }

    public class Node{
        public DatabaseConnection data;
        public Node next ;
        public Node prev ;
        public Node(DatabaseConnection data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        //inserts a new node at tail of given linked list and updates counts. 
        public synchronized static void insert(ConnectionPoolDoublyLinkedListImpl pool, Node newN , boolean insertInAvailable){
            //check which linked list. 
            Node head = null, tail =null ;
            //double check if node is having no pointers. 
            newN.prev = null;
            newN.next = null;

            if(insertInAvailable){
                head = pool.availableHead;
                tail = pool.availableTail;
            }else{
                head = pool.usedHead;
                tail = pool.usedTail;
            }
            if(head == null){
                head = newN;
                tail = newN;
            }else{
                tail.next = newN;
                newN.prev = tail;
                tail = newN;
            }
            if(insertInAvailable){
                pool.availableHead = head;
                pool.availableTail = tail;
            }else{
                pool.usedHead = head;
                pool.usedTail = tail;
            }
        }
        //removes the node and update the head , tail in the pool of the mentioned list. 
        public synchronized static Node remove(ConnectionPoolDoublyLinkedListImpl pool, Node node, boolean removeFromAvailable){
            //check which linked list. 
            Node head = null, tail =null ;
            if(removeFromAvailable){
                head = pool.availableHead;
                tail = pool.availableTail;
            }else{
                head = pool.usedHead;
                tail = pool.usedTail;
            }
            if(node.prev == null){
                //case 1: remove from head.
                Node next = node.next;
                if(next!=null){
                    node.next = null;
                    next.prev = null;
                }
                head = next;
            }else if(node.next == null){
                //case 2: remove from tail  
                Node prev = node.prev;
                node.prev = null ;
                prev.next = null;
                tail = prev;
            }else{
                //case 3: middle node. 
                Node prev = node.prev;
                Node next = node.next;
                //break the links 
                node.prev = null;
                prev.next = next;
                node.next = null;
                next.prev = prev;
            }
            if(removeFromAvailable){
                pool.availableHead = head;
                pool.availableTail = tail;
            }else{
                pool.usedHead = head;
                pool.usedTail = tail;
            }
            return node;
        }
    }
}