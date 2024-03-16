package com.lld.one.n_serialization.b_fix1_implementing_serializable;

import com.lld.one.n_serialization.SerializationUtils;

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
        serializationUtils.serialize(user,fileFullPath);
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
        //¬í sr Acom.lld.one.n_serialization.b_fix1_implementing_serializable.User1jr¾ÿë I idL emailt Ljava/lang/String;L nameq ~ L passwordq ~ xp   t razat.aggarwal@outlook.comt Razatt alsdjfal
        // Hence, we need to encrypt it before serialization and decrypt it after deserialization.


    }
}
