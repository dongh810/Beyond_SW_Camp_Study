<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
    <h1 align="center">Service Method</h1>
    <h3>GET 방식의 요청</h3>
    <h4>a태그의 href 속성값 변경</h4>
    <a href="request-service">서비스 메소드 요청하기</a>

    <h3>POST 방식의 요청</h3>
    <h4>form 태그의 method 속성을 post로 설정</h4>
    <form action="request-service" method="post">
        <input type="submit" value="POST 방식 요청 전송">
    </form>

</body>
</html>