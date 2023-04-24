package org.moriahProjects.departmentservice.repository;

import org.moriahProjects.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String code);
}
