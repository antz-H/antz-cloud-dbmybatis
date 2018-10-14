package com.andz.cloud.db.oracle.dynamic2;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-10-13 09:53
 **/
//@Component
@ConfigurationProperties(prefix = "demeter.dynamic.datasource")
public class DBProperties {

    private Map<String,DruidDataSource> druid ;

    public Map<String, DruidDataSource> getDruid() {
        return druid;
    }

    public void setDruid(Map<String, DruidDataSource> druid) {
        this.druid = druid;
    }

}
