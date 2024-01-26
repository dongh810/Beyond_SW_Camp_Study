package com.ohgiraffers.section04.assignment.run;

import com.ohgiraffers.section04.assignment.aggrgate.BloodType;
import com.ohgiraffers.section04.assignment.aggrgate.Member;
import com.ohgiraffers.section04.assignment.service.MemberService;

import java.util.Scanner;

/* 설명. 프로그램 실행 및 메뉴 출력과 사용자의 입력을 받을 View에 해당하는 클래스 */
public class Application {

    private static final MemberService mm = new MemberService();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("==========회원 관리 프로그램==========");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: mm.selectAllMembers();
                    break;
                case 2:
                    mm.selectMember(chooseMemberNo());
                    break;
                case 3:
                    mm.registMember(signUp());
                    break;
                case 4:
                    mm.deleteMember(chooseMemberNo());
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 제대로 다시 입력해 주세요");
            }
        }
    }

    /* 설명. 회원 한명 조회를 위해 해당 회원 번호를 입력받아 반환하는 메소드 */
    private static int chooseMemberNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원번호를 입력하세요: ");
        return sc.nextInt();
    }

    /* 설명. 사용자로부터 회원번호를 제외한 정보를 입력받아(회원가입용 정보) Member타입으로 반환하는 메소드(파싱 및 가공처리) */
    private static Member signUp() {
        Member newInfo = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.print("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.println("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("입력 할 취미 개수를 입력하세요(숫자로 1이상): ");
        int length = sc.nextInt();
        sc.nextLine();                  // Scanner 버퍼에 남아있을 엔터 제거용

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i+1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }
        newInfo = new Member(id, pwd, age, hobbies,name);

        System.out.print("혈액형을 입력하세요(A,AB,B,O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType br = null;
        switch (bloodType) {
            case"A":br = BloodType.A; break;
            case"AB":br = BloodType.AB; break;
            case"B":br = BloodType.B; break;
            case"O":br = BloodType.O; break;
        }

        /* 필기.
         *  회원으로부터 회원가입을 위한 정보를 입력받아 Member 타입객체 하나로 가공 처리할 때 방법이 두가지가 있다.
         *  1. 생성자 방식(장: 한줄코딩 가능, 단: 따로 생성자 추가)
         *  2. setter 방식 (장: 초기화 할 갯수 수정 용이, 단: 코딩 줄 수 늘어날 수 있음)
        * */
        newInfo.setBloodType(br);

        return newInfo;
    }

}
