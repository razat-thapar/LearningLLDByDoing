package com.lld.two.b_singleton_pattern.g_double_check_locking_serialization_fix;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws IOException {
        //Objective : Need to create only one object for a class , if already created then return the same object.
        //Idea 1: since, we want to restrict creation of object , so make constructor private.

        //SingletonClass obj = new SingletonClass(); //error

        //Problem: How to access the constructor outside the class to create one object ?

        //Idea 2:  public getObject() method and private reference variable.
        // We can access the private constructor inside same class,
        // so let's make a method that will create object and return the same if not already created.
        // we need to store the object , so let's create a reference variable.

        //SingletonClass obj = getObject(); // error can't access it without object.

        // let's make the method static.

        //Idea 3: public static getObject() method and private reference variable.
        //since, we can't access non-static variables from static methods, hence, we need to make
        // reference variable static as well.

//        SingletonClass obj = SingletonClass.getObject(); //works now!
//        System.out.println(obj);

        //Problem : Not thread safe.
        // t1 and t2 threads can access getObject() method at same time and for both if condition is false.
        // say t2 gets preempted while t1 creates the object , now, condition is true ,
        // ideally, t2 should not create object but if t2 resumes it will create a new object.

        //Idea 4: Apply mutex lock on whole method body
        // so that only 1 thread enters the critical section.

        //let's test.
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        //Maintain ArrayList<Future<SingletonClass>>
//        ArrayList<Future<SingletonClass>> futures = new ArrayList<>();
//        Instant start = Instant.now();
//        for(int i=0;i<1000;i++){
//           futures.add( es.submit(new CreateObject(i)) );
//        }
//        //get all futures and add it to HashSet<SingletonClass> to check if they return same object ?
//        HashSet<SingletonClass> hs = new HashSet<>();
//        for(Future<SingletonClass> f : futures){
//            try {
//                hs.add(f.get());
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println(hs);
//        Instant end = Instant.now();
//        System.out.printf("Duration : %d ms %n ", Duration.between(start,end).toMillis());
//        es.shutdown();

        //PROS :  it is thread safe !
        //Problem :  Performance issue.  it took 159 ms while it should be fast.
        //Cause : we are applying mutex on whole method body , hence, if object is created , it's still taking lock.

        //Idea 5 (Optimized Approach): Double check Locking mechanism.
        // nested if, first if will check if (object == null) then take lock else return object.
        // second if will handle the case where , some thread enters even though object was created.
        // Due to this, first few threads will take some time while once object is created, other threads will be fast.
        //CONS: deserialization process will create a new object.

        //Idea 6 (Eager Initialization)
        //Instead of doing Lazy Initialization i.e., creating an instance on-demand.
        // we can create an instance while startup of application i.e., during compile time
        //PROS:
        // easy to read
        // thread-safe.

        //CONS:
        //Startup time of an application will increase (i.e., slower startup time).
        //deserialization process will create a new object.

        //let's test.
        //Idea 7: Serialized Singleton object :  Double check locking + readResolve() method.
        //Double check locking mechanism / Eager initialization alone won't fix new object creation while deserializing a singleton class object.
        //hashcode: 1705736037 , SingletonClass : object count = 1
        //hashcode: 683287027 , SingletonClass : object count = 1
        //FIX:  readResolve() method.
        //1. add the serialization method
        // @Serial
        // Object readResolve(ObjectInput oi) { return instance; }
        //This method is executed post deserialization of ObjectInputStream and it will not create a new object post deserialization but return the same one.

        //Serialization Test.
        String filename = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-Two\\src\\main\\java\\com\\lld\\two\\b_singleton_pattern\\g_double_check_locking_serialization_fix\\example.ser";
        SerializedSingletonClass obj = SerializedSingletonClass.getObject();
        //print the obj.
        System.out.printf("hashcode: %d , %s%n",obj.hashCode(),obj);
        //serialize it and save it to file.
        SerializationUtils<SerializedSingletonClass> serializationUtils = new SerializationUtils<>();
        serializationUtils.serialize(obj,filename);
        //deserialize it and print.
        SerializedSingletonClass deserializedObj =   serializationUtils.deserialize(filename);
        System.out.printf("hashcode: %d , %s%n",deserializedObj.hashCode(),deserializedObj);
    }
}
