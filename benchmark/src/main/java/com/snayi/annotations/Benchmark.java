package com.snayi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-19 11:40
 * @Description:  被Benchmark标注的方法需要被测试   注解保留在运行期间；用来修饰方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Benchmark {
}
