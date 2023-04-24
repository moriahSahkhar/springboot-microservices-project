package org.moriahProjects.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}
