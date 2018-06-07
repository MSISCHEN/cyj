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

import static java.lang.System.out;

/**
 * 这个servlet有两个用处
 * 第一个是：在注册的时候检测,如果用户名不重复，则可以注册成功；
 *          否则，跳回注册页面，并提示用户名已存在，请重新注册
 * 第二个是：在修改密码时候的检测，若跳转到这个页面有带参数id,
 *          则将在页面获取的值进行更新，更新后跳回登录页面
 *          并且提示用户修改信息成功，请重新登录的提示。
 * Created by Administrator on 2017/12/24.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String[] enjoy = request.getParameterValues("enjoy");
        String city = request.getParameter("city");

        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User u = null;
        if (request.getParameter("id")==null) {
            u = userDao.findUser(name, pwd);
            if (!userDao.findName(name)) {
                if (u != null) {
                    response.sendRedirect("exist.jsp");

                } else {

                    u = new User();
                    u.setUser(name);
                    u.setPwd(pwd);
                    u.setSex(sex);
                    u.setMail(mail);
                    u.setPhone(phone);
                    StringBuffer strb = new StringBuffer();
                    for (int i = 0; i < enjoy.length; i++) {
                        strb.append(enjoy[i]).append(",");

                    }
                    u.setHobby(strb.substring(0, strb.length() - 1));
                    u.setCity(city);
                    userDao.addUser(u);
                    response.sendRedirect("registersuc.jsp");
                }
            } else {
                request.setAttribute("exitmess", "用户名已存在，请重新注册");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }
        } else {
            int id =Integer.parseInt(request.getParameter("id"));

            u = userDao.getUser(id);
            u.setId(id);
            u.setUser(name);
            u.setPwd(pwd);
            u.setSex(sex);
            u.setMail(mail);
            u.setPhone(phone);

            StringBuffer strb = new StringBuffer();
            for (int i = 0; i < enjoy.length; i++) {
                strb.append(enjoy[i]).append(",");

            }
            u.setHobby(strb.substring(0, strb.length() - 1));
            u.setCity(city);

            userDao.update(u);

            request.setAttribute("modifymess", "信息修改成功，请重新登录");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
