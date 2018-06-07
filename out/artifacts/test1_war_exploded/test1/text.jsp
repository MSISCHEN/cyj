<%@ page import="javax.naming.InitialContext" %>


<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="jdbc.JdbcUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.DaoException" %><%--
这个text页面是一开始弄分页功能的时候做的，这个是假分页，性能比较差
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv=Content-Type content="text/html" ;charaset="utf-8"/>
</head>
<body bgcolor="#f0f8ff">

<%
    request.setCharacterEncoding("utf-8");
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    int pageSize, rowCount, pageCount, curPage;
    pageSize = 5;
    pageCount = 1;

    String strPage = request.getParameter("page");
    if (strPage == null)
        curPage = 1;
    else {
        curPage = Integer.parseInt(strPage);//通过参数来定当前页面
        if (curPage < 1)
            curPage = 1;
    }
    try {
        InitialContext ctx = new InitialContext();
        con = JdbcUtil.getConnection();
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM userao");
        rs.last();
        rowCount = rs.getRow();

        pageCount = (rowCount + pageSize - 1) / pageSize;
        if (curPage > pageCount)
            curPage = pageCount;

    } catch (Exception e) {
        throw new DaoException();
    }

%>

<table width="80%">
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
    <%
        if (pageCount > 0)
            rs.absolute((curPage - 1) * pageSize + 1);
        int i = 0;
        while (i < pageSize && !rs.isAfterLast()) {
    %>
    <tr align="center">
        <td><%=rs.getObject(1)%>
        </td>
        <td><%=rs.getObject(2)%>
        </td>
        <td><%=rs.getObject(3)%>
        </td>
        <td><%=rs.getObject(4)%>
        </td>

        <%
            String[] hobbyNum = ((String) rs.getObject(5)).split(",");
            StringBuffer hobby = new StringBuffer();
            for (int x = 0; x < hobbyNum.length; x++)
                if (hobbyNum[x].equals("1"))
                    hobby.append("游泳").append(" ");
                else if (hobbyNum[x].equals("2"))
                    hobby.append("读书").append(" ");
                else if (hobbyNum[x].equals("3"))
                    hobby.append("电子竞技").append(" ");
                else
                    hobby.append("其他");

        %>

        <td>
            <%=hobby.toString()%>
        </td>

        <td><%=rs.getObject(6)%>
        </td>
        <td><%=rs.getObject(7)%>
        </td>
        <td><%=rs.getObject(8)%>
        </td>
    </tr>
    <%
            rs.next();
            i++;
        }
    %>
</table>
<%
    if (curPage > 1) {
%>
<a href="text.jsp?page=<%=curPage-1%>">上一页</a>
<% }
    if (curPage < pageCount) {
%>
<a href="text.jsp?page=<%=curPage+1%>">下一页</a>
<%
    }
%>
<center>
    <table width="100%">
        <tr>
            <td>
                页数：<%=curPage%>/<%=pageCount%>页
                <%=pageSize%>条/页
            </td>
        </tr>

    </table>
</center>
</body>

</html>
<%
    JdbcUtil.free(rs, st, con);
%>
<%@include file="background.html" %>