package com.lld.one.n_serialization.f_importance_of_readResolve_serializable_method;

import com.lld.one.n_serialization.SerializationUtils;
import com.lld.one.n_serialization.c_transient_static_fields.User;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        SerializationUtils<SingletonUser> serializationUtils = new SerializationUtils<>();
        SingletonUser user = SingletonUser.getInstance();
        user.setId(1);
        user.setName("Razat");
        user.setEmail("razat.aggarwal@outlook.com");
        user.setPassword("akasdjf");
        System.out.printf("hashcode:%d, %s%n",user.hashCode(),user);
        String fileFullPath = "D:\\My Preparation\\ScalerAcademy\\LLD\\LearningLLDByDoing\\LLD-One\\src\\main\\java\\com\\lld\\one\\n_serialization\\example.ser";
        //convert to byte stream and save it to example.ser file.
        serializationUtils.serialize(user,fileFullPath);
        //try to deserialize it and print the object.
        SingletonUser deserializedUser = serializationUtils.deserialize(fileFullPath);
        System.out.printf("hashcode:%d, %s%n",deserializedUser.hashCode(),deserializedUser);

        //Scenario 1: Without readResolve() method.
        //comment the readResolve() method in SingletonUser class.
//        hashcode:455659002, SingletonUser(species=HUMAN, id=1, name=Razat, email=razat.aggarwal@outlook.com, password=akasdjf)
//        hashcode:1109371569, SingletonUser(species=HUMAN, id=1, name=Razat, email=razat.aggarwal@outlook.com, password=null)
        //We got two objects !

        //Scenario 2: With readResolve() Method.
        //uncomment the readResolve() method.
        //We got same object ! SingleTon works as expected ! !!



    }
}
