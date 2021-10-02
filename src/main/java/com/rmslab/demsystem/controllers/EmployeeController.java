package com.rmslab.demsystem.controllers;

import com.rmslab.demsystem.entities.Employee;
import com.rmslab.demsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employeeList = employeeService.getEmployees() ;
        if(employeeList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
        return new ResponseEntity<>(employeeList, HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK) ;
    }
}
