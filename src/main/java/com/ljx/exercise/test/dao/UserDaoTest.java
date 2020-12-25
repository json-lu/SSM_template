package com.ljx.exercise.test.dao;

import com.ljx.exercise.dao.user.IUserDao;
import com.ljx.exercise.dao.user.impl.UserDaoImpl;
import com.ljx.exercise.pojo.User;
import com.ljx.exercise.service.IUserService;
import com.ljx.exercise.service.impl.UserServiceImpl;
import org.junit.Test;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 15:59 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public class UserDaoTest {

    @Test
    public void insert() {
        IUserDao userDao = new UserDaoImpl();
        String sql = "insert into user(username,password,mobile) values(?,?,?)";
        int insert = userDao.insert(sql, new String[]{"llk", "12345", "13698982328"});
        System.out.println(insert);

    }

    @Test
    public void insert1() throws IllegalAccessException {
        IUserService userService = new UserServiceImpl();
        String sql = "insert into user(username,password,mobile) values(?,?,?)";
        User user = new User();
        user.setUsername("jack");
        user.setPassword("12390537");
        user.setMobile("17689890032");
        boolean b = userService.addUser(sql, user);
        if (b){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(2);
        user.setMobile("122332255");
        IUserDao userDao = new UserDaoImpl();
        int update = userDao.update(user);
        System.out.println(update);
    }

    @Test
    public void delete() {
        IUserDao userDao = new UserDaoImpl();
        int delete = userDao.delete(2);
        System.out.println(delete);
    }

    @Test
    public void query() {
        IUserDao userDao = new UserDaoImpl();
        List<User> list = userDao.queryAll();
        for (User u : list) {
            System.out.println(u);
        }
    }


}
