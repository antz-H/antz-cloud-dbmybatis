package com.andz.cloud.db.oracle.dynamic;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;
import tk.mybatis.mapper.autoconfigure.MybatisProperties;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-09-25 16:39
 **/
//@Configuration
public class DefaultDynamicDataSourceConfig {

    @Bean("defaultDataSource")
    @ConfigurationProperties("spring.datasource.druid.first")
    @ConditionalOnProperty(value = "spring.datasource.druid.first.url")
    public DataSource defaultDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("secondDataSource")
    @ConfigurationProperties("spring.datasource.druid.second")
    @ConditionalOnProperty(value = "spring.datasource.druid.second.url")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @ConditionalOnProperty(value = "spring.datasource.druid.first.url")
    public DynamicDataSource dataSource() {
        Map<String, DataSource> targetDataSources = new HashMap<>(10);
        DataSource defaultDataSource = defaultDataSource() ;
        DataSource secondDataSource =  secondDataSource();
        targetDataSources.put(DataSourceNames.FIRST, defaultDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new DynamicDataSource(defaultDataSource, targetDataSources);
    }

    /**
     * 当需要不同的数据源使用不同的sqlsessionfactory或者加载不同的mapper时，
     * 可以定制化配置不同的mapperlocation，这里必须指定mapperlocation，否则默认不会去读取MybatisProperties
     * 这里采用默认的配置，自动在MapperAutoConfiguration中初始化sqlSessionFactory
     * @see MybatisProperties
     * @see MapperAutoConfiguration
     * @return
     * @throws Exception
     */
   /* @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        String mapperLocations = "classpath:mapper/*.xml";
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources =  resourceResolver.getResources(mapperLocations);
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject() ;
    }*/

    /**
     * 不同数据源的不同事务配置时，可开启，默认是通过AutoConfiguration自动装载，配置在DataSourceTransactionManagerAutoConfiguration
     * @see DataSourceTransactionManagerAutoConfiguration
     */
  /*  @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }*/


}
