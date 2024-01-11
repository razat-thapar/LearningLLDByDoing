package com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.external;

import com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.DatabaseDriver;

//step 2: Create concreate Product subclasses.
public class MysqlDriver implements DatabaseDriver {
    @Override
    public void connect() {
        System.out.println("Establishing Connection with Mysql Database.");
    }

    @Override
    public void query() {
        System.out.println("querying to Mysql Database.");
    }

    @Override
    public void close() {
        System.out.println("closing connection with Mysql Database.");
    }
}
