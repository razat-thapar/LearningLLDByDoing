package com.lld.one.k_streams_and_lambdas.e_streams.assignment;

import com.lld.one.k_streams_and_lambdas.e_streams.CollectorsApi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class SolutionWorksheet2 {
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Employee{
        private String name;
        private int age;
        private Gender gender;
        private int salary;
        private String designation;
        private DepartmentType departmentType;
    }
    public static enum Gender{
        MALE,
        FEMALE
    }
    public static enum DepartmentType{
        FINANCE,
        ACCOUNTS,
        IT,
        MARKETING,
        MANAGEMENT
    }
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Razat",27,Gender.MALE,100000,"Developer",DepartmentType.IT));
        employeeList.add(new Employee("Roohi",20,Gender.FEMALE,30000,"Tester",DepartmentType.IT));
        employeeList.add(new Employee("Mohit",25,Gender.MALE,2342242,"Developer",DepartmentType.IT));
        employeeList.add(new Employee("Naman",30,Gender.MALE,34283480,"Developer",DepartmentType.IT));
        employeeList.add(new Employee("Rita",50,Gender.FEMALE,323232,"Manager",DepartmentType.MANAGEMENT));
        employeeList.add(new Employee("Mukesh",40,Gender.MALE,342342,"Manager",DepartmentType.MANAGEMENT));
        employeeList.add(new Employee("Apurva",26,Gender.FEMALE,500000,"Programmer",DepartmentType.IT));
        employeeList.add(new Employee("Rahul",24,Gender.MALE,100000,"Sales Specialist",DepartmentType.MARKETING));
        employeeList.add(new Employee("Anurag",25,Gender.MALE,50000,"Analyst",DepartmentType.IT));
        employeeList.add(new Employee("Tanmay",34,Gender.MALE,1000000,"UI Developer",DepartmentType.IT));
        employeeList.add(new Employee("Mark Zukerberg",30,Gender.MALE,100000000,"CEO",DepartmentType.MANAGEMENT));
        employeeList.add(new Employee("Vineeta",35,Gender.FEMALE,20000000,"FOUNDER",DepartmentType.MANAGEMENT));
//      ### 1. Get the youngest employee in the company.
        //steps 1: we need to reduce the employees to only 1 employee with min age.
        //Employee youngestEmployee = employeeList.stream().reduce(BinaryOperator.minBy((emp1,emp2)->emp1.getAge()-emp2.getAge())).orElseThrow(()->new RuntimeException("Employee is empty!"));
        Employee youngestEmployee = employeeList.stream().min((emp1,emp2)-> emp1.getAge()-emp2.getAge()).orElseThrow(()->new RuntimeException("No Employee Found!!"));
        System.out.println(youngestEmployee);
        System.out.println("--------------------------------------------------------------");
//      ### 2. The top 5 highest salaried employees.
        //steps:
        //1. sort the employees based on salary in desc order
        //2. get the top 5 employees using limit()
        employeeList.stream().sorted((emp1,emp2)->emp2.getSalary()-emp1.getSalary()).limit(5).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
//      ### 3. Number of employees grouped by gender.
        //steps:
        //1. Use the Collectors.groupingBy() and Collectors.counting() API's
        Map<Gender,Long> map= employeeList.stream().collect(Collectors.groupingBy(employee->employee.getGender(),Collectors.counting()));
        System.out.println(map);
        System.out.println("--------------------------------------------------------------");
//      ### 4. The total expense department wise.
        //steps:
        //1. Use the Collectors.groupingBy() && Collectors.summingDouble() APi's
        Map<DepartmentType,Double> map2= employeeList.stream().collect(Collectors.groupingBy(employee->employee.getDepartmentType(),Collectors.summingDouble((employee)-> employee.getSalary())));
        System.out.println(map2);
        System.out.println("--------------------------------------------------------------");

    }
}
