<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2019/10/26
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/insertgoods" method="post" enctype="multipart/form-data">
  商品名称：<input type="text" name="name" placeholder="请输入商品名称"/></br>
  商品价格：<input type="text" name="price"/>
  商品类型：<select name="typeId">
               <option value="1">新鲜水果</option>
               <option value="2">海鲜水产</option>
               <option value="3">猪牛羊肉</option>
               <option value="4">禽类蛋品</option>
               <option value="5">新鲜蔬菜</option>
               <option value="6">速冻食品</option>
            </select></br>
  商品详情：<input type="text" name="detail" style="width: 350px;  height: 30px ;"/></br>
  上传图片：<input type="file" name="source"/></br>
  <input type="submit" value="确认添加"/></br>
  </form>

</body>
</html>
