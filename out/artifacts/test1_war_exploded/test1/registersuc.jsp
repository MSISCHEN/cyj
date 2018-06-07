<%--
注册成功的跳转页面
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/24
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script language="JavaScript">
        var times=6;
        clock();
        function clock(){
            window.setTimeout('clock()',1000);
            times=times-1;
            time.innerHTML=times;
        }
    </script>
    <meta http-equiv="refresh" content="5,url=login.jsp">
    <title>注册成功</title>
</head>
<body bgcolor="#f0e68c">

<center>
<h2>注册成功，请先登录</h2>
<table>
    <tr>
        <td >将在</td>
        <td ><div class="STYLE1"id="time">5</div></td>
        <td >秒后自动跳转到登录页面</td>
    </tr>
    <tr>
        <td>如果没有跳转，</td>
        <td>请按<a href="login.jsp">这里</a></td>
    </tr>
</table>
</center>
</body>
</html>
<%@include file="background.html"%>