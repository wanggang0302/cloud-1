package com.jfsoft.task.core;

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 * wanggang
 * 2017-7-11 10:28:35
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String name();

}
