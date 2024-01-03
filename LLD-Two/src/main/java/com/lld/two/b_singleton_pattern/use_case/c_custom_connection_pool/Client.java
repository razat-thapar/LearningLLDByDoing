package com.lld.two.b_singleton_pattern.use_case.c_custom_connection_pool;

public class Client {
    public static void main(String[] args) {
        ConnectionPool impl = ConnectionPoolSetImpl.getInstance(10);
        System.out.println(impl.getAvailableConnectionsCount());
        System.out.println(impl.getConnection());
        System.out.println(impl.getAvailableConnectionsCount());
        System.out.println(impl.getTotalConnectionsCount());

    }
}
