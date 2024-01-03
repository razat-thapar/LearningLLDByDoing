package com.lld.two.b_singleton_pattern.use_case.c_custom_connection_pool;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//Maintaining 2 thread safe HashSet<DatabaseConnection> used and available
//PROS: All operations in O(1) time.
//CONS: It is based on assumption that, two DatabaseConnection objects with same attributes are treated as different.
// we are not overriding native hashCode() and equals() methods which are based on memory addresses.
//Hence, if someone mistakenly overrides these methods, it will not work.

public class ConnectionPoolSetImpl implements ConnectionPool {
    //Hashset
    private Set<DatabaseConnection> usedConnectionPool ;
    private Set<DatabaseConnection> availableConnectionPool;
    private int maxConnections ;
    private static ConnectionPoolSetImpl instance = null;
    private ConnectionPoolSetImpl(int maxConnections){
        this.maxConnections = maxConnections;
        //we are using thread safe hashSet implementation.
        ConcurrentHashMap<DatabaseConnection,Integer> hm1 = new ConcurrentHashMap<>();
        this.availableConnectionPool = hm1.keySet(0);
        ConcurrentHashMap<DatabaseConnection,Integer> hm2 = new ConcurrentHashMap<>();
        this.usedConnectionPool = hm2.keySet(0);
        initializePool();
    }
    @Override
    public void initializePool() {
        int count = 0;
        while(count < maxConnections){
            availableConnectionPool.add(new DatabaseConnection());
            count++;
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        if(!availableConnectionPool.isEmpty()){
            Iterator<DatabaseConnection> iterator = availableConnectionPool.iterator();
            DatabaseConnection dc = iterator.next();
            availableConnectionPool.remove(dc);
            //add to usedpool.
            usedConnectionPool.add(dc);
            return dc;
        }
        return null;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        //validate if exist in used pool .
        if(usedConnectionPool.contains(connection)){
            // remove it
            // add to available pool .
            usedConnectionPool.remove(connection);
            availableConnectionPool.add(connection);
        }
    }

    @Override
    public int getAvailableConnectionsCount() {
        return availableConnectionPool.size();
    }

    @Override
    public int getTotalConnectionsCount() {
        return maxConnections ;
    }
    public static ConnectionPool getInstance(int maxConnections){
        if(instance == null){
            synchronized(ConnectionPoolSetImpl.class){
                if(instance == null){
                    instance = new ConnectionPoolSetImpl(maxConnections);
                    return instance;
                }
            }
        }
        return instance;
    }

    public static void resetInstance(){
        instance = null;
    }

}