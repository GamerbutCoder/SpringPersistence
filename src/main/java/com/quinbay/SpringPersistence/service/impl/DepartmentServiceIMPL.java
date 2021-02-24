package com.quinbay.SpringPersistence.service.impl;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.repository.DepartmentRepository;
import com.quinbay.SpringPersistence.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceIMPL implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO req) {
        Department dept = new Department();
        BeanUtils.copyProperties(req,dept);
        Department savedDept= departmentRepository.save(dept);
        DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(savedDept,responseDTO);
        return responseDTO;
    }

    @Override
    public DepartmentResponseDTO getEmployeeById(long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if(optional.isPresent()){
            Department dept = optional.get();
            DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();
            BeanUtils.copyProperties(dept,responseDTO);
            return responseDTO;
        }
        return null;
    }
}
