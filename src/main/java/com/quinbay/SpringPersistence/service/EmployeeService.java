package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResponseDTO;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO req);
    EmployeeResponseDTO getEmployeebyId(long id);
}
