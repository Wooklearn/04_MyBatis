package com.ohgiraffers.section01.model.dao;

import com.ohgiraffers.section01.model.dto.DepartmentDTO;
import com.ohgiraffers.section01.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> salaryBysalary(int salary);

    List<EmployeeDTO> Department(DepartmentDTO department);
}
