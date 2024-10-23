package com.ohgiraffers.section01.controller;

import com.ohgiraffers.section01.model.dto.EmployeeDTO;
import com.ohgiraffers.section01.model.dto.SearchCriteria;
import com.ohgiraffers.section01.model.service.EmployeeService;
import com.ohgiraffers.section01.view.PrintResult;

import java.util.List;
import java.util.Map;

public class Controller {

    // 안전한 코드를 위해 private final 로 초기화 시켜놓음
    private final EmployeeService employeeService;
    private final PrintResult printResult;

    public Controller() {
        this.employeeService = new EmployeeService();
        this.printResult = new PrintResult();
    }

    public void salaryBysalary(int salary) {

        List<EmployeeDTO> employeeDTO = employeeService.salaryBysalary(salary);

        // 정상 조회
        if (employeeDTO != null) {
            printResult.printSalaryList(employeeDTO);
        } else {
            printResult.printErrorMessage("selectSalary");
        }
    }

    public void department(SearchCriteria deptCode) {

        List<EmployeeDTO> employeeList = employeeService.department(deptCode);

        if (employeeList != null) {
            printResult.departmentPrint(employeeList);
        } else {
            printResult.printErrorMessage("selectSalary");
        }

    }
}
