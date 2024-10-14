package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        /* title. Mybatis Dynamic SQL 확인하기 */

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("=== 마이바티스 동적 SQL 학습 메뉴 ===");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    ifsubMenu(); break;
                case 2:
                    chooseSubMenu(); break;
                case 3:
                    foreachSubMenu(); break;
                case 4:
                    trimSubMenu(); break;
                case 9:
                    System.out.println("프로그램 종료"); return;

            }

        } while (true);

    }

    private static void trimSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("====== trim 서브메뉴 ======");
            System.out.println("1. 검색 조건이 있는 경우 메뉴코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색, 검색 조건 없으면 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.print("원하시는 메뉴를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuService.searchMenuByCodeOrSearchAll(inputAllOrOne()); break;
                case 2 : menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 3 : menuService.modifyMenu(inputCaange()); break;

            }

        } while (true);

    }

    private static Map<String, Object> inputCaange() {

        Scanner sc = new Scanner(System.in);
        System.out.print("변경 할 메뉴 코드를 입력해주세요 : ");
        int code = sc.nextInt();
        System.out.print("변경 할 메뉴 이름을 입력해주세요 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("변경 할 카테고리 코드를 입력해주세요 : ");
        int categoryCode = sc.nextInt();
        System.out.print("판매여부 결정해주세요(Y/N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("code", code);
        criteria.put("name", name);
        criteria.put("categoryCode", categoryCode);
        criteria.put("orderableStatus", orderableStatus);

        return criteria;

    }

    // Object 로 설정하면 모든 것 사용 가능
    private static Map<String, Object> inputSearchCriteriaMap() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건(category or name or both or null) : ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        if ("category".equals(condition)) {
            System.out.print("검색할 카테고리 코드를 입력해주세요 : ");
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue", categoryValue);
        } else if ("name".equals(condition)) {
            System.out.print("검색할 메뉴이름을 입력해주세요 : ");
            String nameValue = sc.nextLine();
            criteria.put("nameValue", nameValue);
        } else if ("both".equals(condition)) {
            System.out.print("검색할 메뉴이름을 입력해주세요 : ");
            String nameValue = sc.nextLine();
            System.out.print("검색할 카테고리 코드를 입력해주세요 : ");
            int categoryValue = sc.nextInt();
            criteria.put("nameValue",nameValue);
            criteria.put("categoryValue",categoryValue);
        }

        return criteria;

    }

    private static SearchCriteria inputAllOrOne() {
        // SearchCriteria -> 검색조건 // value -> 값
        Scanner sc = new Scanner(System.in);
        System.out.print("검색조건을 입려하시겠습니까?(예 OR 아니오) : ");
        boolean hasSearchValue = "예".equals(sc.nextLine()) ? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();
        // 우리가 "예" 라고 입력 했을 때 동작할 구문
        if (hasSearchValue) {
            System.out.print("검색할 메뉴 코드를 입력해주세요 : ");
            String code = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }

        return searchCriteria;

    }

    private static void foreachSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("====== foreach 서브메뉴 ======");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴");
            System.out.print("원하시는 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuByRandomCode(crateRandomCodeList()); break;
                case 9:
                    return;
            }

        } while (true);

    }

    private static List<Integer> crateRandomCodeList() {

        // 5개의 중복되지 않는 메뉴코드 생성
        Set<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            // 내 컴퓨터에 들어있는 메뉴 갯수 23개
            int temp = ((int) (Math.random() * 24)) + 1;
            set.add(temp);
        }
        List<Integer> menuCodeList = new ArrayList<>(set);
        Collections.sort(menuCodeList);

        return menuCodeList;

    }

    private static void chooseSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {

            System.out.println("====== choose 서브메뉴 ======");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuBySupCategory(inputSupCategory()); break;
                case 2:
                    chooseSubMenu(); break;
                case 3:


                case 9:
                    return;

            }

        } while (true);
        
        
    }

    private static SearchCriteria inputSupCategory() {

        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류를 입력해주세요(식사, 음료, 디저트) : ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);

    }

    private static void ifsubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("====== if 서브메뉴 ======");
            System.out.println("1. 원하는 금액 대 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("원하는 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.selectMenuByPrice(inputPrice()); break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria()); break;
                case 9:
                    System.out.println("if 서브메뉴 종료"); return;
            }
            
        } while (true);
        
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 선택해주세요(menuName or category) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);

    }

    private static int inputPrice() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색하길 가격의 최대 금액을 입력해주세요 : ");
        int price = sc.nextInt();

        return price;
        
    }

}
