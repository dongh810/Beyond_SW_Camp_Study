package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String args[]) {

        // 한 줄 주석
        /* 범위주석 */
        // 필기. -> 주석은 보통 한줄 띄고 씀

        /* 수업목표. 여러가지 값의 형태를 출력할 수 있다. */
        /* 목차. 1. 숫자 형태의 값 */
        /* 목차. 1-1. 정수 형태의 값 출력 */
        System.out.println(123);

        /* 목차. 1-2. 실수 형태의 값 출력 */
        System.out.println(1.234);

        /* 목차. 2. 문자 형태의 값 출력 */
        System.out.println('a');            // 문자는 single quatation(')을 적용한다.
        System.out.println('1');            // 숫자도 single quatation(')을 적용한다.
        System.out.println('\u0000');       // 문자를 아무것도 안넣을때는 이렇게 씀.


        /* 목차. 3. 문자열 형태의 값 출력 */
        System.out.println("안녕하세요");     // 문자열은 double quatation(*)을 적용한다.
        System.out.println("a");

        /* 목차. 4. 논리 형태의 값 출력 */
        System.out.println(true);
        System.out.println(false);          // true 또는 false 두 값만 논리 값이다.
        System.out.println("true");         // double quatation이 붙으면 문자열

    }
}
