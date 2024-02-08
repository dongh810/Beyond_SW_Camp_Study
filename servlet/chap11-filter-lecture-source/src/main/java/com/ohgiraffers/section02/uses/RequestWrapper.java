package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {

        /* 설명. 'password'라는 키값으로 getParamter 사용 시에 그 반환값은 암호화 해서 반환 */
        String value = "";
        if("password".equals(key)) {
            System.out.println("패스워드 꺼낼 시");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter("password"));
            System.out.println("패스워드 = " + value);
        } else {                // 그 외의 키 값 사용 시에는 기존대로 동작
            value = super.getParameter(key);
            System.out.println("패스워드가 아닌 value = " + value);
        }



        return value;
    }
}
