<%@ page import="domain.User" %><%--
登录成功后的显示页面
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/24
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body bgcolor="#f0f8ff">
<center>
    欢迎${u.user}用户
    <table>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td>${u.pwd}
            </td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td>${u.sex}
            </td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td>${u.mail}
            </td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td>${u.phone}
            </td>
        </tr>
        <tr>
            <td align="right">爱好：</td>
            <td>${ho}
            </td>
        </tr>
        <tr>
            <td align="right">所在城市：</td>
            <td>${u.city}
            </td>
        </tr>
        <tr><td>
            <a href="ModifyServlet?id=${u.id}">修改信息</a>
            <a href="TextServlet">进入查看系统</a></td></tr>

        <script language="javascript">

            function logout(){
                if (confirm("你确定要注销身份吗？是－选择确定，否-选择取消")){
                    window.location.href="ModifyServlet?delete=${u.id}"
                }
            }

        </script>
        <input type="button" onclick="logout()" value="注销"/>


    </table>
</center>
</body>
</html>
<%@include file="background.html" %>