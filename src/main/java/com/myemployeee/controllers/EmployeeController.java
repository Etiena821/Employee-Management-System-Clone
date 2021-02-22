package com.myemployeee.controllers;

import com.myemployeee.model.Employee;
import com.myemployeee.service.EmployeeService;
import com.myemployeee.service.impl.EmployeeServiceImplJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee) {
       Employee savedEmployee = employeeService.addEmployee(employee);
        return "redirect:/employees/view-employee/" + savedEmployee.getId();
    }

    @GetMapping("/view-employee/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "view-employee";
    }


    @GetMapping("/edit-employee/{id}")
    public String showEditEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }


}
