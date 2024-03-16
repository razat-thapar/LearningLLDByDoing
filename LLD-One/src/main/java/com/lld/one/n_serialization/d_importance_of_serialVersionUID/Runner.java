package com.lld.one.n_serialization.d_importance_of_serialVersionUID;

import com.lld.one.n_serialization.SerializationUtils;
import com.lld.one.n_serialization.c_transient_static_fields.User;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        SerializationUtils<User> serializationUtils = new SerializationUtils<>();
        User user = User
                .builder()
                .id(1)
                .name("Razat")
                .email("razat.aggarwal@outlook.com")
                .password("alsdjfal")
                .build();
        System.out.println(user);
        String fileFullPath = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-One\\src\\main\\java\\com\\lld\\one\\n_serialization\\example.ser";
        //convert to byte stream and save it to example.ser file.
        //serializationUtils.serialize(user,fileFullPath);
        //try to deserialize it and print the object.
        User deserializedUser = serializationUtils.deserialize(fileFullPath);
        System.out.println(deserializedUser);

        //Scenario 1: User class is not implementing Serializable marker interface.
        //Result: writing aborted; java.io.NotSerializableException: User

        //Scenario 2: User class is implementing Serializable marker interface with default serialVersionUID.
        //Result:
        // Successfully able to serialize and deserialize
        //CONS:
        // 1. Sensitive data like password are easily visible in serialized file (.ser)
        //¬í sr AUser1jr¾ÿë I idL emailt Ljava/lang/String;L nameq ~ L passwordq ~ xp   t razat.aggarwal@outlook.comt Razatt alsdjfal
        // Hence, we need to encrypt it before serialization and decrypt it after deserialization.

        //Scenario 3: User class is having transient and static fields.
        //Result:
        // static  & Transient fields were ignored during serialization.

        //Scenario 4: changing a transient field to non-transient ,
        // deserializing an object of previous version User class to new Version User class.
        // STEPS TO REPLICATE :
        // 1. execute the runner in package c to generate serialized version of User object with transient fields.
        // 2. remove transient keyword in User.
        // 3. try to execute the runner in package d to deserialize the previous version of class.
        //Result: Deserialization failed !
        //com.lld.one.n_serialization.c_transient_static_fields.User;
        // local class incompatible: stream classdesc serialVersionUID = -3446987068088528126, local class serialVersionUID = 4096246827236696068

        //Now to FIX THIS , we can make use of serialVersionUID to inform JVM that both old and new versions are of same class.
        // STEPS TO REPLICATE:
        //1. uncomment the serialVersionUID in c package and try to generate serialized version of User object with transient fields.
        // 2. remove transient keyword in User.
        // 3. try to execute the runner in package d to deserialize the previous version of class.
        //RESULT: Deserialization WORKS NOW !!!!!!!




    }
}
