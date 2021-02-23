package com.quinbay.SpringPersistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    private long id;

    private String name;

    private String departmentName;
}
