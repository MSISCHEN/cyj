package jdbc;

import java.sql.*;


/**
 * Created by Administrator on 2017/12/22.
 */
public class JdbcUtil {
  
    private static String url="jdbc:mysql://localhost:3306/jsp1";
    private static String  user="root";
    private static String password="666666";
    private JdbcUtil(){}
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new ExceptionInInitializerError(e);
        }

    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);

    }
    public static void free(ResultSet rs, Statement st,Connection con){
        try {
            if (rs!=null) {
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(st!=null){
                    st.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    if (con!=null){
                        con.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
