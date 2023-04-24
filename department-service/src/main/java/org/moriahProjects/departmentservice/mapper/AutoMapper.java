package org.moriahProjects.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.moriahProjects.departmentservice.dto.DepartmentDto;
import org.moriahProjects.departmentservice.entity.Department;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
