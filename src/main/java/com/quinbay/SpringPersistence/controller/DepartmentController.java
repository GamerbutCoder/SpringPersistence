package com.quinbay.SpringPersistence.controller;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PutMapping(path = "/{id}")
    public DepartmentResponseDTO updateDept(@PathVariable Long id, @RequestBody DepartmentRequestDTO requestDTO){
        return departmentService.updateDept(id,requestDTO);
    }

}
