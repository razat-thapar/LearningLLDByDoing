package com.lld.two.a_SOLID_principles.e_dependency_inversion.a_problem;

public class DatabaseManager {
    AwsDynamoDB awsDynamo = new AwsDynamoDB();

    public void addStudent(){
        awsDynamo.runQuery();
    }
    public void deleteStudent(){
        awsDynamo.runQuery();
    }
    public void makeConnection(){
        awsDynamo.connect();
    }
}
