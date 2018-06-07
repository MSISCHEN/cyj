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

/**当在信息页面点击修改信息时，传入一个参数id，来获取id的信息，
 * 在modify.jsp页面显示原有的信息
 * 在注销的也传递一个id过来，并实现从数据库中删掉这个用户信息
 * Created by Administrator on 2017/12/28.
 */
@WebServlet(name = "ModifyServlet")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        UserDao userDao = DaoFactory.getInstance().getUserDao();


        if(request.getParameter("id")!=null) {
            int id = Integer.parseInt(request.getParameter("id")) ;
            User user = userDao.getUser(id);
            request.setAttribute("u", user);
            RequestDispatcher rd = request.getRequestDispatcher("modify.jsp");
            rd.forward(request, response);
        }
        if(request.getParameter("delete")!=null){
            int id = Integer.parseInt(request.getParameter("delete")) ;
            User user = userDao.getUser(id);
            userDao.delete(user);
            System.out.print("--删除成功--");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
