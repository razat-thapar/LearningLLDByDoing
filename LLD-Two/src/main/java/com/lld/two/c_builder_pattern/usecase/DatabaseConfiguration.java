package com.lld.two.c_builder_pattern.usecase;
public class DatabaseConfiguration {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;
    private DatabaseConfiguration() {

    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public static DatabaseConfigurationBuilder getDatabaseConfigurationBuilder(){
        return new DatabaseConfigurationBuilder();
    }
    //Builder Class.
    public static class DatabaseConfigurationBuilder{
        private final DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

        public DatabaseConfigurationBuilder setDatabaseUrl(String databaseUrl) {
            databaseConfiguration.databaseUrl = databaseUrl;
            return this;
        }

        public DatabaseConfigurationBuilder setUsername(String username) {
            databaseConfiguration.username = username;
            return this;
        }

        public DatabaseConfigurationBuilder setPassword(String password) {
            databaseConfiguration.password = password;
            return this;
        }

        public DatabaseConfigurationBuilder setMaxConnections(int maxConnections) {
            databaseConfiguration.maxConnections = maxConnections;
            return this;
        }

        public DatabaseConfigurationBuilder setEnableCache(boolean enableCache) {
            databaseConfiguration.enableCache = enableCache;
            return this;
        }

        public DatabaseConfigurationBuilder setReadOnly(boolean isReadOnly) {
            databaseConfiguration.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfiguration build(){
            DatabaseConfiguration newDatabaseConfiguration = new DatabaseConfiguration();
            //provide all complex validations here !
            //initialize.
            newDatabaseConfiguration.username = databaseConfiguration.username;
            newDatabaseConfiguration.password = databaseConfiguration.password;
            newDatabaseConfiguration.databaseUrl = databaseConfiguration.databaseUrl;
            newDatabaseConfiguration.isReadOnly = databaseConfiguration.isReadOnly;
            newDatabaseConfiguration.enableCache = databaseConfiguration.enableCache;
            newDatabaseConfiguration.maxConnections = databaseConfiguration.maxConnections;
            return newDatabaseConfiguration;
        }
    }
}
