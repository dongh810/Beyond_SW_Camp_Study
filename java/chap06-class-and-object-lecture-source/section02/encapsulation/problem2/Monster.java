package com.ohgiraffers.section02.encapsulation.problem2;

public class Monster {
//    String name;
//    int hp;

    /* 설명. 필드의 변수명이 바꼈다면 */
    String kinds;
    int mp;

    void setInfo1(String info1) {
        this.kinds = info1;
    }

    void setInfo2(int info2) {
        this.mp = info2;
    }
}
