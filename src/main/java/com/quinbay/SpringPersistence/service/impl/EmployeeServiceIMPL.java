package com.quinbay.SpringPersistence.service.impl;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResponseDTO;
import com.quinbay.SpringPersistence.entity.Employee;
import com.quinbay.SpringPersistence.repository.EmployeeRepository;
import com.quinbay.SpringPersistence.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
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
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            EmployeeResponseDTO res = new EmployeeResponseDTO();
            BeanUtils.copyProperties(optional.get(),res);
            return res;
        }
        return null;
    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(long id,EmployeeRequestDTO employeeRequestDTO) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            Employee emp = optional.get();

            emp.setDeptId(employeeRequestDTO.getDeptId());
            emp.setName(employeeRequestDTO.getName());
           Employee savedEmp =  employeeRepository.save(emp);
           EmployeeResponseDTO res = new EmployeeResponseDTO();
           BeanUtils.copyProperties(savedEmp,res);
           return res;
        }
        return null;
    }

    @Override
    public EmployeeResponseDTO deleteEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            Employee emp = optional.get();
            employeeRepository.delete(emp);
            EmployeeResponseDTO res = new EmployeeResponseDTO();
            BeanUtils.copyProperties(emp,res);
            return res;
        }
        return null;
    }
}
