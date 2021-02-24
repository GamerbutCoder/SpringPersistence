package com.quinbay.SpringPersistence.repository;

import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department,Long> {
    @Query(value = "select * from department d where id = ?1",nativeQuery = true)
    Department getDeptById(Long id);
}
