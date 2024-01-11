package com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database;

import com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.external.MysqlDriverFactory;

public class Client {
    private static DatabaseDriverFactory databaseFactory = new MysqlDriverFactory();
    public static void main(String[] args) {
        //FIX 2 : Factory Method Pattern.
        // STep 1: create a Product interface (Product of Factory)
        // step 2: create subclasses implementing Product interface.(3rd party libraries).
        // STep 3: create a Factory interface
        // step 4: create subclasses implementing Factory interface.


        //give me an object of MYSQL database using simple factory pattern.
        DatabaseDriver mysqlDB = databaseFactory.createDatabase();
        mysqlDB.connect();
        mysqlDB.query();
        mysqlDB.close();

        //PROS:
        //1. if we add a new Database , we don't need to modify DatabaseFactory class ( OCP is followed. )
        //2. createDatabase() method have one reason to change ( SRP is followed.)
        //3. client class is coding to an interface of Factory. (Dependency Inversion is followed.)

        //CONS:
        //1. class explosion ( for every Product subclass , we are creating a separate Factory subclass).
        //   exponential
    }
}
