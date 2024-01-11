package com.lld.two.e_factory_pattern.b_simple_factory.database;

//Step 1: Create a common parent interface ( Product of factory )
public interface DatabaseDriver {
    void connect();
    void query();
    void close();
}
