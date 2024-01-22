package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 컬렉션 프레임워크에 대해 이해할 수 있다. */
        ArrayList aList = new ArrayList();
//        ArrayList<Object> aList = new ArrayList<>();      // 다이아몬드 연산자 없는 제네릭 클래스는 <Object>와 같다.

        List list = new ArrayList();                        // 컬렉션은 다형성을 적용한 형태로 많이들 쓴다.
//        Collection col = new ArrayList();

        aList.add("apple");
        aList.add(123);
        aList.add(45.67);
        aList.add(new java.util.Date());

        System.out.println("aList = " + aList);
        System.out.println("첫 번째 저장된 값: " + aList.get(0));
        System.out.println("두 번째 저장된 값: " + aList.get(1));
        System.out.println("aList에 담긴 데이터의 크기: " + aList.size());   // 우리가 ArrayList에 추가한 값의 크기

        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i).toString());
        }

        /* 필기.
         *  배열보다 ArrayList가 나은점
         *  1. 처음부터 크기 할당 불필요
         *  2. 중간에 값 추가 및 삭제가 용이
         * */

        /* 설명. 배열과 ArrayList를 활용해 각각 원하는 인덱스에 값 추가해보기 */
        int[] intArr = new int[5];
        int num =0;
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = ++num;
        }
        System.out.println(Arrays.toString(intArr));

        int[] newArr = new int[intArr.length + 1];
        System.arraycopy(intArr, 0, newArr, 0, intArr.length);
        System.out.println(Arrays.toString(newArr));

        /* 설명. 2번 인덱스 자리에 7를 끼워넣기 */
        for (int i = newArr.length - 2; i > 1; i--) {   // 기존의 값을 뒤로 옮길 때 앞의 인덱스부터 옮기면 안됨
            newArr[i + 1] = newArr[i];
        }
        System.out.println(Arrays.toString(newArr));

        newArr[2] = 7;

        System.out.println(Arrays.toString(newArr));

        /* 설명. ArrayList에서 제공하는 add메소드로 쉽게 해 보자. */
        ArrayList<Integer> intArrList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            intArrList.add(i+1);
        }
        System.out.println(intArrList);
        intArrList.add(2, 7);
        System.out.println(intArrList);

        /* 설명. ArrayList는 중복 저장을 허용한다. */
        System.out.println(aList);
        aList.add(123);
        aList.add("apple");
        System.out.println(aList);

        /* 설명. set()메소드로 원하는 인덱스의 값을 원하는 값으로 수정할 수 있다. */
        aList.set(1,777);
        System.out.println(aList);

        /* 설명. remove() 메소드로 원하는 인덱스의 값을 삭제 할 수 있다. */
        aList.remove(1);
        System.out.println(aList);

        aList.add(null);
        System.out.println(aList);
    }
}
