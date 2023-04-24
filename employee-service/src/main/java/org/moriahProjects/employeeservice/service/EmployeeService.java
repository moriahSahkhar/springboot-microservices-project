package org.moriahProjects.employeeservice.service;

import lombok.AllArgsConstructor;
import org.moriahProjects.employeeservice.dto.APIResponseDto;
import org.moriahProjects.employeeservice.dto.DepartmentDto;
import org.moriahProjects.employeeservice.dto.EmployeeDto;
import org.moriahProjects.employeeservice.entity.Employee;
import org.moriahProjects.employeeservice.mapper.AutoMapper;
import org.moriahProjects.employeeservice.repository.EmployeeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;
    private RestTemplate restTemplate;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employee = AutoMapper.MAPPER.mapToEmployee(employeeDto);

        System.out.println("HERE:::"+employeeDto.toString());
        System.out.println("HERE2:::"+employee.getDepartmentCode());

        return AutoMapper.MAPPER.mapToEmployeeDto(employeeRepo.save(employee));
    }

    public APIResponseDto getEmployeeById(Long empId){
        Employee employee = employeeRepo.findById(empId).get();

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
                DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = AutoMapper.MAPPER.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}

