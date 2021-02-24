package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResonseDTO;

public interface EmployeeService {
    EmployeeResonseDTO createEmployee(EmployeeRequestDTO req);
    EmployeeResonseDTO getEmployeeById(Long id);
    boolean deleteById(Long id);
}
