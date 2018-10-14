package com.andz.cloud.db.oracle.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Table(name = "TCL_TX_DATE")
public class TclTxDate {
    @Column(name = "BUSI_DATE")
    private Long busiDate;

    @Column(name = "BRANCH_CODE")
    private String branchCode;

    @Column(name = "MARKET_CODE")
    private String marketCode;

    @Column(name = "TX_DATE")
    private String txDate;

    @Column(name = "CLR_CTRL")
    private Long clrCtrl;

    @Column(name = "BUSINESS_STATUS")
    private String businessStatus;


}