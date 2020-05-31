package com.hyp.config.mvc.filter;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 注入spring容器
@Component
// 定义filterName 和过滤的url
@WebFilter(filterName = "myFilter2" ,urlPatterns = "/*")
public class MyFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器2......");
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {

    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }

}