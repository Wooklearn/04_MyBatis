package com.ohgiraffers.section01.model.service;

import com.ohgiraffers.section01.model.dao.EmployeeMapper;
import com.ohgiraffers.section01.model.dto.DepartmentDTO;
import com.ohgiraffers.section01.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.common.Template.getSqlSession;

public class EmployeeService {

    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> salaryBysalary(int salary) {
        // 공장 만들기 - 데이터 넣을 준비  /  불렀고
        SqlSession sqlSession = getSqlSession();
        // 매퍼를 쓴다 - 객체화 시켜줘야함
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = employeeMapper.salaryBysalary(salary);

        sqlSession.close();

        return employeeList;

    }

    public List<EmployeeDTO> departmentName1(Map<String, String> dept) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

//        List<EmployeeDTO> employeeList = employeeMapper.Department(dept);

//        sqlSession.close();
//
//        return dept;

        return null;

    }
}
