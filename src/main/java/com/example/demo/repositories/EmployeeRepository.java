package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
    Integer count();

    Employee findById(long id);

    List<Employee> findAll();

    Employee create(Employee employee);

    Employee update(Employee newEmployee);

    void delete(Long id);
}
