package com.quinbay.SpringPersistence.service;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResponseDTO;
import com.quinbay.SpringPersistence.entity.Employee;
import com.quinbay.SpringPersistence.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIMPL implements  EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(requestDTO,emp);
        Employee savedEmployee = employeeRepository.save(emp);
        EmployeeResponseDTO response = new EmployeeResponseDTO();
        BeanUtils.copyProperties(savedEmployee,response);
        return response;
    }

    @Override
    public EmployeeResponseDTO getEmployeebyId(long id) {
        return null;
    }
}
