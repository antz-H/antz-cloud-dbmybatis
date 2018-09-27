package com.andz.cloud.db.oracle.dynamic.aspect;


import com.andz.cloud.db.oracle.dynamic.DataSourceNames;
import com.andz.cloud.db.oracle.dynamic.DynamicDataSource;
import com.andz.cloud.db.oracle.dynamic.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源通过切面的方式更改不同的数据源
 *
 * @author huanghuang@rewin.com.cn
 * @create 2018-06-06 16:49
 **/
@Aspect
//@Component
public class DynamicDataSourceAspect {

    private  Logger logger = LoggerFactory.getLogger(getClass());



    @Around("@annotation(com.andz.cloud.db.oracle.dynamic.annotation.DataSource)")
    public Object around(ProceedingJoinPoint point) throws Throwable{

        MethodSignature signature = (MethodSignature) point.getSignature() ;
        Method method = signature.getMethod() ;
        DataSource dataSource = method.getAnnotation(DataSource.class) ;

        if( dataSource == null ){
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            logger.info("set datasource is " + DataSourceNames.FIRST);
        }else{
            DynamicDataSource.setDataSource(dataSource.name());
            logger.info("set datasource is " + dataSource.name());
        }
        try{
            return point.proceed() ;
        } finally {
            DynamicDataSource.clearDataSource();
        }

    }

}
