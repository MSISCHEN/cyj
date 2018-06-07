package servlet;


import dao.DaoException;
import dao.DaoFactory;
import dao.UserDao;
import domain.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DisPage.PageDao;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个页面的作用有两个：
 * 第一：当在infomation.jsp页面内点击‘进入查看’时，则跳转到这个servlet中，这个servlet进行分页，并跳转到show.jsp页面进行显示
 *
 * 第二：在show.jsp中有个功能是‘查询’，在文本框中输入查询的姓名进行模糊查询，也是将查询的值传入这个servlet中进行查询。
 *      若直接按查询，则显示全部的用户。
 * Created by Administrator on 2017/12/25.
 */

/**
 * personList由PageDao的show方法获得：返回一个Person类型的List，在jsp上foreach即可。
 * currentPage由页面参数和隐藏域获得：主要操作页面之间的跳转，在地址中?方式传值。action中使用隐藏域，初始值通过getParameter方式获得。
 * totalPages由pageDao的getPages方法获得：判断尾页，则下一页超链接不显示。
 */
@WebServlet(name = "TextServlet")
public class TextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String strPage = request.getParameter("currentPage");
        String search = request.getParameter("search");

        UserDao userDao = DaoFactory.getInstance().getUserDao();
        int currentPage = 0;
        List<User> users = null;

        if (strPage == null || strPage == "") {
            currentPage = 1;
        } else {
            try {
                currentPage = Integer.parseInt(strPage);
            } catch (NumberFormatException e) {
                throw new DaoException(e.getMessage(), e);
            }
            if (currentPage < 1) {
                currentPage = 1;
            } else if (currentPage > userDao.getPages()) {
                currentPage = userDao.getPages();
            }
        }
        users = userDao.read(currentPage);

        if (search != null) {
            search = "%" + search + "%";
            users = userDao.search(search);

        }
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            String[] hobbyNum = u.getHobby().split(",");
            StringBuffer hobby = new StringBuffer();
            for (int y = 0; y < hobbyNum.length; y++)
                if (hobbyNum[y].equals("1"))
                    hobby.append("游泳").append(" ");
                else if (hobbyNum[y].equals("2"))
                    hobby.append("读书").append(" ");
                else if (hobbyNum[y].equals("3"))
                    hobby.append("电子竞技").append(" ");
                else
                    hobby.append("其他");
            u.setHobby(hobby.toString());
        }
        request.setAttribute("users", users);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", userDao.getPages());

        request.getRequestDispatcher("show.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
