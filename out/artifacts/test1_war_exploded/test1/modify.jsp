<%@ page import="domain.User" %><%--
修改的输入信息页面
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/28
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/js/checkRegister.js" type="text/javascript"></script>

<html>
<head>
    <script>
        function c1() {
            namewarn = document.getElementById("namewarn");
            namewarn.innerHTML = "用户名不允许修改";
        }
        function c2() {
            namewarn = document.getElementById("namewarn");
            namewarn.innerHTML = "";
        }
    </script>
    <title>修改</title>
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

<form action="RegisterServlet?id=${u.id}" method="post" onsubmit="return check();">
    <h2 class="color" align="center">修改信息</h2>
    <table align="center">

        <tr>
            <td colspan="2" style="color: #d6090e;">
                <c:if test="${modifymess!=null}">${mess}</c:if>
            </td>

        </tr>
        <tr>
            <td class="color" align="right">用户名：</td>
            <td><input type="text" size="20" name="name" id="name" value="${u.user}" onblur="c2()" onfocus="c1()"
                       readonly/>
                <font size="2"><span id="namewarn" style="color: #d6090e;"></span></font></td>
        </tr>
        <tr>
            <td class="color" align="right">密码：</td>
            <td><input type="text" size="20" name="pwd" id="pwd" placeholder="请输入密码" value="${u.pwd}"
                       onblur="checkPwd()"/>
                <font size="2"><span id="pwdwarn" style="color: #d6090e;"></span></font></td>
        </tr>
        <tr>
            <td class="color" align="right">确认密码：</td>
            <td><input type="text" size="20" name="repwd" id="repwd" placeholder="请再次输入名称" value="${u.pwd}"
                       onblur="checkrePwd()"/>
                <font size="2"> <span id="repwdwarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right">性别：</td>
            <td><input type="radio" value="男" name="sex" <c:if test="${u.sex=='男'}">checked="checked"</c:if>><font
                    class="color">男</font>
                <input type="radio" value="女" name="sex" class="color"
                       <c:if test="${u.sex=='女'}">checked="checked"</c:if>><font class="color">女</font></td>
        </tr>
        <tr>
            <td class="color" align="right">邮箱：</td>
            <td><input type="text" size="20" name="mail" id="mail" placeholder="请输入邮箱" value="${u.mail}"
                       onblur="checkmail()"/>
                <font size="2"><span id="mailwarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right"> 手机号码：</td>
            <td><input type="text" size="20" name="phone" id="phone" value="${u.phone}" placeholder="请输入手机号码"
                       onblur="checkphone()"/>
                <font size="2"><span id="phonewarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td class="color" align="right"> 爱好：</td>
            <td><input type="checkbox" name="enjoy" value="1" <c:if
                    test="${u.hobby.contains('1')}"> checked="checked" </c:if>/><font class="color">游泳</font>
                <input type="checkbox" name="enjoy" value="2" <c:if
                        test="${u.hobby.contains('2')}"> checked="checked" </c:if>/><font class="color">看书</font>
                <input type="checkbox" name="enjoy" value="3" <c:if
                        test="${u.hobby.contains('3')}"> checked="checked" </c:if>/><font class="color">电子竞技</font>
                <input type="checkbox" name="enjoy" value="4" <c:if
                        test="${u.hobby.contains('4')}"> checked="checked" </c:if>/><font class="color">其他</font></td>
        </tr>
        <tr>

            <td class="color" align="right"> 所在城市：</td>
            <td><select name="city" id="local" size="1">
                <option <c:if test="${u.city=='北京'}"> selected="selected" </c:if>>北京</option>
                <option <c:if test="${u.city=='上海'}"> selected="selected" </c:if>>上海</option>
                <option <c:if test="${u.city=='天津'}"> selected="selected" </c:if>>天津</option>
                <option <c:if test="${u.city=='广州'}"> selected="selected" </c:if>>广州</option>
                <option <c:if test="${u.city=='佛山'}"> selected="selected" </c:if>>佛山</option>
                <option <c:if test="${u.city=='梅州'}"> selected="selected" </c:if>>梅州</option>
                <option <c:if test="${u.city=='其他'}"> selected="selected" </c:if>>其他</option>
            </select></td>
        </tr>

        <tr>
            <td colspan="2">
                <center><input type="submit" value="修改">
                    &nbsp;&nbsp;
                    <input type="reset" value="重置"></center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<%@include file="background.html" %>



