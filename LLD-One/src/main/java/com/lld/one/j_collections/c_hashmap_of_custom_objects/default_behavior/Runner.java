package com.lld.one.j_collections.c_hashmap_of_custom_objects.default_behavior;

import java.util.HashMap;
import java.util.List;

class Runner {
    public static void main(String[] args) {
        //Maintain a  HashMap<Employee,Integer> hm
        List<Employee> employeeList = List.of(new Employee(1,"Razat"),new Employee(2,"John"),new Employee(1,"Razat"),new Employee(3,"XYZ"));
        //populate HashMap<Employee,Integer> that represents an employee and it's frequency.
        HashMap<Employee,Integer> hm = new HashMap<>();
        employeeList.forEach(employee -> {
            if(hm.containsKey(employee)){
                hm.put(employee,1+hm.get(employee));
            }else{
                hm.put(employee,1);
            }
        });
        System.out.println(employeeList.get(0).hashCode());
        System.out.println(hm);
    }
}
