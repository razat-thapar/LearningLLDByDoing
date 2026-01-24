package Altimetrix;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question3 {
    @AllArgsConstructor
    @ToString
    @Setter
    static class Employee{
        Integer id;
        String name;
    }
    public static void main(String[] args) {
        Set<Employee> set1 = new HashSet<>(List.of(
          new Employee(1,"Alice"),
          new Employee(2,"Bob"),
          new Employee(3,"Charlie")
        ));
        System.out.println(set1);
        //what it will print ?
        Set<Employee> set2 = new HashSet<>(List.of(
                new Employee(1,"Alice"),
                new Employee(1,"Alice"),
                new Employee(3,"Charlie")
        ));
        System.out.println(set2);

    }
}
