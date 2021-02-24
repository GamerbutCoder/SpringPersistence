package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;


public interface DepartmentService {
    DepartmentResponseDTO updateDept(Long id,DepartmentRequestDTO requestDTO);
}
