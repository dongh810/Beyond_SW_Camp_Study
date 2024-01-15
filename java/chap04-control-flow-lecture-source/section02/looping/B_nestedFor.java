package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        /* 수업목표. 중첩된 for문의 흐름을 이해하고 적용할 수 있다. */

        /* 설명.
         *  2단
         *  2 * 1 = 2
         *  2 * 2 = 4
         *  2 * 3 = 6
         *  ...
         *  9 * 9 = 81
         * */

        for (int i = 2; i < 10; i++) {          // 단수: 2~9
            System.out.println(i + "단수의 곱");
            for (int j = 1; j < 10; j++) {      // 곱해지는 수: 1~9
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }

    public void printUpgradeGugudanFromTwoToNine() {

        /* 수업목표. inner for문을 메소드로 따로 모듈화 해보자. (하나의 기능 단위로 보고) */
        for (int dan = 2; dan < 10; ++dan) {
            System.out.println(dan + "수 출력");
            printGugudanOf(dan);
            System.out.println();
        }
    }

    /* 설명. 단수를 넘기면 1~9까지 곱해서 숫자를 출력해주는 기능 */
    private void printGugudanOf(int dan) {
        for (int su = 1; su < 10; su++) {
            System.out.println(dan + " * " + su + " = " + (dan * su));
        }
    }

    /* 설명.
     *  아래와 같은 별모양이 나오도록 작성해 보자.
     *      *
     *     **
     *    ***
     *   ****
     *  *****
     * */
    public void printStars() {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        for (int i = 1; i <= input; i++) {
            /* 설명. 공백 출력용 안쪽 for문  */
//            for (int j = 1; j <= 5 - i; j++) {
//                System.out.print(" ");
//            }
            printSpace(input, i);
            /* 설명. 별 출력용 안쪽 for문 */
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
            printStars(i);
            System.out.println();
        }
    }
    private void printSpace ( int input, int i){
        for (int j = 1; j <= input - i; j++) {
            System.out.print(" ");
        }
    }

    private void printStars ( int i){
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }
    }
}
