package com.lld.one.k_streams_and_lambdas.e_streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsApi {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Razat",27,100000,"Developer"));
        employeeList.add(new Employee("Raj",20,30000,"Tester"));
        employeeList.add(new Employee("Mohit",25,2342242,"Developer"));
        employeeList.add(new Employee("Naman",30,34283480,"Developer"));
        employeeList.add(new Employee("Rajesh",50,323232,"Manager"));
        employeeList.add(new Employee("Mukesh",40,342342,"Manager"));
        employeeList.add(new Employee("Apurva",26,500000,"Programmer"));
        employeeList.add(new Employee("Rahul",24,100000,"Tester"));
        employeeList.add(new Employee("Anurag",25,50000,"Analyst"));
        employeeList.add(new Employee("Tanmay",34,1000000,"UI Developer"));
        employeeList.add(new Employee("Mark Zukerberg",30,100000000,"CEO"));
        //use case: get all the employees whose age is below 30
        Predicate<Employee> youngEmployees = employee -> employee.getAge()<30;
        employeeList.stream().filter(youngEmployees).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        //use case: get all the employees whose age is below 30 as well as employees with age >=30 in same data.
        //how ?
        //use of :  Collectors.partitioningBy()
        Map<Boolean,List<Employee>> map = employeeList.stream().collect(Collectors.partitioningBy(youngEmployees));
        System.out.println(map);
        System.out.println("---------------------------------------------------");
        //use case: get all the employees partitioned by age <30 and age>=30 with their count.
        //use of :  Collectors.partitioningBy() & Collectors.counting()
        Map<Boolean,Long> map2 = employeeList.stream().collect(Collectors.partitioningBy(youngEmployees,Collectors.counting()));
        System.out.println(map2);
        System.out.println("---------------------------------------------------");
        //use case: get all the employees grouped by based on age.
        //use of :  Collectors.groupingBy()
        Map<Integer,List<Employee>> map3 = employeeList.stream().collect(Collectors.groupingBy((employee)->employee.getAge()));
        System.out.println(map3);
        System.out.println("---------------------------------------------------");
        //use case: get all the employees grouped by based on designation.
        //use of :  Collectors.groupingBy()
        Map<String,List<Employee>> map4 = employeeList.stream().collect(Collectors.groupingBy((employee)->employee.getDesignation()));
        System.out.println(map4);
        System.out.println("---------------------------------------------------");
        //use case: get all the employees grouped by based on designation and we want only count
        //use of :  Collectors.groupingBy()  & Collectors.counting()
        Map<String,Long> map5 = employeeList.stream().collect(Collectors.groupingBy((employee)->employee.getDesignation(),Collectors.counting()));
        System.out.println(map5);
        System.out.println("---------------------------------------------------");
        //use case: get all the employees grouped by based on designation and we want only names
        //use of :  Collectors.groupingBy()  & Collectors.mapping()
        Map<String,List<String>> map6 = employeeList.stream().collect(
                Collectors.groupingBy(
                    (employee)->employee.getDesignation(),
                        Collectors.mapping(employee->employee.getName(),Collectors.toList())
                )
        );
        System.out.println(map6);
        System.out.println("---------------------------------------------------");


    }
    @AllArgsConstructor
    @ToString
    @Getter
    public static class Employee{
        private String name;
        private int age;
        private int salary;
        private String designation;
    }
}
