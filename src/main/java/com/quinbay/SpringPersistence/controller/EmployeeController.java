package com.quinbay.SpringPersistence.controller;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResponseDTO;
import com.quinbay.SpringPersistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path="/")
    public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO requestDTO){
        return employeeService.createEmployee(requestDTO);
    }

    @GetMapping(path = "/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

   @PutMapping(path = "/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable long id,@RequestBody EmployeeRequestDTO req){
        return employeeService.updateEmployeeById(id,req);
   }

    @DeleteMapping(path = "/{id}")
    public EmployeeResponseDTO deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployeeById(id);
    }
}
