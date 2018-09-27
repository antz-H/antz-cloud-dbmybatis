package com.andz.cloud.service;

import java.sql.SQLException;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-09-08 14:21
 **/
public interface ProductService {

    void deleteProduct() throws SQLException;

    void upateProduct() ;
}
