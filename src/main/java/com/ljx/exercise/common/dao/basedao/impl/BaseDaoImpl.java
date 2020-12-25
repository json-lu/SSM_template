package com.ljx.exercise.common.dao.basedao.impl;
import com.ljx.exercise.common.dao.basedao.IBaseDao;
import com.ljx.exercise.helper.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * <p>
 *      通用数据层访问实现
 * </p>
 *
 * @Since: Created  in 13:43 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {
    private static Connection conn = null;
    private static Statement st = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    /**
     *      ...等同于数组
     * @param sql sql语句
     * @param params 参数集合
     * @return
     */
    @Override
    public boolean saveOrUpdate(String sql, Object ...params) {
        try{
            conn = JDBCUtils.getConection();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject((i+1),params[i]);
            }
            int i = pst.executeUpdate();
            if (i>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }finally {
            JDBCUtils.close(conn,null,pst,null);
        }
    }

    @Override
    public List<T> select(Class<T> classes,String sql,Object ...params) {
        try {
            conn = JDBCUtils.getConection();
            pst = conn.prepareStatement(sql);
            if (params.length == 0){
                rs = pst.executeQuery();
            }else {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject((i+1),params[i]);
                }
                rs = pst.executeQuery();
            }
            //创建一个与数据并接收返回值
            ResultSetMetaData metaData = rs.getMetaData();
            //获取数据表中的列数
            int columnCount = metaData.getColumnCount();
            List<T> list = new ArrayList<>();
            T t = null;
            while(rs.next()){
                t = classes.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取对应字段的值
                    Object value = rs.getObject((i + 1));
                    //获取对应字段的别名
                    String columnLabel = metaData.getColumnLabel((i + 1));
                    //获取对应字段
                    Field declaredField = classes.getDeclaredField(columnLabel);
                    //设置可访问私有权限的字段
                    declaredField.setAccessible(true);
                    //将值装配给对象
                    declaredField.set(t,value);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }finally {
            JDBCUtils.close(conn,null,pst,rs);
        }

    }

  /*  private String cloumnName(T t){
        //通过反射获得对象的key的数组
        Field[] declaredFields = t.getClass().getDeclaredFields();
        //遍历数组中的key
        String keys = "";
        for (int i =0;i<declaredFields.length;i++){
            Field field = declaredFields[i];
            field.setAccessible(true);
            if (declaredFields.length-1 == i ){
                keys += field.getName();
            }else {
                keys += field.getName()+",";
            }
        }

        return keys;
    }

    private String tableName(T t){
        //通过反射获得对象的表名
        Table annotation = t.getClass().getAnnotation(Table.class);
        System.out.println(annotation.name());
        return annotation.name();
    }
    private Map<String,Object> objValue(T t) throws IllegalAccessException {
        Map<String,Object> mapValues = new HashMap<>();
        //通过反射获得对象的key的数组
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (int i = 0; i <declaredFields.length ; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            Object o = field.get(t);
            if (field.getType().toString().contains("Date")){
                mapValues.put("Date",o);
            }else if (field.getType().toString().contains("String")){
                mapValues.put("String",o);
            }else if (field.getType().toString().contains("int")){
                mapValues.put("int",o);
            }
        }
        return mapValues;
    }
*/
}
