package dao;

/**
 * Created by Administrator on 2017/12/22.
 */
public class UserDaoTest {
    public static void main(String []args){
        //UserDao userDao=new UserDaoJdbcImpl();
        //用下列语句，可以确定与UserDaoJdbcImpl接口无关
        UserDao userDao=DaoFactory.getInstance().getUserDao();
//        User user=new User();
//        user.setUser("阿曼");
//        user.setPwd("123456");
//        user.setSex("女");
//        user.setMail("chenrouman@qq.com");
//        user.setPhone("13431843349");
//        user.setHobby("其他");
//        user.setCity("佛山");

//        userDao.addUser(user);
//        User u=userDao.findUser("阿曼","123456");

//        User u=userDao.getUser(2);
//
//        System.out.print(u.getId()+"----");
//        u.setCity("梅州");
//        userDao.update(u);
//        userDao.delete(u);
        System.out.print("----");
    }
}
