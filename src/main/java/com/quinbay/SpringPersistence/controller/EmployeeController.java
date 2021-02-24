package com.quinbay.SpringPersistence.controller;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResonseDTO;
import com.quinbay.SpringPersistence.entity.Employee;
import com.quinbay.SpringPersistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/")
    public EmployeeResonseDTO addEmployee(@RequestBody EmployeeRequestDTO req){
        return employeeService.createEmployee(req);
    }

    @GetMapping(path="/{id}")
    public EmployeeResonseDTO getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable Long id){
        return employeeService.deleteById(id);
    }

}
