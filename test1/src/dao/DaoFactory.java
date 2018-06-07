package dao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/12/22.
 */
public class DaoFactory {
    private static UserDao userDao = null;
    private static DaoFactory instance = new DaoFactory();

    private DaoFactory() {
        //从properties文件中读取key对应的值，通过这个文件来获取类
        try {
            Properties prop = new Properties();

//            InputStream inputStream = new FileInputStream(new File("src/resources/daoconfig.properties"));
            InputStream inputStream= DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
            prop.load(inputStream);
            String userDaoClass = prop.getProperty("userDaoClass");

            Class clazz = Class.forName(userDaoClass);
            userDao = (UserDao) clazz.newInstance();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DaoFactory getInstance() {

        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
