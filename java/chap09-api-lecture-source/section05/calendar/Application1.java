package com.ohgiraffers.section05.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Date 클래스 사용법을 이해하고 사용할 수 있다.  */
        Date today = new Date();
        System.out.println("today = " + today);

        System.out.println("long 타입 시간: " + today.getTime());
        System.out.println("long 타입 시간을 활용한 Date형: " + new Date(today.getTime()));
        System.out.println("기준시간(1970년 9시 0분 0초: " + new Date(0L));

        /* 설명. 우리가 원하는 형태로 출력해 보기(feat. SimpleDateFormat, long타입 활용하기) */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat = " + todayFormat);

        /* 설명. java.util.Date -> java.sql.Date */
        java.sql.Date sqlDate = new java.sql.Date(today.getTime()); // java.util.Date를 long형을 변환 sql.Date
//        java.sql.Date sqlDate2 = (java.sql.Date)today;            // 실제로는 sql.Date형이었던 날짜형을 util.Date형인 today에 담겨 있었다면 이 방법도 가능하다.

        /* 설명. java.sql.Date -> java.util.Date */
        java.util.Date utilDate = sqlDate;

    }
}
