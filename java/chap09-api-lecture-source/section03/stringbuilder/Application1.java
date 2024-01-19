package com.ohgiraffers.section03.stringbuilder;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Stirng과 StringBuilder의 차이점에 대해 이해하고 사용할 수 있다. */
        /* 필기.
         * StringBuilder: StringBuffer 보다 성능이 좋음.
         * StringBuffer: thread safe 기능이 추가적으로 동작함. (상대적으로 성능이 안좋음)
         */
        StringBuilder sb = new StringBuilder("java");
        // StringBuilder sb2 = "java";
        System.out.println(sb);

        /* 설명. String과 StringBuilder로 수정 시 객체 주소값 변화 살펴보기 */
        String testStr = "java";
        StringBuilder testSb = new StringBuilder("kotlin");

        for(int i=0; i<9;i++) {
            testStr += i;
            testSb.append(i);

            /* 필기.
             * String은 hashCode() 메소드가 동등 비교를 위해 오버라이딩이 되어 있어 주소값 확인을 하기 힘들다.
             * 따라서 System.identityHashCode() 메소드를 활용해 String으로 관리되는 문자열과 StringBuilder로
             * 관리되는 문자열이 각각 변화를 줄 때 새로운 객체를 생성하는지 살펴보자.
             */

            System.out.println("String의 경우: " +System.identityHashCode(testStr));
            System.out.println("StringBuilder의 경우: "+ System.identityHashCode(testSb));
        }

        System.out.println("String의 결과: " + testStr);
        System.out.println("StringBuilder의 결과: " + testSb);
    }
}
