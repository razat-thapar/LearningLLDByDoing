package com.lld.two.a_SOLID_principles.e_dependency_inversion.c_fix2_coding_to_an_interface;

public class DatabaseManager {
    CloudDB cloudDB = new GcpDB();

    public void addStudent(){
        cloudDB.runQuery();
    }
    public void deleteStudent(){
        cloudDB.runQuery();
    }
    public void makeConnection(){
        cloudDB.connect();
    }
}
