<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/26
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Title</title>
    <script type="text/javascript">
        function jump() {
            page = document.getElementById("page").value;
            if (page < 0 || page >${totalPages} || page == "") {
                return;
            } else
                location.href = "/test1/TextServlet?currentPage=" + page;
        }
        function searchName() {
            search = document.getElementById("search").value;
            if (search == null)
                location.href = "/test1/TextServlet?currentPage=1";
            else
                location.href = "/test1/TextServlet?search=" + search;
        }
    </script>
</head>
<body bgcolor="#f0f8ff">

<div align="center"><input type="text" border-radius=6px name="search" id="search">
    <button onclick="searchName()">查询</button>
</div>
<table width="80%" border="1" align="center">
    <tr>
        <th>
            编号
        </th>
        <th>
            用户名
        </th>
        <th>
            密码
        </th>
        <th>
            性别
        </th>
        <th>
            爱好
        </th>
        <th>
            邮箱
        </th>
        <th>
            手机号码
        </th>
        <th>
            城市
        </th>
    </tr>

    <c:forEach var="row" items="${users}">
        <tr>
            <td><c:out value="${row.id}"></c:out></td>
            <td><c:out value="${row.user}"></c:out></td>
            <td><c:out value="${row.pwd}"></c:out></td>
            <td><c:out value="${row.sex}"></c:out></td>

            <td><c:out value="${row.hobby}"></c:out></td>
            <td><c:out value="${row.mail}"></c:out></td>
            <td><c:out value="${row.phone}"></c:out></td>
            <td><c:out value="${row.city}"></c:out></td>
        </tr>
    </c:forEach>
</table>

<br/><br/>
<div align="center">

    <a href="/test1/TextServlet?currentPage=1">
        首页
    </a>

    <a href="/test1/TextServlet?currentPage=${currentPage-1}">
        上一页
    </a>
    第${currentPage}页/共${totalPages}页
    <a href="/test1/TextServlet?currentPage=${currentPage+1}">
        下一页
    </a>

    <a href="/test1/TextServlet?currentPage=${totalPages}">
        尾页
    </a>
    到第<input id="page" style="width: 20px" type="text">页<input id="go" value="go" onclick="jump()" type="button">
</div>
</body>
</html>
<%@include file="background.html" %>