package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/12/22.
 */
public class CRUD {
    public static  void main(String []args) throws SQLException{
//        create();
        read(2);
    }
    static void delete(int id)throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con= JdbcUtil.getConnection();
            String sql="DELETE userao  WHERE id=?";
            ps=con.prepareStatement(sql);

            ps.setObject(1,id);
            int num=ps.executeUpdate();
            System.out.print(num);
        }finally {
            JdbcUtil.free(rs,ps,con);
        }

    }
    static void update(int id,String repwd)throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con= JdbcUtil.getConnection();
            String sql="UPDATE userao SET pwd=? WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1,"666666");
            ps.setObject(2,id);
            int num=ps.executeUpdate();
            System.out.print(num);
        }finally {
            JdbcUtil.free(rs,ps,con);
        }

    }
    static void create()throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con= JdbcUtil.getConnection();
            String sql="INSERT INTO userao(user,pwd,sex,mail,phone,hobby,city) VALUES (?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setObject(1,"赖红");
            ps.setObject(2,"123456");
            ps.setObject(3,"女");
            ps.setObject(4,"505263945@qq.com");
            ps.setObject(5,"15767702027");
            ps.setObject(6,"其他");
            ps.setObject(7,"佛山");
            int num=ps.executeUpdate();
            System.out.print(num);
        }finally {
            JdbcUtil.free(rs,ps,con);
        }

    }
    static void read(int id) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
         con= JdbcUtil.getConnection();
         String sql="SELECT user,pwd,sex,mail,phone,hobby,city FROM userao WHERE id=?";
         ps=con.prepareStatement(sql);
         ps.setObject(1,id);
         rs=ps.executeQuery();
         while(rs.next()){
             System.out.print(rs.getObject("user")+"\t"
                     +rs.getObject("pwd")+"\t"
                     +rs.getObject("sex")+"\t"
                     +rs.getObject("mail")+"\t"
                     +rs.getObject("phone")+"\t"
                     +rs.getObject("hobby")+"\t"
                     +rs.getObject("city"));

         }
        }finally {
            JdbcUtil.free(rs,ps,con);
        }
    }

}
