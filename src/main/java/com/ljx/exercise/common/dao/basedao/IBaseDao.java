package com.ljx.exercise.common.dao.basedao;

import com.ljx.exercise.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *      公共数据访问层接口
 * </p>
 *
 * @Since: Created  in 13:42 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public interface IBaseDao<T> {

    //增删改
     boolean saveOrUpdate(String sql,Object ...params);

     //查询
    List<T> select(Class<T> classes,String sql,Object ...params);






}
