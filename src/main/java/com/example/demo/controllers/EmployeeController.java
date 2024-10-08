package com.example.demo.controllers;

import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("/count")
    public String getCount(){
        return employeeRepo.count().toString();
    }

    @GetMapping("")
    public String getAllEmployee(){
        return employeeRepo.findAll().toString();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable long id){
        return employeeRepo.findById(id).toString();
    }

}
