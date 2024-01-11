package com.lld.two.e_factory_pattern.b_simple_factory.database.external;

import com.lld.two.e_factory_pattern.b_simple_factory.database.DatabaseDriver;

//Step 2 : Create the product subclasses.
public class MongoDriver implements DatabaseDriver {
    @Override
    public void connect() {
        System.out.println("Establishing Connection with Mongo Database.");
    }

    @Override
    public void query() {
        System.out.println("querying to Mongo Database.");
    }

    @Override
    public void close() {
        System.out.println("closing connection with Mongo Database.");
    }
}
