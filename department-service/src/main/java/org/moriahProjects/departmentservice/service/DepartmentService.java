package org.moriahProjects.departmentservice.service;

import lombok.AllArgsConstructor;
import org.moriahProjects.departmentservice.dto.DepartmentDto;
import org.moriahProjects.departmentservice.entity.Department;
import org.moriahProjects.departmentservice.mapper.AutoMapper;
import org.moriahProjects.departmentservice.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){

        Department department = AutoMapper.MAPPER.mapToDepartment(departmentDto);

        return AutoMapper.MAPPER.mapToDepartmentDto(departmentRepo.save(department));
    }

    public DepartmentDto getDepartmentByCode(String code){
      return AutoMapper.MAPPER.mapToDepartmentDto(departmentRepo.findByDepartmentCode(code));
    }
}
