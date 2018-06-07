package domain;

/**业务逻辑层
 * domain对象的类
 * Created by Administrator on 2017/12/22.
 */
public class User {


    private  int id;
    private String user;
    private String pwd;
    private String sex;
    private String mail;
    private String phone;
    private String hobby;
    private String city;

    public void setId(int id) {
        this.id = id;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {

        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getHobby() {
        return hobby;
    }

    public String getCity() {
        return city;
    }
}
