package com.example.Practice.repository;

import com.example.Practice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee  ,Long> {
}