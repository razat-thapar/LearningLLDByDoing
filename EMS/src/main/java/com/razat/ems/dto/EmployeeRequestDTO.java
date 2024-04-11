package com.razat.ems.dto;
import com.razat.ems.*;
import com.razat.ems.models.Employee;

import java.util.Date;

public class EmployeeRequestDTO {
    private String name;
    private Double salary;
    private Date doj;

    public Employee getEmployee(){
        Employee employee = Employee
                .builder()
                .name(name)
                .salary(salary)
                .doj(doj)
                .build();
        return employee;
    }
}
