package com.andz.cloud.service.impl;

import com.andz.cloud.db.oracle.model.TclTxDate;
import com.andz.cloud.service.TclTxDateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TclTxDateServiceImplTest {


    @Autowired
    TclTxDateService tclTxDateService ;

    @Test
    public void queryAll(){
       List<TclTxDate> tclTxDates =  tclTxDateService.queryAll() ;

       tclTxDates.stream().forEach(tclTxDate -> {
           System.out.println(tclTxDate.toString());
       });

    }

    @Test
    public void updateTclTxDateTest(){
        tclTxDateService.updateTclTxDate();
    }



}