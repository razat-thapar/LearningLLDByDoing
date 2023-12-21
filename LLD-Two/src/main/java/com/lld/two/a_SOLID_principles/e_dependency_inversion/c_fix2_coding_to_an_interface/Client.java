package com.lld.two.a_SOLID_principles.e_dependency_inversion.c_fix2_coding_to_an_interface;

public class Client {
    public static void main(String[] args) {
        //Scenario 1: We are using databaseManager to store our data.

        //Scenario 2: We are now switching from AWS to GCP due to price hike by AWS to 200%.
        //PROBLEM : DatabaseManager is Tightly coupled with AwsDynamoDB class.

        //FIX 1: Try to replace DynamoDB instances in DatabaseManager to GcpDB
        //PROBLEM : we need to change a lot of code for switching to a new DB.

        //Fix 2: Dependency Inversion
        // Coding to an interface,
        // Create a cloudDB interface.
        // DatabaseManager will be coding to CloudDB interface now.
        DatabaseManager dm = new DatabaseManager();
        dm.makeConnection();
        dm.addStudent();
        dm.deleteStudent();
        //Problem.: Here, DatabaseManager is responsible for object creation of cloudDB provider
        // while it should be Client's responsibility.

        //Fix3 : Dependency Inversion + Dependency Injection

    }
}
