/*package com.ljx.exercise.servlet;

import com.ljx.exercise.pojo.User;
import com.ljx.exercise.service.IUserService;
import com.ljx.exercise.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;*/

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 10:57 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
/*

@WebServlet(value = "/user")
public class UserServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet被初始化了...........");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        try {
            IUserService userService = new UserServiceImpl();
            User user = new User();
            user.setUsername("jack");
            user.setPassword("12390537");
            user.setMobile("17689890032");
            String sql = "insert into user(username,password,mobile) values(?,?,?)";
            PrintWriter out = servletResponse.getWriter();
            boolean b = userService.addUser(sql, user);
            if (b) {
                out.print("添加成功!");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet被销毁了................");
    }
}
*/
