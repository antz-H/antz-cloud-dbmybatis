package com.andz.cloud.db.oracle.mapper;

import com.andz.cloud.db.oracle.model.Product;
import com.andz.cloud.db.oracle.model.TclTxDate;
import com.andz.cloud.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-10-11 21:03
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DymasticDataSourceTest {

    @Autowired
    ProductService productService ;
    @Transactional
    @Test
    public void DynamicDataSourceTransactionTest(){

        productService.SavaProduct();

        productService.SaveTclTxDate();

    }
}
