package com.wipro.ems.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.wipro.ems.repository.DepartmentRepository;
import com.wipro.ems.entity.Department;
import com.wipro.ems.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
