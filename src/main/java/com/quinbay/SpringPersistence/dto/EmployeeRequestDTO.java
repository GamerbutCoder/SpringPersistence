package com.quinbay.SpringPersistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {
    private Long id;
    private String name,departmentName;
}
