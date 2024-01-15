package com.ohgiraffers.section03.branching;

import java.util.Scanner;

public class A_break {
    public void testSimpleBreakStatement() {

        /* 수업목표. break문 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        /* 필기. break문은 반복문 안에 사용하며 자신을 포함한 가장 가까운 반복문을 빠져나감(switch믄의 break와는 다름) */
        int sum = 0;
        int i = 1;
        while (true) {                               // 무한루프(infinite loop)
            sum += i;
            System.out.println("sum = " + sum);

            if (i == 10) {
                break;
            }
            i++;
        }
    }

    public void testPrintStarsWithBreakStatement() {

        /* 필기. 중첩반복문을 활용하는 별찍기 문제에서 안쪽 for문 안에 break를 활용하여 효율적인 반복문을 작성해 본다, */
        /* 설명.
         *  양의 정수를 입력하시오: 5
         *  *
         *  **
         *  ***
         *  ****
         *  *****
         * */

        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수를 입력하시오: ");
        int input = sc.nextInt();
        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= input; j++) {
                System.out.print("*");
                if(j == i) {                        // 안쪽 for문이 도는 횟수가 바깥쪽 행의 수와 같으면
                    break;                          // 안쪽 for문을 멈춰라(쓸데없이 더 돌지 않도록 함)
                }
            }
            System.out.println();
        }
    }
}
