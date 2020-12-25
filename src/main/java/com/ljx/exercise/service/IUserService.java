package com.ljx.exercise.service;

import com.ljx.exercise.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 *       业务层接口
 * </p>
 *
 * @Since: Created  in 9:48 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
public interface IUserService {

    //添加用户
    boolean addUser(String sql,User user) throws IllegalAccessException;

    //修改用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(User user);

    //查询用户
    List<User> query(User user);
}
