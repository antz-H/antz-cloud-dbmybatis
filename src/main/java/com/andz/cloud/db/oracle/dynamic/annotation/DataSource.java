package com.andz.cloud.db.oracle.dynamic.annotation;

import com.andz.cloud.db.oracle.dynamic.DataSourceNames;
import java.lang.annotation.*;
/**
 * 多数据源注解
 * @author huanghuang@rewin.com.cn
 * @create 2018-06-06 15:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSourceNames.FIRST;
}
