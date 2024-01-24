package com.ohgiraffers.section02.userexception;



public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의의 예외클래스 정의후 발생한 사용자 정의의 예외를 처리할 수 있다. */
        ExceptionTest et= new ExceptionTest();

        try {
            et.checkEnoungMoney(30000, -50000);
            // et.checkEnoungMoney(-30000, 50000);
            // 여러가지를 테스트해보고 싶으면 하나씩 주석해가면서 해야된다.
        } /*catch (PriceNegativeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } catch (MoneyNegativeException e) {
            System.out.println(e.getMessage());
        }*/
        catch ( Exception e ) {         // 다형성을 활용한 catch 처리방식
            System.out.println("예외 메시지: " + e.getMessage());
        }
    }
}
