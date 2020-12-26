package com.ljx.exercise.pojo;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *  用户实体类
 * </p>
 *
 * @Since: Created  in 11:11 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public class User implements Serializable {
    //加入序列版本号，防止类发生变化，反序列化找不到对应的版本号，反序列化失败!!!
    private static final long serialVersionUID = 101l; //该版本号的目的在于验证序列化的对象和对应类是否版本匹配。 固定字段serialVersionUID
    private Integer id;//用户id
    private String username;//用户名
    private String password;//密码
    private String mobile;//联系方式
    private String records_status;//用户状态
    private Date create_time;//创建时间
    private Date last_login_time;//最后登录时间
    //private String ceshi;//测试



    public User() {

    }

    public User(String username, String password, String mobile) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public User(Integer id, String username, String password, String mobile, String records_status, Date create_time, Date last_login_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.records_status = records_status;
        this.create_time = create_time;
        this.last_login_time = last_login_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRecords_status() {
        return records_status;
    }

    public void setRecords_status(String records_status) {
        this.records_status = records_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", records_status='" + records_status + '\'' +
                ", create_time=" + create_time +
                ", last_login_time=" + last_login_time +
                '}';
    }

    /*    public static void main(String[] args) throws IllegalAccessException {
            User u = new User();
            u.setUsername("tom");
        Field[] declaredFields = u.getClass().getDeclaredFields();
        for (Field field:declaredFields){
            System.out.println(field.getName());
            Object o = field.get(u);
            System.out.println(o);
        }
    }*/
}
