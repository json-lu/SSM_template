package com.ljx.exercise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 13:18 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
//@WebFilter(filterName = "B",urlPatterns = "/*")
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RequestFilter被初始化了.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("RequestFilter开始拦截了........");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (requestURI.contains("/user") ||requestURI.contains("/api")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            return ;
        }
        System.out.println("RequestFilter结束拦截了....");
    }

    @Override
    public void destroy() {
        System.out.println("RequestFilter被初始化了..............");
    }
}
