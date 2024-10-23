package com.ohgiraffers.section01.model.dao;

import com.ohgiraffers.section01.model.dto.EmployeeDTO;
import com.ohgiraffers.section01.model.dto.SearchCriteria;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> salaryBysalary(int salary);

    List<EmployeeDTO> department(SearchCriteria inputdepartment);
}
