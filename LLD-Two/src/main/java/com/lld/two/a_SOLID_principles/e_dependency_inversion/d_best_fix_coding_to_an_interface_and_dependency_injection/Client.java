package com.lld.two.a_SOLID_principles.e_dependency_inversion.d_best_fix_coding_to_an_interface_and_dependency_injection;

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

        //Problem.: Here, DatabaseManager is responsible for object creation of cloudDB provider
        // while it should be Client's responsibility.

        //Fix3 : Dependency Inversion + Dependency Injection
        //Explanation: Now, Client is responsible to switch from one cloudProvider to another.
        // Developers don't need to change the code as it's loosely coupled system.
        CloudDB cloudDB = new GcpDB();
        DatabaseManager dm = new DatabaseManager(cloudDB);
        dm.makeConnection();
        dm.addStudent();
        dm.deleteStudent();
    }
}
