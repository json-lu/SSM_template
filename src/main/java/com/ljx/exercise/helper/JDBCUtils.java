package com.ljx.exercise.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 11:12 2020/12/17
 * @Author: Ljx
 * @Decription:
 */
public class JDBCUtils {
    private  static String driver = null;
    private  static String url = null;
    private  static String username = null;
    private  static String password = null;

    static{
        System.out.println("代码块执行了配置文件解析赋值操作!");
        try {
            /*
            File file = new File("src/main/resources/db.properties");
            System.out.println(file);
            InputStream is = new FileInputStream(file);
            */
            //相对路径
            //InputStream is = new FileInputStream("src/main/resources/db.properties");
            //绝对路径
            //InputStream is = new FileInputStream("D:\\amain_workspace\\Work\\test_code\\SSM_template\\src\\main\\resources\\db.properties");
            //加载配置文件进内存
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //读取内存中的配置文件
            Properties po = new Properties();
            po.load(resourceAsStream);
            driver = po.getProperty("jdbc.driver");
            url = po.getProperty("jdbc.url");
            username = po.getProperty("jdbc.username");
            password = po.getProperty("jdbc.password");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    private static Connection  createConnection(){
        try{
            //加载驱动
            Class.forName(driver);
            //创建连接
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static Connection getConection(){
        Connection connection = createConnection();
        System.out.println(connection);
        return connection;
    }

    public static void close(Connection conn,Statement st,PreparedStatement pst,ResultSet rs){
        if (st !=null) {
            try {
                st.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (pst !=null) {
            try {
                pst.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (rs !=null) {
            try {
                rs.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (conn !=null) {
            try {
                conn.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        Connection conn = JDBCUtils.createConnection();
        System.out.println(conn);
    }
}
