package com.wipro.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.ems.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
}
