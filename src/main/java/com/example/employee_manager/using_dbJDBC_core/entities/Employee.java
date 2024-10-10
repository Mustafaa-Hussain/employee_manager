package com.example.employee_manager.using_dbJDBC_core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private Double salary;
}
