package com.lld.two.e_factory_pattern.b_simple_factory.database;

public class Client {
    public static void main(String[] args) {
        //FIX 1 : Simple Factory Pattern.
        // STep 1: create a common parent interface (Product of Factory)
        // step 2: create concrete subclasses implementing Parent interface.(3rd party libraries).
        // step 3: create common factory class having static methods to createObjects using a parameter.


        //give me an object of MYSQL database using simple factory pattern.
        DatabaseDriver mysqlDB = DatabaseDriverFactory.createDatabase(DatabaseType.MYSQL);
        mysqlDB.connect();
        mysqlDB.query();
        mysqlDB.close();

        //PROS:
        //1. Client code is not tightly coupled with subclasses.
        //2. Able to reuse the business logic of object creation based on parameter in other classes as well.
        //3. Little modification is required if subclasses change. (e.g. name change will result in changes in factory class).

        //CONS:
        //1.Tight coupling of factory class with subclasses (Violation of Dependency Inversion)
        //2. if we add a new Database , we need to modify DatabaseFactory class ( violation of OCP )
        //3. createDatabase() method have multiple reasons to change ( Violation of SRP)
        //Hence, Simple Factory Pattern is not a design Pattern as it doesn't adhere to S.O.L.I.D principles.

        //FIX 2: INHERTIANCE of FACTORY classes.
        //Factory Method Design Pattern.
        // just like fly() method in Bird class, each bird had different flying behavior , we fixed it
        // using INHERITANCE .
        // create Factory classes Heirachachy alongwith Product class heirarchy.
    }
}
