package com.hyp.config.mvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hyp.config.mvc.listener.ReqInterceptor;
import com.hyp.config.mvc.listener.USLocalDateFormatter;
import com.hyp.config.sitemesh.WebSiteMeshFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.MediaType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.cors.CorsConfiguration.ALL;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${attach_path}")
    private String attachPath;

    /**
     * 添加类型转换器和格式化器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }

    /**
     * 添加静态资源--过滤swagger-api (开源的在线API文档)
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //过滤swagger
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/swagger-resources/**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-resources/");

        registry.addResourceHandler("/swagger/**")
                .addResourceLocations("classpath:/META-INF/resources/swagger*");

        registry.addResourceHandler("/v2/api-docs/**")
                .addResourceLocations("classpath:/META-INF/resources/v2/api-docs/");

    }

    /**
     * 装饰器
     */
    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean fitler = new FilterRegistrationBean();
        WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
        fitler.setFilter(siteMeshFilter);
        return fitler;
    }

    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new MyErrorPageRegistrar();
    }

    private static class MyErrorPageRegistrar implements ErrorPageRegistrar {
        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            registry.addErrorPages(
                    new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html"),
                    new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"),
                    new ErrorPage(HttpStatus.NOT_FOUND, "/404.html")
            );
        }
    }

    /**
     * 提前配置跨越问题
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders(ALL)
                .allowCredentials(true)
                .maxAge(3600 * 24);
    }

    /**
     * 配置消息转换器--这里我用的是alibaba 开源的 fastjson
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fjc = new FastJsonConfig();
//        //1、序列化重点
//        fjc.setSerializerFeatures(SerializerFeature.BrowserCompatible);
//        fastJsonConverter.setFastJsonConfig(fjc);
//        converters.add(fastJsonConverter);

        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //5.将convert添加到converters当中.
        converters.add(fastJsonHttpMessageConverter);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ReqInterceptor()).addPathPatterns("/**");
    }

}
