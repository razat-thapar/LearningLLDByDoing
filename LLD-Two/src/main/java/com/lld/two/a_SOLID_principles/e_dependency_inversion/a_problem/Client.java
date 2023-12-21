package com.lld.two.a_SOLID_principles.e_dependency_inversion.a_problem;

public class Client {
    public static void main(String[] args) {
        //Scenario 1: We are using Dynamo DB to store our data.
        DatabaseManager dm = new DatabaseManager();
        dm.makeConnection();
        dm.addStudent();
        dm.deleteStudent();

        //Scenario 2: We are now switching from AWS to GCP due to price hike by AWS to 200%.
        //PROBLEM : DatabaseManager is Tightly coupled with AwsDynamoDB class.

        //FIX 1: Try to replace DynamoDB instances in DatabaseManager to GcpDB
        //PROBLEM : we need to change a lot of code for switching to a new DB.

    }
}
