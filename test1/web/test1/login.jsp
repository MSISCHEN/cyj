<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
登录页面
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/18
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript">


        function checkname() {
            var name = document.getElementById("name");
            var namewarn = document.getElementById("namewarn");
            if (name.value == "") {
                namewarn.innerHTML = "用户名不能为空";
                return false;
            } else {
                namewarn.innerHTML = "";
                return true;
            }
        }
        function checkpwd() {
            pwd = document.getElementById("pwd");
            pwdwarn = document.getElementById("pwdwarn");
            if (pwd.value == "") {
                pwdwarn.innerHTML = "密码不能为空";
                return false;
            } else {
                pwdwarn.innerHTML = "";
                return true;
            }
        }
        function check() {
            if (!checkname()) {
                alert("请输入用户名");
                return false;
            } else if (!checkpwd()) {
                alert("请输入密码");
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>

<body bgcolor="#f0f8ff">
<center>
    <form action="loginServlet" method="post" onsubmit="return check();">
        <table align="center" width="25%">
            <span style="color: #d6090e;"> <c:if test="${modifymess!=null}">${modifymess}</c:if></span>

            <h2>用户登录</h2>
            <tr>
                <td width="25%" align="right">用户名：</td>
                <td><input type="text" name="name" id="name" size="20" onblur="checkname()" placeholder="请输入用户名"/>
                    <font size="2"><span id="namewarn" style="color: #d6090e;"></span></font></td>
            </tr>
            <tr>
                <td width="25%" align="right">密码：</td>
                <td><input type="password" name="pwd" id="pwd" size="20" onblur="checkpwd()" placeholder="请输入密码"/>
                    <font size="2"><span id="pwdwarn" style="color: #d6090e;"></span></font></td>
            </tr>
            <tr>
                <td colspan="2">
                    <center><input type="submit" name="submit" value="登录"/>
                        &nbsp;&nbsp;
                        <input type="reset" name="reset" id="reset" value="重置"/></center>
                </td>
            </tr>
            <span style="color: #d6090e;"><c:if test="${loginmess!=null}">${loginmess}</c:if></span>
        </table>
    </form>
    如果您还没有注册，请单击<a href="register.jsp">这里</a>注册！
</center>
</body>
</html>
<%@include file="background.html" %>
