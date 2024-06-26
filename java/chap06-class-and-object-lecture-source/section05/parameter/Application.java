package com.ohgiraffers.section05.parameter;

import java.awt.*;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 메소드의 파라미터에 대해 이해하고 사용할 수 있다. */

        /* 필기.
         *  매개변수(parameter)로 사용 가능한 자료형
         *  1. 기본자료형
         *  2. 기본자료형 배열
         *  3. 클래스자료형
         *  4. 클래스자료형 배열(객체 배열이지만 다음 챕터에서 다를예정)
         *  5. 가변인자
         * */

        ParameterTest pt = new ParameterTest();

        /* 목차. 1. 기본자료형을 매개변수로 전달받는 메소드 호출 */
        /* 필기.
         *  call by value는 리터럴 값을 넘기는 것이라 복사같은개념으로,
         *  넘어가서 무슨변화가 일어나던 현재의 값에 영향을 미치지 않는다.
        * */
        int num = 20;

        System.out.println("call by value 전: " + num);
        pt.testPrimitiveTypeParameter(num);     // call by value(리터럴 값에 의한 호출)
        System.out.println("call by value 후: " + num);

        /* 목차. 2. 기본자료형 배열을 매개변수로 전달 받는 메소드 호출 */
        /* 필기.
         *  call by reference는 참조값 / 주소값을 넘기는 것이라
         *  실제 넘기는 값과 연관이 있어 값의 변화가 일어난다.
        * */
        int[] iArr = new int[]{1, 2, 3, 4, 5};
        System.out.println("call by reference 전" + Arrays.toString(iArr));
        pt.testPrimitiveTypeArrayParameter(iArr);   // call by reference(참조 값에 의한 호출)
        System.out.println("call by reference 후" + Arrays.toString(iArr));

        /* 목차. 3. 클래스 자료형을 매개변수로 전달 받는 메소드 호출 */
        Rectangle r1 = new Rectangle(12.5, 22.5);
//        r1.calArea();
//        r1.calRound();
        pt.testClassTypeParameter(r1);

        /* 목차. 4. 아직 클래스 배열(객체배열)은 배우지 않았으므로 건너 뜀 */

        /* 목차. 5. 가변인자를 매개변수로 전달받는 메소드 호출 */
        pt.testVariableLengthArrayParameter();
        pt.testVariableLengthArrayParameter("홍길동");
        pt.testVariableLengthArrayParameter("유관순", "볼링");


    }
}
