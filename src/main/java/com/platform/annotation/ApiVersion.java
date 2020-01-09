package com.platform.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @program:
 * @Description: 版本控制
 * @Author: liweihai
 * @Date: Created in 2019/1/29 10:02
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    int value();
}
