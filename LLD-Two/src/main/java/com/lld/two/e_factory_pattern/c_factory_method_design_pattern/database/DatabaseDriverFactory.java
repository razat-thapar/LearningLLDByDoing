package com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database;

//Step 3: Create Factory Interface.
public interface DatabaseDriverFactory {
    public DatabaseDriver createDatabase();
}
