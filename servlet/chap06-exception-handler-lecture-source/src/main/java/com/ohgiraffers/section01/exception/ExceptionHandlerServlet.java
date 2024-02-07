package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    public ExceptionHandlerServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명.
         *  request는 사실상 하나의 요청부터 응답까지 유지되는 임시 저장 공간이기도 하다.
         *  이 공간에 값을 담기 위해서는 setAttribute()라는 메소드를 써서 담을 수 있고
         *  값을 다시 추출하고자 할 때는 getAttribute()라는 메소드를 쓸 수 있다.(키와 벨류 형태로)
        * */

        /* 설명. request attribute에는 에러와 관련된 정보가 들어있다. 확인해 보자. */
        Enumeration<String> attrNames = req.getAttributeNames();
        while(attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        /* 설명. request의 attribute에 에러 관련 된 것들을 활용하여 에러 전용 페이지를 만들어 응답 */
        int statusCode = (int)req.getAttribute("jakarta.servlet.error.status_code");
        String message = (String) req.getAttribute("jakarta.servlet.error.message");
        String servletName = (String) req.getAttribute("jakarta.servlet.error.servlet_name");

        System.out.println("statusCode = " + statusCode);
        System.out.println("message = " + message);
        System.out.println("servletName = " + servletName);

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1 align=\"center\">")
                .append(statusCode)
                .append("-")
                .append(message)
                .append("<br>\n")
                .append("<p>에러 발생한 서블릿 명: ")
                .append(servletName)
                .append("</p>")
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print(errorPage);
        out.flush();
        out.close();
    }
}
