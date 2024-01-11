package com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.external;

import com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.DatabaseDriver;
import com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.DatabaseDriverFactory;

public class PostgresDriverFactory implements DatabaseDriverFactory {
    @Override
    public DatabaseDriver createDatabase() {
        return new com.lld.two.e_factory_pattern.c_factory_method_design_pattern.database.external.PostgresDriver();
    }
}
