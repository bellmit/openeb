package com.gsccs.b2c.plat.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.b2c.plat.bass.BaseExample;

public class ReturnOrderExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReturnOrderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("orderNum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("orderNum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("orderNum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("orderNum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("orderNum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("orderNum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("orderNum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("orderNum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("orderNum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("orderNum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("orderNum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("orderNum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeIsNull() {
            addCriterion("createReturnGoodsTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeIsNotNull() {
            addCriterion("createReturnGoodsTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeEqualTo(Date value) {
            addCriterion("createReturnGoodsTime =", value, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeNotEqualTo(Date value) {
            addCriterion("createReturnGoodsTime <>", value, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeGreaterThan(Date value) {
            addCriterion("createReturnGoodsTime >", value, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createReturnGoodsTime >=", value, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeLessThan(Date value) {
            addCriterion("createReturnGoodsTime <", value, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeLessThanOrEqualTo(Date value) {
            addCriterion("createReturnGoodsTime <=", value, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeIn(List<Date> values) {
            addCriterion("createReturnGoodsTime in", values, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeNotIn(List<Date> values) {
            addCriterion("createReturnGoodsTime not in", values, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeBetween(Date value1, Date value2) {
            addCriterion("createReturnGoodsTime between", value1, value2, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andCreatereturngoodstimeNotBetween(Date value1, Date value2) {
            addCriterion("createReturnGoodsTime not between", value1, value2, "createreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonIsNull() {
            addCriterion("returnGoodsReason is null");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonIsNotNull() {
            addCriterion("returnGoodsReason is not null");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonEqualTo(String value) {
            addCriterion("returnGoodsReason =", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonNotEqualTo(String value) {
            addCriterion("returnGoodsReason <>", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonGreaterThan(String value) {
            addCriterion("returnGoodsReason >", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonGreaterThanOrEqualTo(String value) {
            addCriterion("returnGoodsReason >=", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonLessThan(String value) {
            addCriterion("returnGoodsReason <", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonLessThanOrEqualTo(String value) {
            addCriterion("returnGoodsReason <=", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonLike(String value) {
            addCriterion("returnGoodsReason like", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonNotLike(String value) {
            addCriterion("returnGoodsReason not like", value, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonIn(List<String> values) {
            addCriterion("returnGoodsReason in", values, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonNotIn(List<String> values) {
            addCriterion("returnGoodsReason not in", values, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonBetween(String value1, String value2) {
            addCriterion("returnGoodsReason between", value1, value2, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsreasonNotBetween(String value1, String value2) {
            addCriterion("returnGoodsReason not between", value1, value2, "returngoodsreason");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusIsNull() {
            addCriterion("returnGoodsStatus is null");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusIsNotNull() {
            addCriterion("returnGoodsStatus is not null");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusEqualTo(String value) {
            addCriterion("returnGoodsStatus =", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusNotEqualTo(String value) {
            addCriterion("returnGoodsStatus <>", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusGreaterThan(String value) {
            addCriterion("returnGoodsStatus >", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusGreaterThanOrEqualTo(String value) {
            addCriterion("returnGoodsStatus >=", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusLessThan(String value) {
            addCriterion("returnGoodsStatus <", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusLessThanOrEqualTo(String value) {
            addCriterion("returnGoodsStatus <=", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusLike(String value) {
            addCriterion("returnGoodsStatus like", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusNotLike(String value) {
            addCriterion("returnGoodsStatus not like", value, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusIn(List<String> values) {
            addCriterion("returnGoodsStatus in", values, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusNotIn(List<String> values) {
            addCriterion("returnGoodsStatus not in", values, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusBetween(String value1, String value2) {
            addCriterion("returnGoodsStatus between", value1, value2, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andReturngoodsstatusNotBetween(String value1, String value2) {
            addCriterion("returnGoodsStatus not between", value1, value2, "returngoodsstatus");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressIsNull() {
            addCriterion("returnGoodsAddress is null");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressIsNotNull() {
            addCriterion("returnGoodsAddress is not null");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressEqualTo(String value) {
            addCriterion("returnGoodsAddress =", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressNotEqualTo(String value) {
            addCriterion("returnGoodsAddress <>", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressGreaterThan(String value) {
            addCriterion("returnGoodsAddress >", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressGreaterThanOrEqualTo(String value) {
            addCriterion("returnGoodsAddress >=", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressLessThan(String value) {
            addCriterion("returnGoodsAddress <", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressLessThanOrEqualTo(String value) {
            addCriterion("returnGoodsAddress <=", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressLike(String value) {
            addCriterion("returnGoodsAddress like", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressNotLike(String value) {
            addCriterion("returnGoodsAddress not like", value, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressIn(List<String> values) {
            addCriterion("returnGoodsAddress in", values, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressNotIn(List<String> values) {
            addCriterion("returnGoodsAddress not in", values, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressBetween(String value1, String value2) {
            addCriterion("returnGoodsAddress between", value1, value2, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andReturngoodsaddressNotBetween(String value1, String value2) {
            addCriterion("returnGoodsAddress not between", value1, value2, "returngoodsaddress");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeIsNull() {
            addCriterion("authReturnGoodsTime is null");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeIsNotNull() {
            addCriterion("authReturnGoodsTime is not null");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeEqualTo(Date value) {
            addCriterion("authReturnGoodsTime =", value, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeNotEqualTo(Date value) {
            addCriterion("authReturnGoodsTime <>", value, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeGreaterThan(Date value) {
            addCriterion("authReturnGoodsTime >", value, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("authReturnGoodsTime >=", value, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeLessThan(Date value) {
            addCriterion("authReturnGoodsTime <", value, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeLessThanOrEqualTo(Date value) {
            addCriterion("authReturnGoodsTime <=", value, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeIn(List<Date> values) {
            addCriterion("authReturnGoodsTime in", values, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeNotIn(List<Date> values) {
            addCriterion("authReturnGoodsTime not in", values, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeBetween(Date value1, Date value2) {
            addCriterion("authReturnGoodsTime between", value1, value2, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodstimeNotBetween(Date value1, Date value2) {
            addCriterion("authReturnGoodsTime not between", value1, value2, "authreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainIsNull() {
            addCriterion("authReturnGoodsExplain is null");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainIsNotNull() {
            addCriterion("authReturnGoodsExplain is not null");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainEqualTo(String value) {
            addCriterion("authReturnGoodsExplain =", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainNotEqualTo(String value) {
            addCriterion("authReturnGoodsExplain <>", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainGreaterThan(String value) {
            addCriterion("authReturnGoodsExplain >", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainGreaterThanOrEqualTo(String value) {
            addCriterion("authReturnGoodsExplain >=", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainLessThan(String value) {
            addCriterion("authReturnGoodsExplain <", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainLessThanOrEqualTo(String value) {
            addCriterion("authReturnGoodsExplain <=", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainLike(String value) {
            addCriterion("authReturnGoodsExplain like", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainNotLike(String value) {
            addCriterion("authReturnGoodsExplain not like", value, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainIn(List<String> values) {
            addCriterion("authReturnGoodsExplain in", values, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainNotIn(List<String> values) {
            addCriterion("authReturnGoodsExplain not in", values, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainBetween(String value1, String value2) {
            addCriterion("authReturnGoodsExplain between", value1, value2, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andAuthreturngoodsexplainNotBetween(String value1, String value2) {
            addCriterion("authReturnGoodsExplain not between", value1, value2, "authreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeIsNull() {
            addCriterion("submitReturnGoodsFormTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeIsNotNull() {
            addCriterion("submitReturnGoodsFormTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeEqualTo(Date value) {
            addCriterion("submitReturnGoodsFormTime =", value, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeNotEqualTo(Date value) {
            addCriterion("submitReturnGoodsFormTime <>", value, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeGreaterThan(Date value) {
            addCriterion("submitReturnGoodsFormTime >", value, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submitReturnGoodsFormTime >=", value, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeLessThan(Date value) {
            addCriterion("submitReturnGoodsFormTime <", value, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeLessThanOrEqualTo(Date value) {
            addCriterion("submitReturnGoodsFormTime <=", value, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeIn(List<Date> values) {
            addCriterion("submitReturnGoodsFormTime in", values, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeNotIn(List<Date> values) {
            addCriterion("submitReturnGoodsFormTime not in", values, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeBetween(Date value1, Date value2) {
            addCriterion("submitReturnGoodsFormTime between", value1, value2, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andSubmitreturngoodsformtimeNotBetween(Date value1, Date value2) {
            addCriterion("submitReturnGoodsFormTime not between", value1, value2, "submitreturngoodsformtime");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumIsNull() {
            addCriterion("logisticsNum is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumIsNotNull() {
            addCriterion("logisticsNum is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumEqualTo(String value) {
            addCriterion("logisticsNum =", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumNotEqualTo(String value) {
            addCriterion("logisticsNum <>", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumGreaterThan(String value) {
            addCriterion("logisticsNum >", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumGreaterThanOrEqualTo(String value) {
            addCriterion("logisticsNum >=", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumLessThan(String value) {
            addCriterion("logisticsNum <", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumLessThanOrEqualTo(String value) {
            addCriterion("logisticsNum <=", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumLike(String value) {
            addCriterion("logisticsNum like", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumNotLike(String value) {
            addCriterion("logisticsNum not like", value, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumIn(List<String> values) {
            addCriterion("logisticsNum in", values, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumNotIn(List<String> values) {
            addCriterion("logisticsNum not in", values, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumBetween(String value1, String value2) {
            addCriterion("logisticsNum between", value1, value2, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andLogisticsnumNotBetween(String value1, String value2) {
            addCriterion("logisticsNum not between", value1, value2, "logisticsnum");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeIsNull() {
            addCriterion("finishReturnGoodsTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeIsNotNull() {
            addCriterion("finishReturnGoodsTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeEqualTo(Date value) {
            addCriterion("finishReturnGoodsTime =", value, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeNotEqualTo(Date value) {
            addCriterion("finishReturnGoodsTime <>", value, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeGreaterThan(Date value) {
            addCriterion("finishReturnGoodsTime >", value, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishReturnGoodsTime >=", value, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeLessThan(Date value) {
            addCriterion("finishReturnGoodsTime <", value, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeLessThanOrEqualTo(Date value) {
            addCriterion("finishReturnGoodsTime <=", value, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeIn(List<Date> values) {
            addCriterion("finishReturnGoodsTime in", values, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeNotIn(List<Date> values) {
            addCriterion("finishReturnGoodsTime not in", values, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeBetween(Date value1, Date value2) {
            addCriterion("finishReturnGoodsTime between", value1, value2, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodstimeNotBetween(Date value1, Date value2) {
            addCriterion("finishReturnGoodsTime not between", value1, value2, "finishreturngoodstime");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainIsNull() {
            addCriterion("finishReturnGoodsExplain is null");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainIsNotNull() {
            addCriterion("finishReturnGoodsExplain is not null");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainEqualTo(String value) {
            addCriterion("finishReturnGoodsExplain =", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainNotEqualTo(String value) {
            addCriterion("finishReturnGoodsExplain <>", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainGreaterThan(String value) {
            addCriterion("finishReturnGoodsExplain >", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainGreaterThanOrEqualTo(String value) {
            addCriterion("finishReturnGoodsExplain >=", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainLessThan(String value) {
            addCriterion("finishReturnGoodsExplain <", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainLessThanOrEqualTo(String value) {
            addCriterion("finishReturnGoodsExplain <=", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainLike(String value) {
            addCriterion("finishReturnGoodsExplain like", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainNotLike(String value) {
            addCriterion("finishReturnGoodsExplain not like", value, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainIn(List<String> values) {
            addCriterion("finishReturnGoodsExplain in", values, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainNotIn(List<String> values) {
            addCriterion("finishReturnGoodsExplain not in", values, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainBetween(String value1, String value2) {
            addCriterion("finishReturnGoodsExplain between", value1, value2, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andFinishreturngoodsexplainNotBetween(String value1, String value2) {
            addCriterion("finishReturnGoodsExplain not between", value1, value2, "finishreturngoodsexplain");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeIsNull() {
            addCriterion("createBackMoneyTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeIsNotNull() {
            addCriterion("createBackMoneyTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeEqualTo(Date value) {
            addCriterion("createBackMoneyTime =", value, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeNotEqualTo(Date value) {
            addCriterion("createBackMoneyTime <>", value, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeGreaterThan(Date value) {
            addCriterion("createBackMoneyTime >", value, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createBackMoneyTime >=", value, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeLessThan(Date value) {
            addCriterion("createBackMoneyTime <", value, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeLessThanOrEqualTo(Date value) {
            addCriterion("createBackMoneyTime <=", value, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeIn(List<Date> values) {
            addCriterion("createBackMoneyTime in", values, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeNotIn(List<Date> values) {
            addCriterion("createBackMoneyTime not in", values, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeBetween(Date value1, Date value2) {
            addCriterion("createBackMoneyTime between", value1, value2, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andCreatebackmoneytimeNotBetween(Date value1, Date value2) {
            addCriterion("createBackMoneyTime not between", value1, value2, "createbackmoneytime");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonIsNull() {
            addCriterion("backMoneyReason is null");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonIsNotNull() {
            addCriterion("backMoneyReason is not null");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonEqualTo(String value) {
            addCriterion("backMoneyReason =", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonNotEqualTo(String value) {
            addCriterion("backMoneyReason <>", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonGreaterThan(String value) {
            addCriterion("backMoneyReason >", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonGreaterThanOrEqualTo(String value) {
            addCriterion("backMoneyReason >=", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonLessThan(String value) {
            addCriterion("backMoneyReason <", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonLessThanOrEqualTo(String value) {
            addCriterion("backMoneyReason <=", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonLike(String value) {
            addCriterion("backMoneyReason like", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonNotLike(String value) {
            addCriterion("backMoneyReason not like", value, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonIn(List<String> values) {
            addCriterion("backMoneyReason in", values, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonNotIn(List<String> values) {
            addCriterion("backMoneyReason not in", values, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonBetween(String value1, String value2) {
            addCriterion("backMoneyReason between", value1, value2, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyreasonNotBetween(String value1, String value2) {
            addCriterion("backMoneyReason not between", value1, value2, "backmoneyreason");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainIsNull() {
            addCriterion("backMoneyExplain is null");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainIsNotNull() {
            addCriterion("backMoneyExplain is not null");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainEqualTo(String value) {
            addCriterion("backMoneyExplain =", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainNotEqualTo(String value) {
            addCriterion("backMoneyExplain <>", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainGreaterThan(String value) {
            addCriterion("backMoneyExplain >", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainGreaterThanOrEqualTo(String value) {
            addCriterion("backMoneyExplain >=", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainLessThan(String value) {
            addCriterion("backMoneyExplain <", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainLessThanOrEqualTo(String value) {
            addCriterion("backMoneyExplain <=", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainLike(String value) {
            addCriterion("backMoneyExplain like", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainNotLike(String value) {
            addCriterion("backMoneyExplain not like", value, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainIn(List<String> values) {
            addCriterion("backMoneyExplain in", values, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainNotIn(List<String> values) {
            addCriterion("backMoneyExplain not in", values, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainBetween(String value1, String value2) {
            addCriterion("backMoneyExplain between", value1, value2, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneyexplainNotBetween(String value1, String value2) {
            addCriterion("backMoneyExplain not between", value1, value2, "backmoneyexplain");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusIsNull() {
            addCriterion("backMoneyStatus is null");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusIsNotNull() {
            addCriterion("backMoneyStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusEqualTo(String value) {
            addCriterion("backMoneyStatus =", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusNotEqualTo(String value) {
            addCriterion("backMoneyStatus <>", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusGreaterThan(String value) {
            addCriterion("backMoneyStatus >", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusGreaterThanOrEqualTo(String value) {
            addCriterion("backMoneyStatus >=", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusLessThan(String value) {
            addCriterion("backMoneyStatus <", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusLessThanOrEqualTo(String value) {
            addCriterion("backMoneyStatus <=", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusLike(String value) {
            addCriterion("backMoneyStatus like", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusNotLike(String value) {
            addCriterion("backMoneyStatus not like", value, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusIn(List<String> values) {
            addCriterion("backMoneyStatus in", values, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusNotIn(List<String> values) {
            addCriterion("backMoneyStatus not in", values, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusBetween(String value1, String value2) {
            addCriterion("backMoneyStatus between", value1, value2, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andBackmoneystatusNotBetween(String value1, String value2) {
            addCriterion("backMoneyStatus not between", value1, value2, "backmoneystatus");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Long value) {
            addCriterion("productId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Long value) {
            addCriterion("productId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Long value) {
            addCriterion("productId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Long value) {
            addCriterion("productId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Long value) {
            addCriterion("productId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Long value) {
            addCriterion("productId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Long> values) {
            addCriterion("productId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Long> values) {
            addCriterion("productId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Long value1, Long value2) {
            addCriterion("productId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Long value1, Long value2) {
            addCriterion("productId not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNull() {
            addCriterion("storeId is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(Long value) {
            addCriterion("storeId =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(Long value) {
            addCriterion("storeId <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(Long value) {
            addCriterion("storeId >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(Long value) {
            addCriterion("storeId >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(Long value) {
            addCriterion("storeId <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(Long value) {
            addCriterion("storeId <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<Long> values) {
            addCriterion("storeId in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<Long> values) {
            addCriterion("storeId not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(Long value1, Long value2) {
            addCriterion("storeId between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(Long value1, Long value2) {
            addCriterion("storeId not between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bId is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bId is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Long value) {
            addCriterion("bId =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Long value) {
            addCriterion("bId <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Long value) {
            addCriterion("bId >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Long value) {
            addCriterion("bId >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Long value) {
            addCriterion("bId <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Long value) {
            addCriterion("bId <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Long> values) {
            addCriterion("bId in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Long> values) {
            addCriterion("bId not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Long value1, Long value2) {
            addCriterion("bId between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Long value1, Long value2) {
            addCriterion("bId not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bName is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bName is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bName =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bName <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bName >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bName >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bName <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bName <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bName like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bName not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bName in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bName not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bName between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bName not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andShipmethodIsNull() {
            addCriterion("shipMethod is null");
            return (Criteria) this;
        }

        public Criteria andShipmethodIsNotNull() {
            addCriterion("shipMethod is not null");
            return (Criteria) this;
        }

        public Criteria andShipmethodEqualTo(String value) {
            addCriterion("shipMethod =", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodNotEqualTo(String value) {
            addCriterion("shipMethod <>", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodGreaterThan(String value) {
            addCriterion("shipMethod >", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodGreaterThanOrEqualTo(String value) {
            addCriterion("shipMethod >=", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodLessThan(String value) {
            addCriterion("shipMethod <", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodLessThanOrEqualTo(String value) {
            addCriterion("shipMethod <=", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodLike(String value) {
            addCriterion("shipMethod like", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodNotLike(String value) {
            addCriterion("shipMethod not like", value, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodIn(List<String> values) {
            addCriterion("shipMethod in", values, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodNotIn(List<String> values) {
            addCriterion("shipMethod not in", values, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodBetween(String value1, String value2) {
            addCriterion("shipMethod between", value1, value2, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipmethodNotBetween(String value1, String value2) {
            addCriterion("shipMethod not between", value1, value2, "shipmethod");
            return (Criteria) this;
        }

        public Criteria andShipfeeIsNull() {
            addCriterion("shipFee is null");
            return (Criteria) this;
        }

        public Criteria andShipfeeIsNotNull() {
            addCriterion("shipFee is not null");
            return (Criteria) this;
        }

        public Criteria andShipfeeEqualTo(Double value) {
            addCriterion("shipFee =", value, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeNotEqualTo(Double value) {
            addCriterion("shipFee <>", value, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeGreaterThan(Double value) {
            addCriterion("shipFee >", value, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeGreaterThanOrEqualTo(Double value) {
            addCriterion("shipFee >=", value, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeLessThan(Double value) {
            addCriterion("shipFee <", value, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeLessThanOrEqualTo(Double value) {
            addCriterion("shipFee <=", value, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeIn(List<Double> values) {
            addCriterion("shipFee in", values, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeNotIn(List<Double> values) {
            addCriterion("shipFee not in", values, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeBetween(Double value1, Double value2) {
            addCriterion("shipFee between", value1, value2, "shipfee");
            return (Criteria) this;
        }

        public Criteria andShipfeeNotBetween(Double value1, Double value2) {
            addCriterion("shipFee not between", value1, value2, "shipfee");
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