package com.myemployeee.controllers;

import com.myemployeee.model.Employee;
import com.myemployeee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private EmployeeService employeeService;

    @Autowired
    public IndexController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/", "/employees"})
    public String index(Model model){
        model.addAttribute("employees", employeeService.getListOfEmployees());
        return "index";
    }

}
