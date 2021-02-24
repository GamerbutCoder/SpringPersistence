package com.quinbay.SpringPersistence.repository;

import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department,Long> {



}
