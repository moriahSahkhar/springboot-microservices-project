package org.moriahProjects.employeeservice.service;

import org.moriahProjects.employeeservice.dto.APIResponseDto;
import org.moriahProjects.employeeservice.dto.DepartmentDto;
import org.moriahProjects.employeeservice.dto.EmployeeDto;
import org.moriahProjects.employeeservice.entity.Employee;
import org.moriahProjects.employeeservice.mapper.AutoMapper;
import org.moriahProjects.employeeservice.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;
//    private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employee = AutoMapper.MAPPER.mapToEmployee(employeeDto);

        return AutoMapper.MAPPER.mapToEmployeeDto(employeeRepo.save(employee));
    }

    public APIResponseDto getEmployeeById(Long empId){
        Employee employee = employeeRepo.findById(empId).get();

        //restTemplate
//        ResponseEntity<DepartmentDto> responseEntity =
//        restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        //webflux
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = AutoMapper.MAPPER.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}

