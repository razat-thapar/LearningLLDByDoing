package com.razat.ems.controllers;

import com.razat.ems.dto.EmployeeRequestDTO;
import com.razat.ems.models.Employee;
import com.razat.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    //CRUD
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        Employee employee = employeeService.addEmployee(employeeRequestDTO.getEmployee());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
