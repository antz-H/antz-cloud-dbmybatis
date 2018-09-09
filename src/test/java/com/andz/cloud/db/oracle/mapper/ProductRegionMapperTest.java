package com.andz.cloud.db.oracle.mapper;

import com.andz.cloud.AntzCloudDbmybatisApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AntzCloudDbmybatisApplication.class)
public class ProductRegionMapperTest {

    @Autowired
    ProductRegionMapper productRegionMapper ;

    @Test
    public void queryProductRegion() throws Exception {
        long regionId = 103 ;
        productRegionMapper.queryProductRegion(regionId) ;

        log.info("返回产品地区信息,{}",productRegionMapper.queryProductRegion(regionId)) ;
    }

}