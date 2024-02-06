package com.lld.two.e_factory_pattern.a_why_factory_pattern.database.external;

import com.lld.two.e_factory_pattern.a_why_factory_pattern.database.Database;

public class MysqlDriver implements Database {
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