package com.wipro.ems.service;

import com.wipro.ems.entity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getAllEmployees();
}
