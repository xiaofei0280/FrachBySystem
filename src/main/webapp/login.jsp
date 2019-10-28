<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2019/10/25
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
   <form action="${pageContext.request.contextPath}/userlogin" method="post" enctype="application/x-www-form-urlencoded">

       用户名：<input type="text" name="username" placeholder="请输入用户名"/><br/>
       密码：<input type="password" name="password" placeholder="请输入密码"/>
       <input type="submit" value="登录"/>
   </form>

</body>
</html>
