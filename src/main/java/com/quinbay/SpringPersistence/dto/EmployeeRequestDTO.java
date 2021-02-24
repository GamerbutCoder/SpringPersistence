package com.quinbay.SpringPersistence.dto;

import lombok.Data;

@Data
public class EmployeeRequestDTO {
    private Long id;
    private String name;
    private String code;
    private Long yearsOfExperience;
    private DepartmentRequestDTO department;
}
