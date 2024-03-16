package com.lld.one.n_serialization.a_demo;

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
        //Result: writing aborted; java.io.NotSerializableException: com.lld.one.n_serialization.a_demo.User


    }
}
