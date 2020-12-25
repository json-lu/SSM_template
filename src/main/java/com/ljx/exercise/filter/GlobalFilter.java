package com.ljx.exercise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 11:45 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
//@WebFilter(filterName = "A",urlPatterns = "/*")
public class GlobalFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("GlobalFilter过滤器被初始化了.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("GlobalFilter开始拦截操作.....");
        servletResponse.setContentType("text/html;charset=utf-8");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("GlobalFilter拦截结束了...");
    }

    @Override
    public void destroy() {
        System.out.println("GlobalFilter过滤器被销毁了..........");
    }
}
