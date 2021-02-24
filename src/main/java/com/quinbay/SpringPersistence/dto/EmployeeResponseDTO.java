package com.quinbay.SpringPersistence.dto;

import com.quinbay.SpringPersistence.entity.Department;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private DepartmentResponseDTO department;

    public void setDeptFromEntity(Department dept){
        Department d = new Department();
        d.setDepartmentName(dept.getDepartmentName());
        d.setId(dept.getId());
        BeanUtils.copyProperties(d,this.department);
    }
}
