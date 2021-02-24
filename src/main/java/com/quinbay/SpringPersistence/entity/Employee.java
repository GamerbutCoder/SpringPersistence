package com.quinbay.SpringPersistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GenericGenerator(name="employee_id_seq",strategy = "increment")
    @GeneratedValue(generator = "employee_id_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private Long yearsOfExperience;
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
}
