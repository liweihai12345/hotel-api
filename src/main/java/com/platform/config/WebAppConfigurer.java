package com.platform.config;

import com.platform.interceptor.AuthorizationInterceptor;
import com.platform.interceptor.HtmlInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/18 16:57
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    @Value("${swagger.enable}")
    private Boolean enable;

    // 配置自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/api/**");
        registry.addInterceptor(getHtmlInterceptor()).addPathPatterns("/html/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter(new JacksonConfig()));

    }

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (enable) {

        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        }
        super.addResourceHandlers(registry);
    }

    /**
     * swagger-ui.html路径映射，浏览器中使用/api-docs访问
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        if (enable) {
        registry.addRedirectViewController("/api-docs", "/swagger-ui.html");
//        }
    }

    // 配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/html/**").
                allowCredentials(true).
                allowedHeaders("Content-Type, X-Requested-With, accept, Origin, Access-Control-Request-Method,Access-Control-Request-Headers").
                allowedMethods("*").
                allowedOrigins("*").
                exposedHeaders(HttpHeaders.SET_COOKIE).
                maxAge(3600);
    }

    @Bean
    AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Bean
    HtmlInterceptor getHtmlInterceptor() {
        return new HtmlInterceptor();
    }
}
