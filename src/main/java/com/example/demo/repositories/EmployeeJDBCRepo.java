package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeJDBCRepo implements EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(*) from employee;", Integer.class);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select name from employee where id = " + id + ";", Employee.class);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.queryForObject("select name from employee;", List.class);
    }

    @Override
    public Employee create(Employee employee) {

        return jdbcTemplate.queryForObject("Insert Into employee values(" + employee.getId() + ", "+ employee.getName() + ");", Employee.class);
    }

    @Override
    public Employee update(Employee newEmployee) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
