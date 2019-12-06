<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019/12/6
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录页</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/api/code" alt="">
<form action="${pageContext.request.contextPath}/api/login" method="post">
    <label>
        <input type="text" name="code">
    </label>
    <input type="submit" value="登录">
</form>
</body>
</html>