package com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.external;

import com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.DatabaseDriver;

//step 2: Create concreate Product subclasses.
public class PostgresDriver implements DatabaseDriver {
    @Override
    public void connect() {
        System.out.println("Establishing Connection with Postgres Database.");
    }

    @Override
    public void query() {
        System.out.println("querying to Postgres Database.");
    }

    @Override
    public void close() {
        System.out.println("closing connection with Postgres Database.");
    }
}