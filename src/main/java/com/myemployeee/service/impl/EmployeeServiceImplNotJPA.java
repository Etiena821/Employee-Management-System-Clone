package com.myemployeee.service.impl;

import com.myemployeee.model.Employee;
import com.myemployeee.service.EmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("no-jpa")
public class EmployeeServiceImplNotJPA implements EmployeeService {
    private Map<Long, Employee> employeeMap = new HashMap<>();

    public EmployeeServiceImplNotJPA() {
        loadEmployees();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee != null) {
            if(!employeeMap.containsKey(employee.getId())) {
                employee.setId(getNextID());
            }
            employeeMap.put(employee.getId(), employee);
            return employee;
        }

        throw new RuntimeException("customer value cannot be null");

    }

    private Long getNextID(){
        return Collections.max(employeeMap.keySet()) + 1;
    }

    @Override
    public List<Employee> getListOfEmployees() {
        return new ArrayList<Employee>(employeeMap.values());
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeMap.get(id);

    }

    private void loadEmployees(){
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("Steve");
        employee1.setEmail("steve@g.com");
        employee1.setPhoneNumber("123456");

        employeeMap.put(employee1.getId(), employee1);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Steve2");
        employee2.setEmail("steve2@g.com");
        employee2.setPhoneNumber("100456");

        employeeMap.put(employee2.getId(), employee2);
    }

}
