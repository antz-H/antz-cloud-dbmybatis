package com.andz.cloud.service.impl;

import com.andz.cloud.db.oracle.annotation.DataSource;
import com.andz.cloud.db.oracle.mapper.TclTxDateMapper;
import com.andz.cloud.db.oracle.model.TclTxDate;
import com.andz.cloud.service.TclTxDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-10-14 10:36
 **/
@Service
public class TclTxDateServiceImpl implements TclTxDateService {

    @Autowired
    TclTxDateMapper tclTxDateMapper ;

    @DataSource(name = "huangyh")
    @Override
    public List<TclTxDate> queryAll() {

        return tclTxDateMapper.selectAll();

    }

    //@Transactional
    @DataSource(name = "huangyh")
    @Override
    public void updateTclTxDate() {
        TclTxDate tclTxDate = new TclTxDate() ;
        tclTxDate.setBranchCode("0002");
        tclTxDate.setBusiDate(1l);
        tclTxDate.setMarketCode("1");
        tclTxDate.setBusinessStatus("2");
        tclTxDate.setTxDate("huang");
        tclTxDate.setClrCtrl(1l);
        tclTxDateMapper.insert(tclTxDate);


        TclTxDate tclTxDate1 = new TclTxDate();
        tclTxDate1.setBranchCode("0001");
        tclTxDate1.setBusiDate(1l);
        tclTxDate1.setMarketCode("1");
        tclTxDate1.setBusinessStatus("2");
        tclTxDate1.setTxDate("12");
        tclTxDate1.setClrCtrl(1l);
        tclTxDateMapper.insert(tclTxDate1);

         double jj = 1/0  ;

    }
}
