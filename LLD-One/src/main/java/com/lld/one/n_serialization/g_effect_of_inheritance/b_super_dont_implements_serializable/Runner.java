package com.lld.one.n_serialization.g_effect_of_inheritance.b_super_dont_implements_serializable;

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
                .managerId(1)
                .build();
        //print it.
        System.out.println(manager);
        //serialize it in example.ser
        String filename = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-One\\src\\main\\java\\com\\lld\\one\\n_serialization\\example.ser";
        SerializationUtils<Manager> managerSerializationUtils = new SerializationUtils<>();
        managerSerializationUtils.serialize(manager,filename);
        //deserialize it from file.
        System.out.println(managerSerializationUtils.deserialize(filename));

        //RESULT:
        //1. Only Manager attributes were serialized while other super class attributes were ignored and set to their type defaults.
        //FIX:
        //1. BEST FIX : if parent codebase is owned by us then we can simply implement Serializable.
        //2. CUSTOM Serialization of parent attributes.
        // We need to manually do the same using
        //private void writeObject(java.io.ObjectOutputStream stream) throws IOException
        //private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException
    }
}
