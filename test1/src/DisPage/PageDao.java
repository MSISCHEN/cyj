package DisPage;

import dao.DaoException;

import domain.User;
import jdbc.JdbcUtil;

import java.sql.*;
import java.util.*;

/**
 * Created by Administrator on 2017/12/25.
 */
public class PageDao {
        //每页记录数
        private int pageSize=5;
        //getter setter
        public int getPageSize() {
                return pageSize;
        }
        public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
        }
        /**
         * SQL语句计算查询的总记录数
         * @return 查询User的总页数
         */
        public int getPages(){
                //总页面数
                int totalPages=0;
                Connection con=null;
                Statement st=null;
                ResultSet rs=null;
                try {
                        con= JdbcUtil.getConnection();
                        st=con.createStatement();
                        rs=st.executeQuery("SELECT COUNT (id) FROM userao");
                       if(rs.next()) {
                               int totalRecords=rs.getInt(1);//总记录数totalRecords
                               totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
                       }
                }catch (SQLException e){
                        throw new DaoException(e.getMessage(),e);
                }
                finally {
                        JdbcUtil.free(rs,st,con);
                }
                return totalPages;
        }
        /**
         * @return 返回当前页查询结果的List
         */
        public List<User> show(int currentPage){
                Connection con=null;
                Statement st=null;
                ResultSet rs=null;
                List<User> users=null;
                try {
                        con = JdbcUtil.getConnection();
                        st = con.createStatement();
                        User user=null;
                        int beginRecord=(currentPage-1)*pageSize;//开始记录
                        int endRecord=pageSize; //从开始到结束的记录数
                        String sql="SELECT id,name,pwd,sex,hobby,mail,phone,city FROM userao limit"+beginRecord+","+endRecord;
                        users=new ArrayList<User>();
                        rs=st.executeQuery(sql);
                        while(rs.next()){
                                user=new User();
                                user.setUser(rs.getString("name"));
                                user.setPwd(rs.getString("pwd"));
                                user.setHobby(rs.getString("hobby"));
                                user.setSex(rs.getString("sex"));
                                user.setMail(rs.getString("mail"));
                                user.setPhone(rs.getString("phone"));
                                user.setId(rs.getInt("id"));
                                user.setCity(rs.getString("city"));
                                users.add(user);

                        }
                }catch (SQLException e){
                        throw new DaoException(e.getMessage(),e);
                }finally {
                        JdbcUtil.free(rs,st,con);
                }
                return users;
        }
}


