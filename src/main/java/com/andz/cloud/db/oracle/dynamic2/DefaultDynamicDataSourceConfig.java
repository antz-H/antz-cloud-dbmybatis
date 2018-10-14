package com.andz.cloud.db.oracle.dynamic2;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-10-13 10:40
 **/
@Slf4j
//@Configuration
public class DefaultDynamicDataSourceConfig {

    @Autowired
    private DBProperties dbProperties ;
    //默认数据源的名称
    @Value("${demeter.dynamic.datasource.config.default.db:first}")
    private String defaultDb ;

    @Bean("dataSource")
    @Primary
    public DataSource dataSource(){
        Map<String, DataSource> targetDataSources = new HashMap<>();
        Map<String,DruidDataSource> druid = dbProperties.getDruid() ;
        DruidDataSource druidDataSource = null ;
        DruidDataSource defaultDataSource = null ;
        for(String key : druid.keySet()){
            druidDataSource = druid.get(key) ;
            String druidName = druidDataSource.getName() ;
            targetDataSources.put(druidName,druidDataSource);
            //获取默认数据源
            if(druidName.equals(defaultDb)){
                defaultDataSource = druidDataSource ;
            }
        }
        if(defaultDataSource == null){
            log.error("==============》dynamic datasource init error , reason : default datasource can not found  defaultDb : {}《====================",defaultDb);
            System.exit(0);
        }else{
            log.info("Dynamic datasource init successfully");
        }
       return new DynamicDataSource(defaultDataSource,targetDataSources) ;
    }
}
