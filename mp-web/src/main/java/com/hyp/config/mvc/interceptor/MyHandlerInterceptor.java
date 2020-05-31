package com.hyp.config.mvc.interceptor;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter与Interceptor联系与区别：
 * 1、拦截器是基于java的反射机制，使用代理模式，而过滤器是基于函数回调
 * 2、拦截器不依赖servlet容器，过滤器依赖于servlet容器
 * 3、拦截器只能对action起作用，而过滤器可以对几乎所有的请求起作用（可以保护资源）
 * 4、拦截器可以访问action上下文，堆栈里面的对象，而过滤器不可以
 * 5、执行顺序：过滤前-拦截前-Action处理-拦截后-过滤后
 * */
public class MyHandlerInterceptor implements HandlerInterceptor {

    private final static Logger LOG = Logger.getLogger(MyHandlerInterceptor.class);
    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3) {
        MDC.remove("sessionId");
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        MDC.put("sessionId", getCard());
        LOG.debug("======Controller："+handler.getClass().getName());
        LOG.debug("======方法名："+request.getServletPath());
        return true;
    }


    public static String getCard(){
        java.util.Random rand=new java.util.Random();
        StringBuilder cardNnumer = new StringBuilder();
        for(int a=0;a<10;a++){
            cardNnumer.append(rand.nextInt(10));
        }
        return cardNnumer.toString();
    }

    public static void main(String[] args) {
        String sessionId = getCard();
        System.out.println(sessionId);
    }

}
