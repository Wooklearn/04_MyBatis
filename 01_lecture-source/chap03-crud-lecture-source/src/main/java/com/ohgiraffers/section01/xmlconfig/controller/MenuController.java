package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.service.MenuService;
import com.ohgiraffers.section01.xmlconfig.view.PrintResult;

import java.util.List;

public class MenuController {

    /* comment.
     *   Controller 의 역할
     *   view 에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면
     *   전달 받은 값들을 검증하거나, "추가적인 정보가 필요하면 가공을 한 뒤
     *   service 쪽으로 전달하기 위한 인스턴스를 생성하여 담고
     *   service 의 비즈니스 로직을 담당하는 메소드를 호출한다."
     *   또한 호출한 수행 결과를 반환 받아 어떤 view 를 보여줄 지
     *   결정하는 역할을 수행하게 된다.
     *  */
    // 안전한 코드를 위해 private final 로 초기화 시켜놓음
    private final MenuService menuService;
    private final PrintResult printResult;

    // MenuController 기본생성자로 MenuService,PrintResult 인스턴스 생성
    // MenuController 객체가 생성 될 때 자동으로 호출됨
    public MenuController() {

        // final 이라는 키워드를 사용할 시 반드시 인스턴스를 생성해줘야한다.
        this.menuService = new MenuService();
        this.printResult = new PrintResult();

    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        // 정상 조회
        if (menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            System.out.println("조회 결과가 없습니다.");
        }

    }



}
