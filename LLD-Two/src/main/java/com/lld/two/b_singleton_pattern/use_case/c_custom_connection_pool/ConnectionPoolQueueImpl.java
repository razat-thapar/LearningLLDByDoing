package com.lld.two.b_singleton_pattern.use_case.c_custom_connection_pool;

import java.util.LinkedList;
import java.util.Queue;

//NOT GOOD !
//Datastructure : Queue<DatabaseConnection> q

//PROS: here, we are just using enqueue() and dequeue() operations and avoiding search() opertion
// by not storing the used connection details.
// Hence, O(1) time for enqueue() and dequeue() opertions.

//CONS: If some applications using DatabaseConnection object from the pool loses it's reference due to some deadlocks or exceptions,
// then the connection is lost forever and never be inserted back to pool after use.
// eventually, pool may get empty.

public class ConnectionPoolQueueImpl implements ConnectionPool {

    private static ConnectionPoolQueueImpl connectionPool = null;
    private final int maxConnections;
    private Queue<DatabaseConnection> dbQueue;

    private ConnectionPoolQueueImpl(int maxConnections){
        this.maxConnections = maxConnections;
        this.dbQueue = new LinkedList<>();
        initializePool(); //initiazePool() is called in constructor to ensure that,
        //the pool is initialized when an instance is created.
    }

    public static ConnectionPoolQueueImpl getInstance(int maxConnections){
        if(connectionPool == null){
            synchronized (ConnectionPoolQueueImpl.class){
                if (connectionPool == null){
                    connectionPool = new ConnectionPoolQueueImpl(maxConnections);
                }
            }
        }
        return connectionPool;
    }

    public static void resetInstance(){
        connectionPool = null;
    }

    @Override
    public void initializePool() {
        for (int i = 0; i < maxConnections; i++) {
            dbQueue.add(new DatabaseConnection());
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        return dbQueue.poll();
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        dbQueue.add(connection);
    }

    @Override
    public int getAvailableConnectionsCount() {
        return dbQueue.size();
    }

    @Override
    public int getTotalConnectionsCount() {
        return this.maxConnections;
    }
}