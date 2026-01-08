package com.example.Practice.repository;

import com.example.Practice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department,Long>{
}
