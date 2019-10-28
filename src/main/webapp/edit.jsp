<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2019/10/26
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>编辑商品信息</title>
    <script src="js/jquery-1.12.4.min.js"></script>
</head>
<body>
<form  method="post" enctype="multipart/form-data">
    商品id:<input type="text" name="id" value="${goods.id}" readonly="readonly"/></br>
    商品名称：<input type="text" name="name" value="${goods.name}"/></br>
    商品价格：<input type="text" name="price" value="${goods.price}"/>
    商品类型：<select name="typeId" >
    <option value="1">新鲜水果</option>
    <option value="2">海鲜水产</option>
    <option value="3">猪牛羊肉</option>
    <option value="4">禽类蛋品</option>
    <option value="5">新鲜蔬菜</option>
    <option value="6">速冻食品</option>
</select></br>
    商品详情：<input type="text" name="detail" value="${goods.detail}" style="width: 350px;  height: 30px ;"/></br>
    上传图片：<input type="file" name="source"/></br>
    <input type="button" value="修改" onclick="update()"/></br>
</form>
<img id="img">
<script type="text/javascript">

    function update(){


        xhr = new XMLHttpRequest();
        xhr.open("post","${pageContext.request.contextPath}/updateGoods");

        xhr.onreadystatechange=function(){
            if(xhr.readyState==4){
                ret = xhr.responseText //接受响应内容：图片在服务器的存储位置(访问路径)
                console.log(ret)
                if (ret!=null){
                    alert("修改成功~")
                }
                //回显上传的图片
                document.getElementById("img").src="upload/"+ret;
            }
        }
        //FomrData(form的dom对象)
        xhr.send(new FormData(document.forms[0])) //发送请求，携带form的所有数据

    }

</script>





</body>
</html>
