package com.example.Practice.controller;

import com.example.Practice.entity.Employee;
import com.example.Practice.service.EmployeeService;
import com.example.Practice.utills.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/api/v1/add")
    private Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/api/v1/{id}")
    private Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/api/v1/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/api/v1/employees/pagination")
    public Page<Employee> getEmployeesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return employeeService.getEmployeesWithPagination(page, size);
    }


    @DeleteMapping("/api/v1/{id}")
    private Employee deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/api/v1/{id}")
    private Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }



}