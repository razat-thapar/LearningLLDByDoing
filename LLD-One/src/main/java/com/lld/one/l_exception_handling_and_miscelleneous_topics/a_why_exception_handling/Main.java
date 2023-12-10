package com.lld.one.l_exception_handling_and_miscelleneous_topics.a_why_exception_handling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Scenario 1:
        //System.out.printf("num: %d",1/0);
        //Exception in thread "main" java.lang.ArithmeticExceptio   n: / by zero

        //Scenario 2 : File Not found.
        String file = "D:\\My Preparation\\ScalerAcademy\\SQL\\LearningSQLByDoing\\crud.sql";
        try {
            FileReader fr = new FileReader(file);
            System.out.printf("Line 1: %s",(char)(fr.read()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
