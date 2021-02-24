package com.quinbay.SpringPersistence.service.impl;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import com.quinbay.SpringPersistence.repository.DepartmentRepository;
import com.quinbay.SpringPersistence.repository.EmployeeRepository;
import com.quinbay.SpringPersistence.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceIMPL implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO) {
        Department dept = new Department();
        BeanUtils.copyProperties(requestDTO,dept);
        departmentRepository.save(dept);
        DepartmentResponseDTO res = new DepartmentResponseDTO();
        BeanUtils.copyProperties(dept,res);
        return res;
    }

    @Override
    @Transactional
    public DepartmentResponseDTO updateDept(Long id,DepartmentRequestDTO requestDTO) {
        Department department = departmentRepository.findById(requestDTO.getId()).get();
        List<Employee> employeeList = employeeRepository.findByDepartment_Id(id);
        department.setName(requestDTO.getName());
        Department sd = departmentRepository.save(department);
        for (Employee e:
             employeeList) {
            e.setCode(requestDTO.getDepartmentCode());
        }
        employeeRepository.saveAll(employeeList);
        DepartmentResponseDTO res = new DepartmentResponseDTO();
        BeanUtils.copyProperties(sd,res);
        return res;
    }
}
