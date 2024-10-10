package com.example.demo.using_dbJDBC_core.controllers;

import com.example.demo.using_dbJDBC_core.entities.Employee;
import com.example.demo.using_dbJDBC_core.repositories.V_EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/employee")
public class V_EmployeeController {

    @Autowired
    private V_EmployeeRepository employeeRepo;

    @GetMapping("/count")
    public ResponseEntity getCount() {
        try {
            return ResponseEntity.ok().body(employeeRepo.count().toString());
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage().toString());
        }
    }

    @GetMapping("")
    public ResponseEntity getAllEmployee() {
        try {
            return ResponseEntity.ok().body(employeeRepo.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(employeeRepo.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @PostMapping
    public ResponseEntity insertEmployee(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok().body(employeeRepo.create(employee));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(employeeRepo.update(newEmployee, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id){
        try {
            employeeRepo.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage().toString());
        }
    }

}
