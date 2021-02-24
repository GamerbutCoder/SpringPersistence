package com.quinbay.SpringPersistence.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeRequestDTO {
    private Long id;
    private String name;
    private DepartmentRequestDTO department;
}
