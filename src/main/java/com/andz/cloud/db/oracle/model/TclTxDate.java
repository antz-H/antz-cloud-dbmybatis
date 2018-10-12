package com.andz.cloud.db.oracle.model;

import javax.persistence.*;

@Table(name = "TCL_TX_DATE")
public class TclTxDate {
    @Column(name = "BUSI_DATE")
    private Short busiDate;

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

    /**
     * @return BUSI_DATE
     */
    public Short getBusiDate() {
        return busiDate;
    }

    /**
     * @param busiDate
     */
    public void setBusiDate(Short busiDate) {
        this.busiDate = busiDate;
    }

    /**
     * @return BRANCH_CODE
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    /**
     * @return MARKET_CODE
     */
    public String getMarketCode() {
        return marketCode;
    }

    /**
     * @param marketCode
     */
    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode == null ? null : marketCode.trim();
    }

    /**
     * @return TX_DATE
     */
    public String getTxDate() {
        return txDate;
    }

    /**
     * @param txDate
     */
    public void setTxDate(String txDate) {
        this.txDate = txDate == null ? null : txDate.trim();
    }

    /**
     * @return CLR_CTRL
     */
    public Long getClrCtrl() {
        return clrCtrl;
    }

    /**
     * @param clrCtrl
     */
    public void setClrCtrl(Long clrCtrl) {
        this.clrCtrl = clrCtrl;
    }

    /**
     * @return BUSINESS_STATUS
     */
    public String getBusinessStatus() {
        return businessStatus;
    }

    /**
     * @param businessStatus
     */
    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus == null ? null : businessStatus.trim();
    }
}