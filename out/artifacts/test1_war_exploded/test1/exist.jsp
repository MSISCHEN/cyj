<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/23
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script language="JavaScript">
    var times=6;
    clock();
    function clock(){
        window.setTimeout('clock()',1000);
        times=times-1;
        time.innerHTML=times;
    }
</script>
<head>
    <meta http-equiv="refresh" content="5,url=login.jsp">
    <title>"用户已存在"</title>
   <style type="text/css">
      <!-- STYLE1{color:#FF0000}-->
   </style>

</head>
<body bgcolor="#f0e68c">
<center>
<h2>该用户已存在，请直接登录</h2>
<table>
    <tr>
        <td class="STYLE1">将在</td>
        <td class="STYLE1"><div class="STYLE1"id="time">5</div></td>
        <td class="STYLE1">秒后自动跳转到登录页面</td>
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