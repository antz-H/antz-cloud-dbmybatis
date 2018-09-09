package com.andz.cloud.service.impl;

import com.andz.cloud.db.oracle.mapper.ProductMapper;
import com.andz.cloud.db.oracle.model.ProductExample;
import com.andz.cloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-09-08 14:21
 **/
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper ;

    @Override
    public void hello() {
        String productName = "苹果";
        ProductExample productExample = new ProductExample();
        productExample.createCriteria()
                .andProductNameEqualTo(productName);
        int num = productMapper.selectCountByExample(productExample);
        log.info("返回个数，{}",num);

        productMapper.deleteByExample(productExample);
    }
}
