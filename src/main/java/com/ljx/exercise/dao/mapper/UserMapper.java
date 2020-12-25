package com.ljx.exercise.dao.mapper;

import com.ljx.exercise.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 15:30 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
public interface UserMapper {
    List<User> selectAll();
    void save(Map map);
}
