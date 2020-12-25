package com.ljx.exercise.test.dao.mapper;

import com.ljx.exercise.dao.mapper.UserMapper;
import com.ljx.exercise.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.env.Environment;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 15:33 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
public class UserMapperTest {

    public static SqlSession getSqlSessionFactory() {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             BufferedInputStream bof = new BufferedInputStream(is);) {
            //2创建sqlSessionFactoryBuilder对象用于构建工厂对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获得工厂对象
            SqlSessionFactory factory = builder.build(bof);
            //使用工厂生成sqlSession对象
            return factory.openSession();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Test
    public void select() {
        //使用工厂生成sqlSession对象
        SqlSession sqlSession = getSqlSessionFactory();
        //使用sqlSession创建dao接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //使用代理对象执行方法
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void insert() {
        //使用工厂生成sqlSession对象
        SqlSession sqlSession = getSqlSessionFactory();
        // 使用sqlSession对象生成dao接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "李四");
        map.put("password", "123456");
        map.put("mobile", "13301989999");
        mapper.save(map);
        sqlSession.commit();//需要手动提交
    }
}
