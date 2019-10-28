<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2019/10/26
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>商品列表</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table class="table table-striped table-bordered">
    <tr align="center">
        <td>id</td>
        <td>名称</td>
        <td style="width: 230px; height: 50px">美图</td>
        <td>价格</td>
        <td>上架时间</td>
        <td style="width: 400px; height: 50px">详情</td>
        <td>操作</td>
    </tr>
    <c:forEach var="goods" items="${goodslist}">
    <tr align="center">
        <td>${goods.id}</td>
        <td>${goods.name}</td>
        <td><img src="${pageContext.request.contextPath}/${goods.imgpath}"></td>
        <td>$:${goods.price}</td>
        <td><fmt:formatDate value="${goods.creatTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
        <td>${goods.detail}</td>
        <td >

            <a href="${pageContext.request.contextPath}/editgoods?id=${goods.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">删除</a>

        </td>
    </tr>
    </c:forEach>

</table>

<script src="js/jquery-1.12.4.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>
