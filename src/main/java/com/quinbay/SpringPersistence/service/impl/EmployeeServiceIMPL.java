package com.quinbay.SpringPersistence.service.impl;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeRequestDTO;
import com.quinbay.SpringPersistence.dto.EmployeeResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import com.quinbay.SpringPersistence.repository.DepartmentRepository;
import com.quinbay.SpringPersistence.repository.EmployeeRepository;
import com.quinbay.SpringPersistence.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(requestDTO,emp);
        EmployeeResponseDTO response = new EmployeeResponseDTO();
        Optional<Department> optionalDepartment = departmentRepository.findById(requestDTO.getDepartment().getId());
        if(optionalDepartment.isPresent()){
            emp.setDepartment(optionalDepartment.get());
            employeeRepository.save(emp);
            BeanUtils.copyProperties(emp,response);
            response.setDeptFromEntity(optionalDepartment.get());
        }
        else{
            Department department = new Department();
            department.setDepartmentName(requestDTO.getDepartment().getDepartmentName());
            department.setId(requestDTO.getDepartment().getId());
            response.setDeptFromEntity(department);
            emp.setDepartment(department);
            employeeRepository.save(emp);
            BeanUtils.copyProperties(emp,response);

        }


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
            Optional<Department> optionalDepartment = departmentRepository.findById(employeeRequestDTO.getDepartment().getId());
            if(optionalDepartment.isPresent()){
                emp.setDepartment(optionalDepartment.get());
            }
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

    @Override
    public List<EmployeeResponseDTO> getEmployeeListByDepartmentId(long id) {
        List<EmployeeResponseDTO> responseDTOS = new ArrayList<>();
        Department dept = departmentRepository.findById(id).get();
        List<Employee> all = employeeRepository.findByDepartment(dept);
        for(Employee e: all){
            EmployeeResponseDTO res = new EmployeeResponseDTO();
            BeanUtils.copyProperties(e,res);
            res.setDeptFromEntity(e.getDepartment());
            responseDTOS.add(res);
        }
        return responseDTOS;
    }
}
