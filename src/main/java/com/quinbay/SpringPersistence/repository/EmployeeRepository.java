package com.quinbay.SpringPersistence.repository;

import com.quinbay.SpringPersistence.dto.DepartmentResponseDTO;
import com.quinbay.SpringPersistence.entity.Department;
import com.quinbay.SpringPersistence.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    //by method name
//    List<Employee> findByDepartment(Department department);
   List<Employee> findByDepartment_Id(Long id);
//    //by query annotation
//    @Query(value = "SELECT * FROM Employee e WHERE e.department.id = ?1")
////    @Query("FROM Employee WHERE e.department.id = ?1")
//    List<Employee> getEmployeeListByDepartmentId(Long departmentId);
    //by native query
    @Query(value = "SELECT * FROM employee e WHERE e.department_id = ?1", nativeQuery = true)
    List<Employee> getEmployeeListByNativeQuery(Long departmentId);

    @Query(value = "select * from employee e where years_of_experience = (select max(years_of_experience) from employee e)",nativeQuery = true)
    Employee getMaxExperiencedEmployee();

    @Query(value = "select * from employee e where years_of_experience = (select max(years_of_experience) from employee e where e.department_id = ?1 )",nativeQuery = true)
    Employee getMaxExperiencedEmployeeByDepartmentId(Long id);

    @Query(value = "select department_id from employee group by department_id order by sum(years_of_experience) DESC LIMIT 1; ",nativeQuery = true)
    Long getDeptWithMaxExperience();


}
