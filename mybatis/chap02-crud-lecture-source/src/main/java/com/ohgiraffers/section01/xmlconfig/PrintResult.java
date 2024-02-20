package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printErrorMessage(String message) {
        System.out.println("에러 메시지: " + message);
    }

    public void printMenus(List<MenuDTO> menuList) {
        menuList.forEach(System.out::println);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("menu = " + menu);
    }

    public void printSuccessMessage(String statusCode) {
        String successMessage = "";
        switch(statusCode) {
            case "regist" :
                successMessage = "신규메뉴 등록에 성공하였습니다."; break;
            case "modify" :
                successMessage = "메뉴 수정에 성공하였습니다."; break;
            case "delete":
                successMessage = "메뉴 삭제에 성공하였습니다.";
        }
    }
}
