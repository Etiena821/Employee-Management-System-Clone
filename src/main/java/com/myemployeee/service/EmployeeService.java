package com.myemployeee.service;

import com.myemployeee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getListOfEmployees();

    Employee getEmployeeById(Long id);
}
