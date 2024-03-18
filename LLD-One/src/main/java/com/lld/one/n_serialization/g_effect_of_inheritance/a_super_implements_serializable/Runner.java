package com.lld.one.n_serialization.g_effect_of_inheritance.a_super_implements_serializable;

import com.lld.one.n_serialization.SerializationUtils;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        //create Manager object.
        Manager manager = Manager
                .builder()
                .id(1)
                .name("Razat")
                .email("razat.aggarwal@outlook.com")
                .salary(25.8)
                .managerLevel(ManagerLevel.L3)
                .build();
        //print it.
        System.out.println(manager);
        //serialize it in example.ser
        String filename = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-One\\src\\main\\java\\com\\lld\\one\\n_serialization\\example.ser";
        SerializationUtils<Manager> managerSerializationUtils = new SerializationUtils<>();
        managerSerializationUtils.serialize(manager,filename);
        //deserialize it from file.
        System.out.println(managerSerializationUtils.deserialize(filename));
    }
}
