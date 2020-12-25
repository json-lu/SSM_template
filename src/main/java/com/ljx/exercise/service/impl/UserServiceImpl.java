package com.ljx.exercise.service.impl;
import com.ljx.exercise.dao.user.IUserDao;
import com.ljx.exercise.dao.user.impl.UserDaoImpl;
import com.ljx.exercise.pojo.User;
import com.ljx.exercise.service.IUserService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 9:49 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
public class UserServiceImpl implements IUserService {

    //创建一个数据层访问对象 （此处有较大的耦合性，UserServiceImpl类依赖于dao层）
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public boolean addUser(String sql,User user) throws IllegalAccessException {
        List<Object> params = new ArrayList<>();
        Field[] declaredFields = user.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object o = declaredField.get(user);
            if (o == null){
                continue;
            }
            params.add(o);
        }
        int insert = userDao.insert(sql,params.toArray());
        if (insert>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        int update = userDao.update(user);
        if (update>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public List<User> query(User user) {
        return null;
    }
}
