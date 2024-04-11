package com.razat.ems.services;

import com.razat.ems.exceptions.EmployeeNotFoundException;
import com.razat.ems.exceptions.InvalidEmployeeException;
import com.razat.ems.models.Employee;
import com.razat.ems.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("Employee don't exist with id:" + id);
        }
        return employeeOptional.get();
    }

    public Employee addEmployee(Employee employee) {
        validate(employee);
        return employeeRepository.save(employee);
    }

    private void validate(Employee employee) {
        if(employee.getName()==null){
            throw new InvalidEmployeeException("employee name can't be null!");
        }
    }
}
