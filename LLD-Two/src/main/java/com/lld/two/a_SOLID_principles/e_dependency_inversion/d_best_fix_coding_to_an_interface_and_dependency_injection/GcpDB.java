package com.lld.two.a_SOLID_principles.e_dependency_inversion.d_best_fix_coding_to_an_interface_and_dependency_injection;

public class GcpDB implements CloudDB {
    public void runQuery(){
        System.out.println("query running in gcp DB");
    }

    public void connect(){
        System.out.println("connecting to gcp db.");
    }
}
