package com.lld.two.a_SOLID_principles.e_dependency_inversion.b_fix1_replacing_db_provider;

public class DatabaseManager {
    GcpDB gcpDB = new GcpDB();

    public void addStudent(){
        gcpDB.runQuery();
    }
    public void deleteStudent(){
        gcpDB.runQuery();
    }
    public void makeConnection(){
        gcpDB.connect();
    }
}
