package com.example.employee_manager.using_dataJDBC.controllers;

import com.example.employee_manager.using_dataJDBC.entities.Employee;
import com.example.employee_manager.using_dataJDBC.repositories.VV_EmployeeRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v2/employee")
public class VV_EmployeeController {

    @Autowired
    private VV_EmployeeRepository employeeRepo;

    @GetMapping("/count")
    public ResponseEntity findEmployeeCount(){
        return ResponseEntity.ok(employeeRepo.count());
    }

    @GetMapping("/filter/name")
    public ResponseEntity findEmployeeByName(@PathParam("name") String name){
        try {
            return ResponseEntity.ok(employeeRepo.findByNameContainsIgnoreCase(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findEmployeeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeRepo.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @GetMapping
    public ResponseEntity findAllEmployees() {
        try {
            return ResponseEntity.ok(employeeRepo.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepo.save(employee));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @PutMapping("/{id}") // edit entire row
    public ResponseEntity editEmployeeById(@RequestBody Employee newEmployee, @PathVariable Long id) {
        try {
            Optional<Employee> opEmployee = employeeRepo.findById(id);

            if (opEmployee.isPresent()) {
                newEmployee.setId(opEmployee.get().getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepo.save(newEmployee));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The given id doesn't exists id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @PatchMapping("/{id}") // edit specific column in a row
    public ResponseEntity editEmployeeFieldById(@RequestBody Employee newEmployee, @PathVariable Long id) {
        try {
            Optional<Employee> opEmployee = employeeRepo.findById(id);

            if (opEmployee.isPresent()) {
                Employee oldEmployee = opEmployee.get();
                oldEmployee.setName(newEmployee.getName() != null ? newEmployee.getName() : oldEmployee.getName());
                oldEmployee.setSalary(newEmployee.getSalary() != null ? newEmployee.getSalary() : oldEmployee.getSalary());

                return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepo.save(oldEmployee));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The given id doesn't exists id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().toString());
        }
    }
}
