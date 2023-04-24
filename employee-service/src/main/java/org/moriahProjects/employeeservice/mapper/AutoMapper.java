package org.moriahProjects.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.moriahProjects.employeeservice.dto.EmployeeDto;
import org.moriahProjects.employeeservice.entity.Employee;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);

    Employee mapToEmployee(EmployeeDto employeeDto);
    EmployeeDto mapToEmployeeDto(Employee employee);
}
