package com.lld.one.c_inheritance_polymorphism.method_overloading;

public class Calculator {
    private static final double pi = 22/7;
    private String name;
    public Calculator(String name){
        this.name=name;
    }
    public Calculator(){}
    //different versions of add(a,b) method.
    public long add(long a, long b){
        System.out.println("Inside add(long,long)");
        return a+b;
    }
    public long add(long a, long b, long c){
        System.out.println("Inside add(long,long,long)");
        return a+b+c;
    }
    public long add(long ... nums){
        System.out.println("Inside add(long ...)");
        long ans=0;
        long mod = (long)1e18;
        for(long num : nums){
            ans= (ans + num)%mod;
        }
        return ans;
    }
    /* This is not allowed as it's same as add(int a,int b) , return types are ignored!
    public double add(int a, int b){
        return (double)(a+b);
    }
     */
    public double add(double a, double b){
        System.out.println("Inside add(double,double)");
        return a+b;
    }
    public double add(double ... nums){
        System.out.println("Inside add(double ...)");
        double ans=0.0;
        double mod = 1e18;
        for(double num : nums){
            ans= (ans + num)%mod;
        }
        return ans;
    }


}
