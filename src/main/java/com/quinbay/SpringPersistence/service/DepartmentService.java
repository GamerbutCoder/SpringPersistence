package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;

public interface DepartmentService {
    DepartmentResponseDTO createEmployee(DepartmentRequestDTO req);
    DepartmentResponseDTO getEmployeeById(long id);
}
