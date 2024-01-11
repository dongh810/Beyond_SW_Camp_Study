package com.ohgiraffers.section01.method;

public class Application3 {

    int global =10;                 // 전역변수 (지역변수가 우선순위가 더 높음)

    public static void main(String[] args) {

        int global = 20;            // 지역변수
        System.out.println("global = " + global);

        /* 수업목표. 메소드 전달 인자와 매개변수에 대해 이해하고 메소드 호출 시 활용할 수 있다. */
        /* 필기.
         *  전달인자(argument)와 매개변수(parameter)를 이용한 메소드 호출
         *  지금까지 우리가 배운 변수는 지역변수에 해당한다.
        * */

        /* 필기.
         *  변수의 종류(자료형과는 다른 구분방식)
         *  1. 지역변수
         *  2. 매개변수
         *  3. 전역변수(필드)
         *  4. 클래스(static)변수
        * */

        Application3 app3 = new Application3();
        app3.testMethod(10);    // 10은 전달인자이다.
        app3.testMethod(19);
        app3.testMethod('a');
        app3.testMethod((int)12.34);

    }

    /* 설명. 정수를 주면 나이를 출력해주는 기능을 가진 메소드(non-static) */
    // int age는 매개변수 이자 testMethod안에서만 쓰는 지역변수
    public void testMethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

}
