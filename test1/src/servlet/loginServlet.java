package servlet;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录时，把用户名跟密码传过来，看是否符合要求，
 * 若符合，则跳转到infomation.jsp页面显示用户信息
 * 若不符合，还是显示登录页面，并给出提示，用户名或密码错误
 * Created by Administrator on 2017/12/23.
 */
@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user=userDao.findUser(name, pwd);



        if (user!=null) {
            String[] hobbyNum = user.getHobby().split(",");
            StringBuffer hobby = new StringBuffer();
            for (int i = 0; i < hobbyNum.length; i++) {
                if (hobbyNum[i].equals("1"))
                    hobby.append("游泳").append(" ");
                else if (hobbyNum[i].equals("2"))
                    hobby.append("读书").append(" ");
                else if (hobbyNum[i].equals("3"))
                    hobby.append("电子竞技").append(" ");
                else
                    hobby.append("其他");

            }
            String ho=hobby.toString();
            request.setAttribute("u",user);
            request.setAttribute("ho",ho);
            request.getRequestDispatcher("infomation.jsp").forward(request,response);
        } else {
            request.setAttribute("loginmess", "帐户名或登录密码不正确，请重新输入");
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            if (rd!=null) {
                rd.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
