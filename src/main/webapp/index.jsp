<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>

      <script src="js/jquery-1.12.4.min.js" type="text/javascript"></script>
</head>
<body>

<div>
    <h2>
        <shiro:user>
            欢迎您：<shiro:principal></shiro:principal>
        </shiro:user>
    </h2>
    <h2 align="center">天天生鲜后台管理系统</h2>
</div>
<div style="float: right" >
    <shiro:notAuthenticated>
        <a href="login.jsp" id="lo1">请登录</a>
    </shiro:notAuthenticated>
    <shiro:authenticated>
        <a href="${pageContext.request.contextPath}/logout">退出</a>
    </shiro:authenticated>

</div>

<div>
      <a href="${pageContext.request.contextPath}/add"><button>添加商品</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="${pageContext.request.contextPath}/goodslistall"><button>查询所有商品</button></a>


</div>

</body>
</html>
