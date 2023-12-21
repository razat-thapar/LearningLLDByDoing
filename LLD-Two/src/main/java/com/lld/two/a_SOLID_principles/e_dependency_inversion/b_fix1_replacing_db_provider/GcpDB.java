package com.lld.two.a_SOLID_principles.e_dependency_inversion.b_fix1_replacing_db_provider;

public class GcpDB {
    public void runQuery(){
        System.out.println("query running in gcp DB");
    }

    public void connect(){
        System.out.println("connecting to gcp db.");
    }
}
