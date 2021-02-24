package com.quinbay.SpringPersistence.controller;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResonseDTO;
import com.quinbay.SpringPersistence.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(path="/")
    public DepartmentResponseDTO addDepartment(@RequestBody DepartmentRequestDTO requestDTO){
        return departmentService.createDepartment(requestDTO);
    }
    @PutMapping(path = "/{id}")
    public DepartmentResponseDTO updateDept(@PathVariable Long id, @RequestBody DepartmentRequestDTO requestDTO){
        return departmentService.updateDept(id,requestDTO);
    }

    @GetMapping("/{id}/employee/mostExperienced")
    public EmployeeResonseDTO mostExperiencedByDeptId(@PathVariable Long id){
        return departmentService.getMaxExpByDeptId(id);
    }

    @GetMapping(path = "/mostExperienced")
    public DepartmentResponseDTO mostExperienced(){
        return departmentService.getDeptWithMostExperience();
    }

}
