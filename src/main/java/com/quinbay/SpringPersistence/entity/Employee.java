package com.quinbay.SpringPersistence.entity;

import com.quinbay.SpringPersistence.dto.DepartmentRequestDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @GenericGenerator(name="employee_id_seq",strategy = "increment")
    @GeneratedValue(generator = "employee_id_seq",strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

}
