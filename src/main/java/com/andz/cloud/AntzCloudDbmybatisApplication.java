package com.andz.cloud;

import com.andz.cloud.db.oracle.mapper.ProductMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.andz.cloud.db.oracle.mapper")
@ComponentScan
public class AntzCloudDbmybatisApplication {

	private static ApplicationContext applicationContext;

	public AntzCloudDbmybatisApplication(ProductMapper productMapper1) {
		productMapper = productMapper1 ;
	}

	static ProductMapper productMapper ;

	public static void main(String[] args) {
		SpringApplication.run(AntzCloudDbmybatisApplication.class, args);
		System.out.println("dfdfd");
		//System.out.println(productMapper.selectAll().toString());
	}

	public void test(){
	}
}
