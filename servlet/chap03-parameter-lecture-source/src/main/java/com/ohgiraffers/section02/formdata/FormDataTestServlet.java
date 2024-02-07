package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/* 설명. form 태그의 method="post"로 post 요청으로 넘어온 데이터(parameter) 꺼내보기 */
@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    public FormDataTestServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. tomcat 9버전 이하는 post요청일 때 한글이 깨지지 않으려면 UTF-8 인코딩 설정을 해주어야 한다. */
        req.setCharacterEncoding("UTF-8");

        /* 설명. 키 값을 통해 파라미터들을 하나씩 꺼내는 과정을 get방식과 동일하다. */
        String name = req.getParameter("name");
        System.out.println("name = " +name);

        int age = Integer.valueOf(req.getParameter("age"));
        System.out.println("age = " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthday = " + birthday);

        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);

        String national = req.getParameter("national");
        System.out.println("national = " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("Arrays.toString(hobbies) = "+ Arrays.toString(hobbies));

        /* 설명. 요청으로 넘어오는 파라미터들의 키 값들을 한번에 확인해 보기 */
        Enumeration<String> names= req.getParameterNames();
        while(names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }
}
