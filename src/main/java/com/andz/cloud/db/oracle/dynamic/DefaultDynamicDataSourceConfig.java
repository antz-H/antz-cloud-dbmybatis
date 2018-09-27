package com.andz.cloud.db.oracle.dynamic;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
 * @Create: 2018-09-25 16:39
 **/
@Configuration
public class DefaultDynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    @ConditionalOnProperty(value = "spring.datasource.druid.first.url")
    public DataSource defaultDataSource(){
        return DruidDataSourceBuilder.create().build();
        //return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @ConditionalOnProperty(value = "spring.datasource.druid.first.url")
    public DynamicDataSource dataSource(DataSource defaultDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>(10);
        //DataSource defaultDataSource = defaultDataSource() ;
        targetDataSources.put(DataSourceNames.FIRST, defaultDataSource);
        return new DynamicDataSource(defaultDataSource, targetDataSources);
    }


}
