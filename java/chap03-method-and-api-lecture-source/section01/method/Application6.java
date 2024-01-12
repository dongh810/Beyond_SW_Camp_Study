package com.ohgiraffers.section01.method;

public class Application6 {

    public static void main(String[] args) {

        /* 수업목표. 반환값이 있는 메소드 테스트해 보기 */
        System.out.println("main() 메소드 시작됨...");

        Application6 app6 = new Application6();
        String returnText = app6.testMethod();

        System.out.println("returnText = " + returnText);
        System.out.println("returnText = " + app6.testMethod()); // 표현식: 하나의 리터럴로 치환될 식

        System.out.println("main() 메소드 종료됨...");
    }

    private String testMethod() {
        System.out.println("test() 메소드 실행됨...");
        return "test";
    }
}
