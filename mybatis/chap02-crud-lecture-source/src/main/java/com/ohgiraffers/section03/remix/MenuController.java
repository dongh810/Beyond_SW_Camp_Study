package com.ohgiraffers.section03.remix;


import java.awt.*;
import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;
    public void findAllMenu() {
        List<MenuDTO> menus = menuService.findAllMenu();
        if(!menus.isEmpty()) {
            printResult.printMenus(menus);
        } else {
            printResult.printErrorMessage("전체 메뉴 조회 실패!");
        }
    }

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void findMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenu(menuCode);
        if(menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }

    public void addMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));
        int categoryCode = Integer.valueOf(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if(menuService.addMenu(menu)){
            printResult.printSuccessMessage("regist");
        } else {
            printResult.printErrorMessage("메뉴 추가 실패!");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));


        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        System.out.println(menu.toString());
        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("modify");
        } else {
            printResult.printErrorMessage("메뉴 수정 실패!");
        }
    }

    public void removeMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        if(menuService.removeMenu(menuCode)){
            printResult.printSuccessMessage("remove");
        } else {
            printResult.printErrorMessage("메뉴 삭제 실패!");
        }
    }
}
