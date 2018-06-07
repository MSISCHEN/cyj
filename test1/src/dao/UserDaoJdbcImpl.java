package dao;

import domain.User;
import jdbc.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */
public class UserDaoJdbcImpl implements UserDao {


    @Override
    public void addUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getConnection();
            String sql = "INSERT INTO userao(name,pwd,sex,mail,phone,hobby,city) VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1, user.getUser());
            ps.setObject(2, user.getPwd());
            ps.setObject(3, user.getSex());
            ps.setObject(4, user.getMail());
            ps.setObject(5, user.getPhone());
            ps.setObject(6, user.getHobby());
            ps.setObject(7, user.getCity());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }

    }

    @Override
    public User getUser(int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = JdbcUtil.getConnection();
            String sql = "SELECT id,name,pwd,sex,mail,phone,hobby,city FROM userao WHERE id=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                mappingUser(rs, user);

            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
        return user;
    }

    private void mappingUser(ResultSet rs, User user) throws SQLException {
        user.setId(rs.getInt("id"));
        user.setUser(rs.getString("name"));
        user.setPwd(rs.getString("pwd"));
        user.setSex(rs.getString("sex"));
        user.setMail(rs.getString("mail"));
        user.setPhone(rs.getString("phone"));
        user.setHobby(rs.getString("hobby"));
        user.setCity(rs.getString("city"));
    }

    @Override
    public User findUser(String name, String pwd) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = JdbcUtil.getConnection();
            String sql = "SELECT id,name,pwd,sex,mail,phone,hobby,city FROM userao WHERE name=? AND pwd=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, pwd);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUser(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setMail(rs.getString("mail"));
                user.setPhone(rs.getString("phone"));
                user.setHobby(rs.getString("hobby"));
                user.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
        return user;
    }

    @Override
    public boolean findName(String name) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getConnection();
            String sql = "SELECT id FROM userao WHERE name=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
        return flag;
    }

    @Override
    public void update(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getConnection();
            String sql = "UPDATE userao SET name=?,pwd=?,sex=?,mail=?,phone=?,hobby=?,city=? WHERE id=?";
            ps = con.prepareStatement(sql);
            ps.setObject(8, user.getId());
            ps.setObject(1, user.getUser());
            ps.setObject(2, user.getPwd());
            ps.setObject(3, user.getSex());
            ps.setObject(4, user.getMail());
            ps.setObject(5, user.getPhone());
            ps.setObject(6, user.getHobby());
            ps.setObject(7, user.getCity());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }

    }

    @Override
    public void delete(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getConnection();
            String sql = "DELETE FROM userao  WHERE id=?";
            ps = con.prepareStatement(sql);

            ps.setObject(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
    }



    @Override
    public List<User> search(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();

        try {
            con = JdbcUtil.getConnection();
            String sql = "SELECT id,name,pwd,sex,mail,phone,hobby,city FROM userao where name LIKE ?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                mappingUser(rs, user);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
        return users;
    }


    @Override
    public int getPages() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int pageCount = 0;
        try {
            con = JdbcUtil.getConnection();
            String sql = "SELECT count(id) FROM userao";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int pageSize = 5;
            int total = 0;
            if (rs.next()) {
                total = rs.getInt(1);
                pageCount = (total + pageSize - 1) / pageSize;
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
        return pageCount;
    }

    @Override
    public List<User> read(int currentPage) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        int pageSize = 5;
        int begin = (currentPage - 1) * pageSize;
        try {
            con = JdbcUtil.getConnection();
            String sql = "SELECT id,name,pwd,sex,mail,phone,hobby,city FROM userao limit " + begin + "," + pageSize;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                mappingUser(rs, user);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtil.free(rs, ps, con);
        }
        return users;
    }

}
