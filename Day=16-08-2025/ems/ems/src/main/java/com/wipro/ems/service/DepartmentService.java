package com.wipro.ems.service;

import com.wipro.ems.entity.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
}
