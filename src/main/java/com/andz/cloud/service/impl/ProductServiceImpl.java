package com.andz.cloud.service.impl;

import com.andz.cloud.db.oracle.dynamic.DataSourceNames;
import com.andz.cloud.db.oracle.annotation.DataSource;
import com.andz.cloud.db.oracle.mapper.ProductMapper;
import com.andz.cloud.db.oracle.mapper.TclTxDateMapper;
import com.andz.cloud.db.oracle.model.Product;
import com.andz.cloud.db.oracle.model.ProductExample;
import com.andz.cloud.db.oracle.model.TclTxDate;
import com.andz.cloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper ;

    @Autowired
    TclTxDateMapper tclTxDateMapper ;

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

    @Override
    public void SavaProduct() {
        Product p = new Product();
        p.setProductName("柿子");
        p.setProductNo(1000110l);
        productMapper.insert(p);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public void SaveTclTxDate(){
        TclTxDate tclTxDate = new TclTxDate();
        tclTxDate.setBranchCode("0001");
        tclTxDate.setBusiDate(1l);
        tclTxDate.setMarketCode("1");
        tclTxDate.setBusinessStatus("2");
        tclTxDate.setTxDate("12");
        tclTxDate.setClrCtrl(1l);
        tclTxDateMapper.insert(tclTxDate) ;
    }


}
