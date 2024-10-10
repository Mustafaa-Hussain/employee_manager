package com.example.employee_manager.using_dataJDBC.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Employee {
    @Id
    private Long id;
    private String name;
    private Double salary;
}
