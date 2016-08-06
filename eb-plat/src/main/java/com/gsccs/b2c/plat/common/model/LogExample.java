package com.gsccs.b2c.plat.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @说明 TODO
 * @年月日 2015年4月10日
 * @时分秒 下午4:28:01
 */
public class LogExample {
	
	
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andBroswerIsNull() {
            addCriterion("broswer is null");
            return (Criteria) this;
        }

        public Criteria andBroswerIsNotNull() {
            addCriterion("broswer is not null");
            return (Criteria) this;
        }

        public Criteria andBroswerEqualTo(String value) {
            addCriterion("broswer =", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotEqualTo(String value) {
            addCriterion("broswer <>", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerGreaterThan(String value) {
            addCriterion("broswer >", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerGreaterThanOrEqualTo(String value) {
            addCriterion("broswer >=", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLessThan(String value) {
            addCriterion("broswer <", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLessThanOrEqualTo(String value) {
            addCriterion("broswer <=", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLike(String value) {
            addCriterion("broswer like", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotLike(String value) {
            addCriterion("broswer not like", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerIn(List<String> values) {
            addCriterion("broswer in", values, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotIn(List<String> values) {
            addCriterion("broswer not in", values, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerBetween(String value1, String value2) {
            addCriterion("broswer between", value1, value2, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotBetween(String value1, String value2) {
            addCriterion("broswer not between", value1, value2, "broswer");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNull() {
            addCriterion("logcontent is null");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNotNull() {
            addCriterion("logcontent is not null");
            return (Criteria) this;
        }

        public Criteria andLogcontentEqualTo(String value) {
            addCriterion("logcontent =", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotEqualTo(String value) {
            addCriterion("logcontent <>", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThan(String value) {
            addCriterion("logcontent >", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThanOrEqualTo(String value) {
            addCriterion("logcontent >=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThan(String value) {
            addCriterion("logcontent <", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThanOrEqualTo(String value) {
            addCriterion("logcontent <=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLike(String value) {
            addCriterion("logcontent like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotLike(String value) {
            addCriterion("logcontent not like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentIn(List<String> values) {
            addCriterion("logcontent in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotIn(List<String> values) {
            addCriterion("logcontent not in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentBetween(String value1, String value2) {
            addCriterion("logcontent between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotBetween(String value1, String value2) {
            addCriterion("logcontent not between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andIpnoteIsNull() {
            addCriterion("ipnote is null");
            return (Criteria) this;
        }

        public Criteria andIpnoteIsNotNull() {
            addCriterion("ipnote is not null");
            return (Criteria) this;
        }

        public Criteria andIpnoteEqualTo(String value) {
            addCriterion("ipnote =", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteNotEqualTo(String value) {
            addCriterion("ipnote <>", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteGreaterThan(String value) {
            addCriterion("ipnote >", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteGreaterThanOrEqualTo(String value) {
            addCriterion("ipnote >=", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteLessThan(String value) {
            addCriterion("ipnote <", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteLessThanOrEqualTo(String value) {
            addCriterion("ipnote <=", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteLike(String value) {
            addCriterion("ipnote like", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteNotLike(String value) {
            addCriterion("ipnote not like", value, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteIn(List<String> values) {
            addCriterion("ipnote in", values, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteNotIn(List<String> values) {
            addCriterion("ipnote not in", values, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteBetween(String value1, String value2) {
            addCriterion("ipnote between", value1, value2, "ipnote");
            return (Criteria) this;
        }

        public Criteria andIpnoteNotBetween(String value1, String value2) {
            addCriterion("ipnote not between", value1, value2, "ipnote");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNull() {
            addCriterion("operatetime is null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNotNull() {
            addCriterion("operatetime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeEqualTo(Date value) {
            addCriterion("operatetime =", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotEqualTo(Date value) {
            addCriterion("operatetime <>", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThan(Date value) {
            addCriterion("operatetime >", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatetime >=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThan(Date value) {
            addCriterion("operatetime <", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThanOrEqualTo(Date value) {
            addCriterion("operatetime <=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIn(List<Date> values) {
            addCriterion("operatetime in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotIn(List<Date> values) {
            addCriterion("operatetime not in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeBetween(Date value1, Date value2) {
            addCriterion("operatetime between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotBetween(Date value1, Date value2) {
            addCriterion("operatetime not between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNull() {
            addCriterion("accountid is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("accountid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(String value) {
            addCriterion("accountid =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(String value) {
            addCriterion("accountid <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(String value) {
            addCriterion("accountid >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(String value) {
            addCriterion("accountid >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(String value) {
            addCriterion("accountid <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(String value) {
            addCriterion("accountid <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLike(String value) {
            addCriterion("accountid like", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotLike(String value) {
            addCriterion("accountid not like", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<String> values) {
            addCriterion("accountid in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<String> values) {
            addCriterion("accountid not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(String value1, String value2) {
            addCriterion("accountid between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(String value1, String value2) {
            addCriterion("accountid not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andLoglevelIsNull() {
            addCriterion("loglevel is null");
            return (Criteria) this;
        }

        public Criteria andLoglevelIsNotNull() {
            addCriterion("loglevel is not null");
            return (Criteria) this;
        }

        public Criteria andLoglevelEqualTo(String value) {
            addCriterion("loglevel =", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotEqualTo(String value) {
            addCriterion("loglevel <>", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelGreaterThan(String value) {
            addCriterion("loglevel >", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelGreaterThanOrEqualTo(String value) {
            addCriterion("loglevel >=", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLessThan(String value) {
            addCriterion("loglevel <", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLessThanOrEqualTo(String value) {
            addCriterion("loglevel <=", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLike(String value) {
            addCriterion("loglevel like", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotLike(String value) {
            addCriterion("loglevel not like", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelIn(List<String> values) {
            addCriterion("loglevel in", values, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotIn(List<String> values) {
            addCriterion("loglevel not in", values, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelBetween(String value1, String value2) {
            addCriterion("loglevel between", value1, value2, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotBetween(String value1, String value2) {
            addCriterion("loglevel not between", value1, value2, "loglevel");
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