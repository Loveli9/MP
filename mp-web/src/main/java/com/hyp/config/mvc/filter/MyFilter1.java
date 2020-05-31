package com.hyp.config.mvc.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // do something 处理request 或response
        System.out.println("过滤器......");
        // 调用filter链中的下一个filter
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}