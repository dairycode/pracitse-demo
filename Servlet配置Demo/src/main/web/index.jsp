<%--
  Created by IntelliJ IDEA.
  User: liuze
  Date: 2020/2/27
  Time: 1:20 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet</title>
</head>
<body>
<!-- web.xml中的/: 代表项目根路径(http://localhost:8080/Servlet/) -->
<!-- jsp中的/: 服务器根路径(http://localhost:8080/) -->
<a href="WelcomeServlet2.5">WelcomeServlet2.5</a>
<form action="WelcomeServlet2.5" method="post">
    <input type="submit">
</form>
<a href="WelcomeServlet3.0">WelcomeServlet3.0</a>
<form action="WelcomeServlet3.0" method="post">
    <input type="submit">
</form>
</body>
</html>
