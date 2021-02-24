package com.quinbay.SpringPersistence.dto;

import com.quinbay.SpringPersistence.entity.Department;
import lombok.Data;

@Data
public class EmployeeResonseDTO {
    private Long id;
    private String name;
    private String code;
    private Long yearsOfExperience;
    private DepartmentResponseDTO department;

    public void setDepartmentFromEntity(Department department){
        DepartmentResponseDTO res = new DepartmentResponseDTO();
        res.setId(department.getId());
        res.setName(department.getName());
        this.department = res;
    }

}
