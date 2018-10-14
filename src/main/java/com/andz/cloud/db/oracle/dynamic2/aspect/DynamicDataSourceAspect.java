package com.andz.cloud.db.oracle.dynamic2.aspect;


import com.andz.cloud.db.oracle.annotation.DataSource;
import com.andz.cloud.db.oracle.dynamic2.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源通过切面的方式更改不同的数据源
 *
 * @author huanghuang@rewin.com.cn
 * @create 2018-06-06 16:49
 **/
@Aspect
@Slf4j
//@Component
public class DynamicDataSourceAspect {

    //默认数据源的名称
    @Value("${demeter.dynamic.datasource.config.default.db:first}")
    private String defaultDb ;

    @Around("@annotation(com.andz.cloud.db.oracle.annotation.DataSource)")
    public Object around(ProceedingJoinPoint point) throws Throwable{

        MethodSignature signature = (MethodSignature) point.getSignature() ;
        Method method = signature.getMethod() ;
        DataSource dataSource = method.getAnnotation(DataSource.class) ;

        if( dataSource == null ){
            DynamicDataSource.setDataSource(defaultDb);
            log.info("set default datasource {} " , defaultDb);
        }else{
            DynamicDataSource.setDataSource(dataSource.name());
            log.info("set datasource {} " , dataSource.name());
        }
        try{
            return point.proceed() ;
        } finally {
            DynamicDataSource.clearDataSource();
        }

    }

}
