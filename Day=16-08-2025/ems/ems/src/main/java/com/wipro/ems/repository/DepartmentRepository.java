package com.wipro.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
