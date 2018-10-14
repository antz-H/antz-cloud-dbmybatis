package com.andz.cloud.service;

import com.andz.cloud.db.oracle.model.TclTxDate;

import java.util.List;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-10-14 10:36
 **/
public interface TclTxDateService {

    List<TclTxDate> queryAll();

    void updateTclTxDate();

}
