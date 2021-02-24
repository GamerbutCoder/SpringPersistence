package com.quinbay.SpringPersistence.service.impl;

import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResonseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import com.quinbay.SpringPersistence.repository.DepartmentRepository;
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

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public EmployeeResonseDTO createEmployee(EmployeeRequestDTO request) {
        Employee e = new Employee();
        BeanUtils.copyProperties(request,e);
        Optional<Department> optional = departmentRepository.findById(request.getDepartment().getId());
        if(optional.isPresent()){
            Department dept = optional.get();
            e.setDepartment(dept);
        }
        else{
            Department dept = new Department();
            dept.setName(request.getDepartment().getName());
            e.setDepartment(dept);
        }

        employeeRepository.save(e);
        EmployeeResonseDTO res = new EmployeeResonseDTO();
        BeanUtils.copyProperties(e,res);
        res.setDepartmentFromEntity(e.getDepartment());
        return res;
    }

}
