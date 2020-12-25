package com.ljx.exercise.dao.user.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ljx.exercise.common.dao.basedao.IBaseDao;
import com.ljx.exercise.common.dao.basedao.impl.BaseDaoImpl;
import com.ljx.exercise.dao.user.IUserDao;
import com.ljx.exercise.helper.JDBCUtils;
import com.ljx.exercise.pojo.User;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 13:40 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

    @Override
    public int insert(String sql,Object ...params) {
        boolean b = saveOrUpdate(sql,params);
        if (b){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int update(User user) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConection();
            String sql = "update user set mobile=? where id=?";
            pst = conn.prepareStatement(sql);
            System.out.println(sql);
            pst.setString(1, user.getMobile());
            pst.setInt(2, user.getId());
            int i = pst.executeUpdate();
            System.out.println(sql);
            return i;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            JDBCUtils.close(conn, pst, null, null);
        }
    }

    @Override
    public int delete(Integer userId) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConection();
            String sql = "delete from user where id=?";
            pst = conn.prepareStatement(sql);
            System.out.println(sql);
            pst.setObject(1, userId);
            int i = pst.executeUpdate();
            System.out.println(sql);
            return i;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            JDBCUtils.close(conn, pst, null, null);
        }
    }

    @Override
    public List<User> queryAll() {
        String sql = "select * from user where username=?";
        String params = "张三";
        List<User> list = select(User.class, sql, params);
        for (User u:list){
            System.out.println(u);
        }
        return list;
    }
}
