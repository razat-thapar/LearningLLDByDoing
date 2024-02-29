# Thread synchronisation

## Agenda
* Producer-consumer problem
* Semaphores
* Concurrent data structures
    * Atomic Integer
    * Concurrent Hash Map


## Producer-consumer problem

The Producer-Consumer problem is a classic synchronization problem in operating systems.

The problem is defined as follows: there is a fixed-size buffer and a Producer process, and a Consumer process.

The Producer process creates an item and adds it to the shared buffer. The Consumer process takes items out of the shared buffer and “consumes” them.

![Producer vs consumer](http://pages.cs.wisc.edu/~bart/537/lecturenotes/figures/s6-prodcons.jpg)

Certain conditions must be met by the Producer and the Consumer processes to have consistent data synchronisation:

* The Producer process must not produce an item if the shared buffer is full.

* The Consumer process must not consume an item if the shared buffer is empty.


### Producer
The task of the producer is to create a unit of work and add it to the store. The consumer will pick that up when it is available. The producer cannot add exceed the number of max units of the store.

```java
    public void run() {
        while (true) {
            if (store.size() < maxSizeOfStore) {
                store.add(new UnitOfWork());
            }
        }
    }
```

### Consumer
The role of the consumer is to pick up unit of works from the queue or the store once they have been added by the consumer. The consumer can only pick up units if there are any available.

```java
    public void run() {
        while (true) {
            if (store.size() > 0) {
                store.remove();
            }
        }
    }
```

The above code will lead to concurrency issues since multiple thread can access the store at one time.
What happens if there is only one unit present, but two consumers try to acquire it at the same time.
Since the size of the store will be 1, both of them will be allowed to execute, but one will error out.

### Base Solution - Mutex

In order to solver the concurrency issue, we can use mutexes or locks.
In Java this can be achieved by simply wrapping the critical section in a synchronised block.


```java
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.size() < maxSizeOfStore) {
                    store.add(new Shirt());
                }
            }
        }
    }
```

Now only one thread will be able to access the store at one time. This will solve the concurrency issue, but our execution does not happen in parallel now. Due to the mutex, only one thread can access the store at a time.

### Parallel solution - Semaphore

A semaphore is a variable or abstract data type used to control access to a common resource by multiple threads and avoid critical section problems in a concurrent system such as a multitasking operating system. The main attribute of a semaphore is how many thread does it control. If a semaphore handles just one thread, it is effectively similar to a mutex.

To solve our producer and consumer problem, we can use two semaphores:
1. For Producer - This semaphore will control the maximum number of producers and is initialised with the max stor size.
2. For Consumer - This semaphore controls the maximum number of consumers. This starts with 0 active threads.

```java
Semaphore forProducer = new Semaphore(maxSize);
Semaphore forConsumer = new Semaphore(0);
```

The ideal situation for us is that:
* There are parallel threads that are able to produce until all the store is filled.
* There are parallel threads that are able to consume until all the store is empty.

Thus, to achieve this we use each producer thread to signal to the consumer that it has added a new unit. Similarly, once the consumer has reduced the unit of works, it signals it to the producer to start making more.

```java

// Producer

while (true) {
    forProducer.acquire();
    store.add(new UnitOfWork());
    forConsumer.release();
}
```

```java

// Consumer

while (true) {
    forConsumer.acquire();
    store.add(new UnitOfWork());
    forProducer.release();
}
```

## Concurrent Data structures

A concurrent data structure is a particular way of storing and organizing data for access by multiple computing threads (or processes) on a computer. A shared mutable state very easily leads to problems when concurrency is involved. If access to shared mutable objects is not managed properly, applications can quickly become prone to some hard-to-detect concurrency errors.

Some common concurrent data structures:
* **Atomic Variables**
    > Atomic means Indivisible / a single unit.  
      def: A wrapper over the underlying int/boolean/long values by providing methods that perform atomic operations on the value
  * [AtomicInteger](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html)
  * [AtomicLong](https://docs.oracle.com/javase%2F9%2Fdocs%2Fapi%2F%2F/java/util/concurrent/atomic/AtomicLong.html)
  * [AtomicBoolean](https://docs.oracle.com/javase%2F9%2Fdocs%2Fapi%2F%2F/java/util/concurrent/atomic/AtomicBoolean.html)
  
* **Concurrent Datastructures**
  * [ConcurrentHashMap<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)
    1. ConcurrentHashMap internally uses HashTable as its data structure. It is thread safe just like Hashtable. 
    2. It provides all the functionalities of HashMap except thread safety.
    2. ConcurrentHashMap internally divides it into segments. Each segment works independently and can be accessed by different reader threads simultaneously. However, each segment can be accessed only by one writer thread at a time. This also means, a concurrent hash map can be accessed by as many writer threads together as there are segments.
    3. The default level of concurrency is 16. Which means by default, there are 16 segments.
    4. Read operations don’t require locking of cocurrent hash map, where as write operations do require locking.
    5. Locking is known as segment or bucket locking.
    6. Concurrent hash map doesn’t allow null key or null values.
  * [CopyOnWriteArrayList\<E\>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArrayList.html)
    * [Detailed Explaination](https://medium.com/@reetesh043/the-copyonwritearraylist-internals-a-deep-dive-ff3ebad87697)
      1. The CopyOnWriteArrayList is a thread safe version of ArrayList. 
      2. If we are making modifications like adding, removing elements in CopyOnWriteArrayList, then JVM does so by creating a new copy of it by the use of Cloning. 
      2. CopyOnWriteArrayList is costly if used in case of more update operations. Because when changes are made, JVM has to create a cloned copy of the underlying array and add/update elements to it.
      3. Multiple threads can read the data from CopyOnWriteArrayList, but only one thread can write data at a particular time.
      4. We can add duplicate elements in it.
      5. **CopyOnWriteArrayList is the best choice in multithreading, if there are more read O(1) operations compared to writes O(N).**
      6. **Alternatives if writes are more in CopyOnWriteArrayList\<E\>**
         0. **Note:** These are basically using synchronized methods.
         1. [Vector\<E\>](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)
         2. [Collections.SynchronizedList\<E\>](https://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#synchronizedList(java.util.List)) 
      7. Any number of reader threads can access CopyOnWriteArrayList simultaneously. And reader and writer threads do not block each other.
  * [CopyOnWriteArraySet\<E\>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArraySet.html)
    1. CopyOnWriteArraySet is like CopyOnWriteArrayList. 
    2. It is thread safe version of HashSet.
  * [ConcurrentSkipListMap<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentSkipListMap.html)
    1. It is thread safe version of TreeMap. 
  * [ConcurrentSkipListSet\<K\>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentSkipListSet.html)
    1. It is thread safe version of TreeSet. 
  * [ConcurrentLinkedQueue\<E\>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html)
    1. It is thread safe version implementing Queue<E> interface.
    2. It internally uses Singly LinkedList data structure. 
  * [ConcurrentLinkedDeque\<E\>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedDeque.html)
    1. It is thread safe version implementing Deque<E> interface. (equivalent to LinkedList<E>)
    2. It internally uses Doubly Linked List data Structure.
  * [PriorityBlockingQueue\<E\>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/PriorityBlockingQueue.html)
    1. [Detailed Explaintation](https://topdeveloperacademy.com/articles/java-priorityblockingqueue-thread-safe-and-memory-efficient-concurrent-heap)
    2. It is thread safe version of PriorityQueue. 
    3. It internally uses Array based binary tree heap data Structure. 
    4. It is dynamic and unbounded ! It grows in size and not bounded by a max limit. 
  * [Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)
    1. **NOTE:** **Collections Class also provided a synchronized versions of List,Map,Set,TreeSet,TreeMap.**