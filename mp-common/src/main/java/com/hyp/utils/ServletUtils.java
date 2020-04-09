package com.hyp.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by  on 2017/9/1.
 * <p>
 * Email 
 * <p>
 * Describe:
 */
public class ServletUtils {

    /**
     * 获取HttpServletRequest
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
