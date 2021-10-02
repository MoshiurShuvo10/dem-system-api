package com.rmslab.demsystem.services;

import com.rmslab.demsystem.entities.Employee;
import com.rmslab.demsystem.exception.ResourceNotFoundException;
import com.rmslab.demsystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository ;

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>() ;
        employeeRepository.findAll().forEach(employees::add);
        return employees ;
    }

    public Employee getEmployeeById(int id) {
       return employeeRepository
               .findById(id)
               .orElseThrow(()->new ResourceNotFoundException("No employee found with id: "+id));
    }
}
