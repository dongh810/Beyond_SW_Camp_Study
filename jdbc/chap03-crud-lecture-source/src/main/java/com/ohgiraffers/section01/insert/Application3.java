package com.ohgiraffers.section01.insert;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색을 원하는 카테고리 코드를 입력하세요: ");
        int category_code = sc.nextInt();
        MenuService service = new MenuService();
        service.getMenu(category_code);
    }
}
