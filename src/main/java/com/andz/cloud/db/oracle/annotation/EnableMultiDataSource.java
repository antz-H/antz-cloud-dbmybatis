package com.andz.cloud.db.oracle.annotation;


import com.andz.cloud.db.oracle.dynamic2.DBProperties;
import com.andz.cloud.db.oracle.dynamic2.DefaultDynamicDataSourceConfig;
import com.andz.cloud.db.oracle.dynamic2.aspect.DynamicDataSourceAspect;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.annotation.MapperScannerRegistrar;

import java.lang.annotation.*;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-10-14 10:36
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//内部封装MapperScan，对Mapper的扫描
@MapperScan
@Import({DynamicDataSourceAspect.class, DefaultDynamicDataSourceConfig.class, DBProperties.class, MapperScannerRegistrar.class})
public @interface EnableMultiDataSource {

    @AliasFor(annotation = MapperScan.class,attribute = "basePackages")
    String[] basePackages() default {};

}
