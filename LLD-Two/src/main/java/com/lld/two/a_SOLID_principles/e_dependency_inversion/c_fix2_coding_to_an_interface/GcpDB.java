package com.lld.two.a_SOLID_principles.e_dependency_inversion.c_fix2_coding_to_an_interface;

public class GcpDB implements CloudDB{
    public void runQuery(){
        System.out.println("query running in gcp DB");
    }

    public void connect(){
        System.out.println("connecting to gcp db.");
    }
}
