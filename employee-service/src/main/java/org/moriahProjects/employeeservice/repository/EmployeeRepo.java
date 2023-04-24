package org.moriahProjects.employeeservice.repository;

import org.moriahProjects.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
