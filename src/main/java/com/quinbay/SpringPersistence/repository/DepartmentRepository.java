package com.quinbay.SpringPersistence.repository;

import com.quinbay.SpringPersistence.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
