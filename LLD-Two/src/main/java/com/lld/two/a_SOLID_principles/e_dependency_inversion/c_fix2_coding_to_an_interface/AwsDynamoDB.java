package com.lld.two.a_SOLID_principles.e_dependency_inversion.c_fix2_coding_to_an_interface;

public class AwsDynamoDB implements CloudDB{
    public void runQuery(){
        System.out.println("query running in aws dynamo DB");
    }

    public void connect(){
        System.out.println("connecting to AWS dynamo db.");
    }
}
