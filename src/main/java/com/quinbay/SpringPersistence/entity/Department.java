package com.quinbay.SpringPersistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Department {
    @Id
    @GenericGenerator(name="department_id_seq",strategy = "increment")
    @GeneratedValue(generator = "department_id_seq",strategy = GenerationType.AUTO)
    private long id;
    private String name;
}
