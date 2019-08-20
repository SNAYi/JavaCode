package com.snayi.annotations;

import com.snayi.Case;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-19 16:04
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface WarmUp {
    int iterators() default 0;
}
