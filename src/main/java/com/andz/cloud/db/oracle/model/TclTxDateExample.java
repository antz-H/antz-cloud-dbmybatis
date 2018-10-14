package com.andz.cloud.db.oracle.model;

import java.util.ArrayList;
import java.util.List;

public class TclTxDateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TclTxDateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBusiDateIsNull() {
            addCriterion("BUSI_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBusiDateIsNotNull() {
            addCriterion("BUSI_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBusiDateEqualTo(Short value) {
            addCriterion("BUSI_DATE =", value, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateNotEqualTo(Short value) {
            addCriterion("BUSI_DATE <>", value, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateGreaterThan(Short value) {
            addCriterion("BUSI_DATE >", value, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateGreaterThanOrEqualTo(Short value) {
            addCriterion("BUSI_DATE >=", value, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateLessThan(Short value) {
            addCriterion("BUSI_DATE <", value, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateLessThanOrEqualTo(Short value) {
            addCriterion("BUSI_DATE <=", value, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateIn(List<Short> values) {
            addCriterion("BUSI_DATE in", values, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateNotIn(List<Short> values) {
            addCriterion("BUSI_DATE not in", values, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateBetween(Short value1, Short value2) {
            addCriterion("BUSI_DATE between", value1, value2, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBusiDateNotBetween(Short value1, Short value2) {
            addCriterion("BUSI_DATE not between", value1, value2, "busiDate");
            return (Criteria) this;
        }

        public Criteria andBranchCodeIsNull() {
            addCriterion("BRANCH_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBranchCodeIsNotNull() {
            addCriterion("BRANCH_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBranchCodeEqualTo(String value) {
            addCriterion("BRANCH_CODE =", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotEqualTo(String value) {
            addCriterion("BRANCH_CODE <>", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeGreaterThan(String value) {
            addCriterion("BRANCH_CODE >", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BRANCH_CODE >=", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeLessThan(String value) {
            addCriterion("BRANCH_CODE <", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeLessThanOrEqualTo(String value) {
            addCriterion("BRANCH_CODE <=", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeLike(String value) {
            addCriterion("BRANCH_CODE like", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotLike(String value) {
            addCriterion("BRANCH_CODE not like", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeIn(List<String> values) {
            addCriterion("BRANCH_CODE in", values, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotIn(List<String> values) {
            addCriterion("BRANCH_CODE not in", values, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeBetween(String value1, String value2) {
            addCriterion("BRANCH_CODE between", value1, value2, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotBetween(String value1, String value2) {
            addCriterion("BRANCH_CODE not between", value1, value2, "branchCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeIsNull() {
            addCriterion("MARKET_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMarketCodeIsNotNull() {
            addCriterion("MARKET_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMarketCodeEqualTo(String value) {
            addCriterion("MARKET_CODE =", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotEqualTo(String value) {
            addCriterion("MARKET_CODE <>", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeGreaterThan(String value) {
            addCriterion("MARKET_CODE >", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MARKET_CODE >=", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeLessThan(String value) {
            addCriterion("MARKET_CODE <", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeLessThanOrEqualTo(String value) {
            addCriterion("MARKET_CODE <=", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeLike(String value) {
            addCriterion("MARKET_CODE like", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotLike(String value) {
            addCriterion("MARKET_CODE not like", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeIn(List<String> values) {
            addCriterion("MARKET_CODE in", values, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotIn(List<String> values) {
            addCriterion("MARKET_CODE not in", values, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeBetween(String value1, String value2) {
            addCriterion("MARKET_CODE between", value1, value2, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotBetween(String value1, String value2) {
            addCriterion("MARKET_CODE not between", value1, value2, "marketCode");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNull() {
            addCriterion("TX_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNotNull() {
            addCriterion("TX_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTxDateEqualTo(String value) {
            addCriterion("TX_DATE =", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotEqualTo(String value) {
            addCriterion("TX_DATE <>", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThan(String value) {
            addCriterion("TX_DATE >", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThanOrEqualTo(String value) {
            addCriterion("TX_DATE >=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThan(String value) {
            addCriterion("TX_DATE <", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThanOrEqualTo(String value) {
            addCriterion("TX_DATE <=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLike(String value) {
            addCriterion("TX_DATE like", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotLike(String value) {
            addCriterion("TX_DATE not like", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateIn(List<String> values) {
            addCriterion("TX_DATE in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotIn(List<String> values) {
            addCriterion("TX_DATE not in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateBetween(String value1, String value2) {
            addCriterion("TX_DATE between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotBetween(String value1, String value2) {
            addCriterion("TX_DATE not between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andClrCtrlIsNull() {
            addCriterion("CLR_CTRL is null");
            return (Criteria) this;
        }

        public Criteria andClrCtrlIsNotNull() {
            addCriterion("CLR_CTRL is not null");
            return (Criteria) this;
        }

        public Criteria andClrCtrlEqualTo(Long value) {
            addCriterion("CLR_CTRL =", value, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlNotEqualTo(Long value) {
            addCriterion("CLR_CTRL <>", value, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlGreaterThan(Long value) {
            addCriterion("CLR_CTRL >", value, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlGreaterThanOrEqualTo(Long value) {
            addCriterion("CLR_CTRL >=", value, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlLessThan(Long value) {
            addCriterion("CLR_CTRL <", value, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlLessThanOrEqualTo(Long value) {
            addCriterion("CLR_CTRL <=", value, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlIn(List<Long> values) {
            addCriterion("CLR_CTRL in", values, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlNotIn(List<Long> values) {
            addCriterion("CLR_CTRL not in", values, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlBetween(Long value1, Long value2) {
            addCriterion("CLR_CTRL between", value1, value2, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andClrCtrlNotBetween(Long value1, Long value2) {
            addCriterion("CLR_CTRL not between", value1, value2, "clrCtrl");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusIsNull() {
            addCriterion("BUSINESS_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusIsNotNull() {
            addCriterion("BUSINESS_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusEqualTo(String value) {
            addCriterion("BUSINESS_STATUS =", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotEqualTo(String value) {
            addCriterion("BUSINESS_STATUS <>", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusGreaterThan(String value) {
            addCriterion("BUSINESS_STATUS >", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_STATUS >=", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusLessThan(String value) {
            addCriterion("BUSINESS_STATUS <", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_STATUS <=", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusLike(String value) {
            addCriterion("BUSINESS_STATUS like", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotLike(String value) {
            addCriterion("BUSINESS_STATUS not like", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusIn(List<String> values) {
            addCriterion("BUSINESS_STATUS in", values, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotIn(List<String> values) {
            addCriterion("BUSINESS_STATUS not in", values, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusBetween(String value1, String value2) {
            addCriterion("BUSINESS_STATUS between", value1, value2, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_STATUS not between", value1, value2, "businessStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}