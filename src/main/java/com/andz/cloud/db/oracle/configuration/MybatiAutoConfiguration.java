package com.andz.cloud.db.oracle.configuration;

import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

/**
 * @program: antz-cloud-dbmybatis
 * @description: 为了解决tkMapper的保存实体类的字段为null的问题
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-09-22 12:37
 **/
@Configuration
public class MybatiAutoConfiguration {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new MybatisPlusCustomizers();
    }

    class MybatisPlusCustomizers implements ConfigurationCustomizer {

        @Override
        public void customize(org.apache.ibatis.session.Configuration configuration) {
            configuration.setJdbcTypeForNull(JdbcType.NULL);
        }

    }

}
