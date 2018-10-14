package com;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.andz.cloud.db.oracle.annotation.EnableMultiDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@EnableMultiDataSource(basePackages = "com.andz.cloud.db.oracle.mapper")
public class AntzCloudDbmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntzCloudDbmybatisApplication.class, args);
	}

}
