package com.example.demo.using_dbJDBC_core.mapper;


import com.example.demo.using_dbJDBC_core.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("salary"));
    }
}