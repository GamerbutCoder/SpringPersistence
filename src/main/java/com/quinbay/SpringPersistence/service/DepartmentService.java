package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO req);
    DepartmentResponseDTO getEmployeeById(long id);
}
