package com.example.Springboot.thymeleafcrudwebbapp.service;


import com.example.Springboot.thymeleafcrudwebbapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
     Employee getEmployeeById(long id);
     void deleteEmployeeById(long id);
}
