package com.quinbay.SpringPersistence.controller;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/department")
public class DepartmentCrontroller {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(path = "/")
    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO request){
        return null;
    }

    @GetMapping(path = "/{id}")
    public DepartmentResponseDTO getDepartment(@PathVariable long id){
        return departmentService.getEmployeeById(id);
    }

}
