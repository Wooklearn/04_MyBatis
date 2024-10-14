package com.ohgiraffers.section01.view;

import com.ohgiraffers.section01.controller.Controller;

import java.util.Scanner;

public class MenuView {

    public void display() {

    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();

    do {

        System.out.println("=== HiMedia 회사 ===");
        System.out.println("1. 급여 금액대 직원 조회");
        System.out.println("2. 부서 코드로 직원 조회");
        System.out.println("3. 3명의 직원 랜덤 조회");
        System.out.println("4. 사번 혹은 부서코드로 검색, 사번과 부서코드 둘 다 일치하는 경우도 검색, 검색 조건 없으면 전체 검색");
        System.out.println("5. 직원 정보 부분수정하기");
        System.out.println("9. 종료하기");
        System.out.print("메뉴를 선택해주세요 : ");
        int no = sc.nextInt();

        switch (no) {
            case 1:
                controller.salaryBysalary(inputSalary()); break;
            case 2:
                chooseSubMenu(); break;
            case 3:
                foreachSubMenu(); break;
            case 4:
//                trimSubMenu(); break;
            case 9:
                System.out.println("프로그램 종료"); return;

        }

    } while (true);

}
    private static int inputSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 급여 금액대를 입력해주세요 : ");
        int salary = sc.nextInt();

        return salary;
    }


    private void foreachSubMenu() {

    }

    private void chooseSubMenu() {

    }

    private void ifsubMenu() {

    }


}
