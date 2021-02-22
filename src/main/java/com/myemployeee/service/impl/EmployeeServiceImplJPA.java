package com.myemployeee.service.impl;

import com.myemployeee.model.Employee;
import com.myemployeee.repository.EmployeeRepository;
import com.myemployeee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("jpa")
public class EmployeeServiceImplJPA implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getListOfEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).get();
    }
}
