package dao;
import domain.User;

import java.util.List;

/**user对象的数据访问
 * dao是数据访问层对象
 * Created by Administrator on 2017/12/22.
 */
public interface UserDao {
    public void addUser(User user);

    public User getUser(int userId);

    public User findUser(String name, String pwd);

    public boolean findName(String name);

    public  void update(User user);

    public void delete(User user);

    public List<User> read(int currentPage);



    public  int getPages();
    public List<User> search(String name);
}
