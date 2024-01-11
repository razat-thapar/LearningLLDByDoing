package com.lld.two.e_factory_pattern.b_simple_factory.database;

import com.lld.two.e_factory_pattern.b_simple_factory.database.external.MongoDriver;
import com.lld.two.e_factory_pattern.b_simple_factory.database.external.MysqlDriver;
import com.lld.two.e_factory_pattern.b_simple_factory.database.external.PostgresDriver;

//Step 3: Create Common Factory Class.
//why common factory and not separate factory ?
//It should be able to create product.
public class DatabaseDriverFactory {
    public static DatabaseDriver createDatabase(DatabaseType type){
        switch (type) {
            case MYSQL:
                return new MysqlDriver();
            case POSTGRES:
                return new PostgresDriver();
            case MONGO:
                return new MongoDriver();
            //default : return null;   A silent killer.
        }
        throw new RuntimeException("Invalid Database Type"+type);
    }
}
