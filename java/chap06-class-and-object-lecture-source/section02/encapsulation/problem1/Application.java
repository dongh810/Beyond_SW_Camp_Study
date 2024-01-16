package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해할 수 있다. */
        Monster monster1 = new Monster();

        /* 설명. 1번 몬스터 생성 */
        monster1.name = "두치";           // 참조연산자(.)를 통해 값 대입
        monster1.hp = 200;

        /* 설명. 몬스터 정보 출력 */
        System.out.println("monster1의 이름: " + monster1.name);       // 참조연산자를 통한 값 출력
        System.out.println("monster1의 체력: " + monster1.hp);

        /* 설명. 2번 몬스터 생성 */
        Monster monster2 = new Monster();
        monster2.name = "뿌꾸";
        monster2.hp = -200;

        System.out.println("monster2의 이름: " + monster2.name);
        System.out.println("monster2의 체력: " + monster2.hp);

        /* 설명. 3번 몬스터 생성(setter를 통한 접근) */
        Monster monster3 = new Monster();
        monster3.name = "드라큘라";
        monster3.setHp(100);            // monster3의 hp공간에 100이 할당된다.


        System.out.println("monster3의 이름: "+monster3.name);
        System.out.println("monster3의 체력: "+monster3.hp);

        /* 설명. 4번 몬스터 생성(setter를 통한 접근) */
        Monster monster4 = new Monster();
        monster4.name = "프랑켄슈타인";
        monster4.setHp(-100);

        System.out.println("monster4의 이름: " + monster4.name);
        System.out.println("monster4의 체력: " + monster4.hp);

    }
}
