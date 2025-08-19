package com.wipro.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wipro.ems.entity.Employee;
import com.wipro.ems.service.DepartmentService;
import com.wipro.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService; 

    @GetMapping("")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee-form";
    }
    

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee){
        Employee existingEmployee = employeeService.getEmployeeById(employee.getId());
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmployeeType(employee.getEmployeeType());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setAddress(employee.getAddress());
        
        employeeService.addEmployee(existingEmployee); // save will update existing row
        return "redirect:/employees";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
