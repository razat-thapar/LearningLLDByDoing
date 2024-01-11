package com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database;

//Step 1: Create a common parent interface ( Product of factory )
public interface DatabaseDriver {
    void connect();
    void query();
    void close();
}
