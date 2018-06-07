<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
用来输入用户信息的表单
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="/js/checkRegister.js" type="text/javascript"></script>

<html>
<head>
    <title>注册</title>
    <style>
        <!--
        local {
            align: right;
        }

        -->
        .color {
            color: aliceblue
        }

        #biaoge {
            margin: 6px;
            padding: 2px;
            text-align: center;
        }

        #biaoge table {
            margin: 0px auto;
        }

    </style>
</head>
<body bgcolor="black">


<form action="RegisterServlet" method="post" onsubmit="return check();">
    <h2 class="color" align="center">用户注册</h2>
    <table align="center">
        <tr><td colspan="2" style="color: #d6090e;">
        <span name="warn"><c:if test="${exitmess!=null}">${exitmess}</c:if></span>
        </td> </tr>
        <tr>
            <td class="color" align="right">用户名：</td>
            <td><input type="text" size="20" name="name" id="name" placeholder="请输入用户名" onblur="checkName()"/>
                <font size="2"><span id="namewarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right">密码：</td>
            <td><input type="password" size="20" name="pwd" id="pwd" placeholder="请输入密码" onblur="checkPwd()"/>
                <font size="2"><span id="pwdwarn" style="color: #d6090e;"></span></font></td>
        </tr>
        <tr>
            <td class="color" align="right">确认密码：</td>
            <td><input type="password" size="20" name="repwd" id="repwd" placeholder="请再次输入名称" onblur="checkrePwd()"/>
                <font size="2"> <span id="repwdwarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right">性别：</td>
            <td><input type="radio" value="男" name="sex" checked="checked"><font class="color">男</font>
                <input type="radio" value="女" name="sex" class="color"><font class="color">女</font></td>
        </tr>
        <tr>
            <td class="color" align="right">邮箱：</td>
            <td><input type="text" size="20" name="mail" id="mail" placeholder="请输入邮箱" onblur="checkmail()"/>
                <font size="2"><span id="mailwarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right"> 手机号码：</td>
            <td><input type="text" size="20" name="phone" id="phone" placeholder="请输入手机号码" onblur="checkphone()"/>
                <font size="2"><span id="phonewarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right"> 爱好：</td>
            <td><input type="checkbox" name="enjoy" class="color" value="1"/><font class="color">游泳</font>
                <input type="checkbox" name="enjoy" value="2"/><font class="color">看书</font>
                <input type="checkbox" name="enjoy" value="3"/><font class="color">电子竞技</font>
                <input type="checkbox" name="enjoy" value="4" checked="checked"/><font class="color">其他</font></td>
        </tr>
        <tr>
            <td class="color" align="right"> 所在城市：</td>
            <td><select name="city" id="local" size="1">
                <option>北京</option>
                <option>上海</option>
                <option>天津</option>
                <option>广州</option>
                <option>佛山</option>
                <option>梅州</option>
                <option selected="selected">其他</option>
            </select></td>
        </tr>
        <tr></tr>
        <tr>
            <td colspan="2">
                <center><input type="submit" value="注册">
                    &nbsp;&nbsp;
                    <input type="reset" value="重置"></center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<%@include file="background.html" %>
