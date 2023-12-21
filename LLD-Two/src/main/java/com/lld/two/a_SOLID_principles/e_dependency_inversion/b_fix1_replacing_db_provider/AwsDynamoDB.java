package com.lld.two.a_SOLID_principles.e_dependency_inversion.b_fix1_replacing_db_provider;

public class AwsDynamoDB {
    public void runQuery(){
        System.out.println("query running in aws dynamo DB");
    }

    public void connect(){
        System.out.println("connecting to AWS dynamo db.");
    }
}
