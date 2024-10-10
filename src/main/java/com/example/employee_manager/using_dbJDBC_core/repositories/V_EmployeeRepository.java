package com.example.employee_manager.using_dbJDBC_core.repositories;

import com.example.employee_manager.using_dbJDBC_core.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface V_EmployeeRepository {
    Integer count();

    Employee findById(long id);

    List<Employee> findAll();

    int create(Employee employee);

    int update(Employee newEmployee, Long id);

    void delete(Long id);
}
