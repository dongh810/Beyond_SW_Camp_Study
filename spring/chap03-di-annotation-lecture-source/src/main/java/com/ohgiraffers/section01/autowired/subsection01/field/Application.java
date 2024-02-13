package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* 설명.
         *  AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하여 ComponentScan
         *  개념을 따로 설정 클래스 없이 바로 적용할 수도 있다.
        * */
        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        /* 필기. 위의 링크아래에 @Component가 있나 하나씩 찾아본다.  */

        System.out.println("콩 가져오기전");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println("콩 가져온후");

        /* 설명. 전체 도서 목록 조회 후 출력 확인 */
        bookService.findAllBook().forEach(System.out::println);



        /* 설명. 도서 번호로 검색 후 출력 확인 */
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));
    }
}
