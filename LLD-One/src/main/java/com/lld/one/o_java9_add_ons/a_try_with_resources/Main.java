package com.lld.one.o_java9_add_ons.a_try_with_resources;

public class Main {
    public static void main(String[] args) {
        //example of serialization and deserialization implementing try with resources.
        String fileName = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-One\\src\\main\\java\\com\\lld\\one\\o_java9_add_ons\\a_try_with_resources\\example.ser";
        //create an object.
        User user = User
                .builder()
                .id(1)
                .name("Razat")
                .email("razat.aggarwal@outlook.com")
                .password("lkjlsajf")
                .build();
        SerializationUtils<User> serializationUtils = new FileSerializationUtils<>(fileName);
        //serialize and save to file.
        System.out.println(user);
        serializationUtils.serialize(user);
        //deserialize from file.
        User deserializedUser = serializationUtils.deserialize();
        System.out.println(deserializedUser);
    }
}
