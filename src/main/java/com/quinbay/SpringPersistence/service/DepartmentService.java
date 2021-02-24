package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResonseDTO;


public interface DepartmentService {
    DepartmentResponseDTO updateDept(Long id,DepartmentRequestDTO requestDTO);
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO);
    EmployeeResonseDTO getMaxExpByDeptId(Long id);
    DepartmentResponseDTO getDeptWithMostExperience();
}
