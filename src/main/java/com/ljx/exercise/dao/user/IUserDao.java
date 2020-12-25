package com.ljx.exercise.dao.user;

import com.ljx.exercise.pojo.User;

import java.util.List;

/**
 * <p>
 *  访问用户数据层接口
 *      定义数据层接口调用
 * </p>
 *
 * @Since: Created  in 13:10 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public interface IUserDao {

    //添加
    int insert(String sql,Object ...params);

    //更新
    int update(User user);

    //删除
    int delete(Integer userId);

    //查询全部
    List<User> queryAll();


}
