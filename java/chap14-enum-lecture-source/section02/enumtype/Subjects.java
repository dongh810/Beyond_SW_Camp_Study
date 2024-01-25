package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    JAVA,               // 0
    MARIADB,            // 1
    JDBC,               // 2
    HTML,               // 3
    CSS,                // 4
    JAVASCRIPT;          // 5  -> 필드가 끝나면 마지막에 세미콜론찍기

    Subjects() {
        System.out.println("기본 생성자 호출");
    }

    @Override
    public String toString() {
        return "@@@" + this.name() + "@@@";
    }
}
