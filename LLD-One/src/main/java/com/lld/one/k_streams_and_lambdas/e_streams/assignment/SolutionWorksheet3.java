package com.lld.one.k_streams_and_lambdas.e_streams.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionWorksheet3 {
    public static int[] list1 = {1,2,3,4,5};
    public static int[] list2 = IntStream.range(1,10).toArray();
    public static String[] list3 = {"java", "go", "spring", "api"};
    @AllArgsConstructor
    @Getter
    static class User {
        String name;
        String email;
        boolean active;
    }
    public static List<User> users = new ArrayList<>();
    public static Consumer<Integer> integerPrinter = num->System.out.printf(" %d ",num);
    public static Consumer<String> stringPrinter = s->System.out.printf(" %s ",s);
    public static String[] list4 = {"apple", "banana", "apple"};
    @Builder
    @Getter
    @ToString
    static class Employee{
        String name;
        String department;
        Double salary;
    }
    public static List<Employee> employees = Arrays.asList(
            Employee.builder().name("John").department("HR").salary(1523.89).build(),
            Employee.builder().name("Jane").department("Finance").salary(2342342.32).build(),
            Employee.builder().name("Doe").department("HR").salary(2342432.83).build()
    );

    public static void main(String[] args) {
        users.add(new User("Alice","alice@gmail.com",true));
        users.add(new User("Bob","bob@gmail.com",false));
        users.add(new User("Charlie","charlie@gmail.com",false));
        //Q1 Given a list of integers, return a list containing the square of even numbers only.
        List<Integer> ans1 = Arrays.stream(list2)
                .filter(num->num%2==0)
                .map(num->num*num)
                .boxed()
                .peek(integerPrinter)
                .toList();
        System.out.println();
        //Q2 Given a list of strings, convert them to uppercase and return only those with length greater than 3.
        List<String> ans2 = Arrays.stream(list3)
                .filter(s->s.length()>3)
                .map(s->s.toUpperCase())
                .peek(stringPrinter)
                .toList();
        System.out.println();
        //Q3. You are given a list of users:Return a list of emails of active users.
        List<String> emails = users.stream()
                .filter(user->user.isActive()==true)
                .map(User::getEmail)
                .peek(stringPrinter)
                .toList();
        System.out.println();
        //Q4. Given a list of words, return a map containing each word and its frequency.
        Map<String,Integer> freqMap = Arrays.stream(list4)
                .collect(Collectors.toMap(
                        word->word,
                        word->1,
                        (a,b)->a+b
                ));
        System.out.println(freqMap);
        //Q5. Given a list of employees: , Return a map of department → number of employees.
        Map<String,Integer> empMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        emp -> 1,
                        (a,b)-> a+b
                ));
        System.out.println(empMap);
        //Q6.Return a map of department → highest paid employee.
        Map<String,Employee> empWithHighestSalary = employees.stream()
                .collect(Collectors.toMap(
                   Employee::getDepartment,
                   emp->emp,
                    (num1,num2)->(Double.compare(num1.getSalary(),num2.getSalary())<0)?num2:num1
                ));
        System.out.println(empWithHighestSalary);
        //Q7.
        //Q8. Given a list of integers, split them into two groups:
        //even numbers
        //odd numbers
        //Return the result as a map.
        Map<String,List<Integer>> evenOddMap = Arrays.stream(list1)
                .boxed()
                .collect(Collectors.partitioningBy(
                        num->num%2==0
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry-> entry.getKey() ? "Even":"Odd",
                        Map.Entry::getValue
                ));
        System.out.println(evenOddMap);

        //TODO: Complete remaining questions.
    }
}
