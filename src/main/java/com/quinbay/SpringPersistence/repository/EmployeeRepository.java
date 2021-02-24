package com.quinbay.SpringPersistence.repository;

import com.quinbay.SpringPersistence.dto.EmployeeResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findByDepartment(Department department);
}
