package com.ohgiraffers.section01.array;

public class Application5 {

    public static void main(String[] args) {

        /* 수업목표. 배열을 사용하는 예시를 통해 카드 게임을 작성해 보자. */
        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        int randomShapeIndex = (int)(Math.random() * 3) + 0;           // 0 ~ 3
        int randomCardNumberIndex = (int)(Math.random() * 12) + 0;;      // 0 ~ 11

        // System.out.println("당신이 뽑은 카드는 " + shape[0] + cardNumbers[0] + " 카드 입니다.");
        System.out.println(randomShapeIndex + " " +randomCardNumberIndex);
        System.out.println("당신이 뽑은 카드는 " + shape[randomShapeIndex]
                            +cardNumbers[randomCardNumberIndex] + " 카드 입니다.");

    }
}
