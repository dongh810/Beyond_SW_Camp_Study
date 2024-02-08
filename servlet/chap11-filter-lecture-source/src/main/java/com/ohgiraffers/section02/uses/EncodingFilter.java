package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명. 우린 톰캣 10 버전인데 톰캣 10 버전은 기본 인코딩 설정이 UTF-8이라 안해줘도 된다. */
        /* 설명. 요청이 POST 요청일 때는 UTF-8로 인코딩 설정을 사전처리 해주고 이후 필터나 서블릿으로 넘길 수 있다. */
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(httpRequest, servletResponse);
    }
}
