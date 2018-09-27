package com.andz.cloud.service.impl;

import com.andz.cloud.db.oracle.dynamic.DataSourceNames;
import com.andz.cloud.db.oracle.dynamic.annotation.DataSource;
import com.andz.cloud.db.oracle.mapper.ProductMapper;
import com.andz.cloud.db.oracle.model.Product;
import com.andz.cloud.db.oracle.model.ProductExample;
import com.andz.cloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Random;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-09-08 14:21
 **/
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper ;

    @Override
    public void deleteProduct() throws SQLException {
        String productName = "test8";
        ProductExample productExample = new ProductExample();
        productExample.createCriteria()
                .andProductNameEqualTo(productName);
        int num = productMapper.selectCountByExample(productExample);
        log.info("返回个数，{}",num);

        productMapper.deleteByExample(productExample);
        //测试事务
        throw new NullPointerException();
    }

    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public void upateProduct() {
        String productName = "testPingg7777777777";
        ProductExample productExample = new ProductExample();
        productExample.createCriteria()
                .andProductNameEqualTo(productName);

        Product product = new Product();
        product.setProductName("test"+new Random().nextInt(100));
        productMapper.updateByExample(product,productExample);
        //throw new NullPointerException();
    }
}
