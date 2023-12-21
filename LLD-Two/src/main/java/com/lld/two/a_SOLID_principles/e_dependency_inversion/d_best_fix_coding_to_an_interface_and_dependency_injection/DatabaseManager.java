package com.lld.two.a_SOLID_principles.e_dependency_inversion.d_best_fix_coding_to_an_interface_and_dependency_injection;

public class DatabaseManager {
    private CloudDB cloudDB ;
    public DatabaseManager(CloudDB cloudDB){
        this.cloudDB= cloudDB;
    }

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
