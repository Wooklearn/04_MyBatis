package com.ohgiraffers.section01.view;

import com.ohgiraffers.section01.model.dto.EmployeeDTO;

import java.util.List;

public class PrintResult {


    public void printErrorMessage(String selectList) {
        String errorMessage = "";

        switch (selectList) {
            case "selectSalary" :
                errorMessage = "급여 조회에 실패하셨습니다.";
                break;
            case "departmentName":
                errorMessage = "부서명 조회에 실패하셨습니다.";
                break;
        }
        System.out.println(errorMessage);




    }

    // 급여 조회 성공 시
    public void printSalaryList(List<EmployeeDTO> employeeDTO) {

        System.out.println("직원 급여 조회 결과입니다.");

        for (EmployeeDTO empDTO : employeeDTO) {
            System.out.println("employeeDTO = " + empDTO);
        }


    }

    public void departmentPrint(List<EmployeeDTO> employeeList) {

        System.out.println("부서명 조회 결과입니다.");

        for (EmployeeDTO empDTO : employeeList) {
            System.out.println(empDTO);
        }

    }
}
