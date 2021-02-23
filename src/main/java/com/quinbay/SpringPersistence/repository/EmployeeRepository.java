package com.quinbay.SpringPersistence.repository;

import com.quinbay.SpringPersistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {}
