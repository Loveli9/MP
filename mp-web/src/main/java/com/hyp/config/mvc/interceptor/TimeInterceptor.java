package com.hyp.config.mvc.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现统计应用性能 拦截器 的实现是单例的，因此不管用户请求多少次 都 只访问一个拦截器实例，即线程不安全<br>
 * 解决方案：使用ThreadLocal,它是线程绑定的变量，提供线程局部变量 (一个线程一个ThreadLocal)
 *
 * @author Administrator
 *
 */
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {

    // 统计应用性能
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("StopWatch-StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 1,开始时间
        long startTime = System.currentTimeMillis();
        // 线程绑定变量(该数据只有当前请求的线程可见)
        startTimeThreadLocal.set(startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 2.结束时间
        long endTime = System.currentTimeMillis();
        // 得到线程绑定的局部 变量(开始时间)
        long beginTime = startTimeThreadLocal.get();
        // 3.计算消耗时间
        long consumeTime = endTime - beginTime;

        log.debug("监控==========================： "
                + String.format("%s 消耗 %d 毫秒", request.getRequestURI(), consumeTime));
        startTimeThreadLocal.remove();

    }

}

