package com.lld.two.e_factory_pattern.a_why_factory_pattern.database;

import com.lld.two.e_factory_pattern.a_why_factory_pattern.database.external.*;

public class Client {
    public static void main(String[] args) {
        //give me database object based on argument.
        Database database;
        DatabaseType type = DatabaseType.MYSQL;
        switch (type) {
            case MYSQL:
                database = new MysqlDriver();
                break;
            case POSTGRES:
                database = new PostgresDriver();
                break;
            case MONGO:
                database = new MongoDriver();
                break;
            //default : return null;   A silent killer.
            default:
                throw new RuntimeException("Invalid Database Type"+type);
        }
        database.connect();
        database.query();
        database.close();
        //CONS:
        // 1. Tightly coupled with subclasses for object creation.
        // 2. can't reuse the business logic (if else) of object creation.

        //FIX 1 : Simple Factory Pattern.
        // STep 1: create a common parent interface (Product of Factory)
        // step 2: create concrete subclasses implementing Parent interface.(3rd party libraries).
        // step 3: create common factory class having static methods to createObjects using a parameter.
    }
}
