package com.quinbay.SpringPersistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "employee")
@Getter
@Setter
public class Employee {
    @Id
    private Long id;

    private String name;

    private String departmentName;
}
