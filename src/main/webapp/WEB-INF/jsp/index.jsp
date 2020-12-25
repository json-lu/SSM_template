<%--
  Created by IntelliJ IDEA.
  User: amain
  Date: 2020/12/21
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    welcome springmvc！！！！！
    <form action="/upload/api/upload" enctype="multipart/form-data" method="post">
        <input name="username" value="张三" >
        <input type="file" name="file" multiple="multiple">
        <input type="submit" value="提交">
    </form>
</body>
</html>
