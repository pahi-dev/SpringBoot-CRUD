package com.example.Practice.service;

import com.example.Practice.entity.Employee;
import com.example.Practice.repository.EmployeeRepository;
import com.example.Practice.utills.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

public Employee deleteEmployee(Long id) throws EmployeeNotFoundException {
    Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with ID: " + id));

    employeeRepository.delete(employee);
    return employee;
}


    public Employee updateEmployee(Long id, Employee employeeDetails) {

        Employee Already = employeeRepository.findById(id).orElse(null);

        if (Already != null) {
            Already.setName(employeeDetails.getName());

            return employeeRepository.save(Already);
        }

        return null;
    }

}
