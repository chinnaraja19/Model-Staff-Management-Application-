package com.example.Springboot.thymeleafcrudwebbapp.repository;

import com.example.Springboot.thymeleafcrudwebbapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {
}
