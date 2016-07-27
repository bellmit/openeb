package com.gsccs.b2c.plat.shop.model;

import java.util.ArrayList;
import java.util.List;

import com.gsccs.b2c.plat.bass.BaseExample;

public class StoreTExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreTExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andSitepathIsNull() {
            addCriterion("sitepath is null");
            return (Criteria) this;
        }

        public Criteria andSitepathIsNotNull() {
            addCriterion("sitepath is not null");
            return (Criteria) this;
        }

        public Criteria andSitepathEqualTo(String value) {
            addCriterion("sitepath =", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathNotEqualTo(String value) {
            addCriterion("sitepath <>", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathGreaterThan(String value) {
            addCriterion("sitepath >", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathGreaterThanOrEqualTo(String value) {
            addCriterion("sitepath >=", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathLessThan(String value) {
            addCriterion("sitepath <", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathLessThanOrEqualTo(String value) {
            addCriterion("sitepath <=", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathLike(String value) {
            addCriterion("sitepath like", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathNotLike(String value) {
            addCriterion("sitepath not like", value, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathIn(List<String> values) {
            addCriterion("sitepath in", values, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathNotIn(List<String> values) {
            addCriterion("sitepath not in", values, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathBetween(String value1, String value2) {
            addCriterion("sitepath between", value1, value2, "sitepath");
            return (Criteria) this;
        }

        public Criteria andSitepathNotBetween(String value1, String value2) {
            addCriterion("sitepath not between", value1, value2, "sitepath");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerIsNull() {
            addCriterion("alipaypartner is null");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerIsNotNull() {
            addCriterion("alipaypartner is not null");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerEqualTo(String value) {
            addCriterion("alipaypartner =", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerNotEqualTo(String value) {
            addCriterion("alipaypartner <>", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerGreaterThan(String value) {
            addCriterion("alipaypartner >", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerGreaterThanOrEqualTo(String value) {
            addCriterion("alipaypartner >=", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerLessThan(String value) {
            addCriterion("alipaypartner <", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerLessThanOrEqualTo(String value) {
            addCriterion("alipaypartner <=", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerLike(String value) {
            addCriterion("alipaypartner like", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerNotLike(String value) {
            addCriterion("alipaypartner not like", value, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerIn(List<String> values) {
            addCriterion("alipaypartner in", values, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerNotIn(List<String> values) {
            addCriterion("alipaypartner not in", values, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerBetween(String value1, String value2) {
            addCriterion("alipaypartner between", value1, value2, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaypartnerNotBetween(String value1, String value2) {
            addCriterion("alipaypartner not between", value1, value2, "alipaypartner");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyIsNull() {
            addCriterion("alipaykey is null");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyIsNotNull() {
            addCriterion("alipaykey is not null");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyEqualTo(String value) {
            addCriterion("alipaykey =", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyNotEqualTo(String value) {
            addCriterion("alipaykey <>", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyGreaterThan(String value) {
            addCriterion("alipaykey >", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyGreaterThanOrEqualTo(String value) {
            addCriterion("alipaykey >=", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyLessThan(String value) {
            addCriterion("alipaykey <", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyLessThanOrEqualTo(String value) {
            addCriterion("alipaykey <=", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyLike(String value) {
            addCriterion("alipaykey like", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyNotLike(String value) {
            addCriterion("alipaykey not like", value, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyIn(List<String> values) {
            addCriterion("alipaykey in", values, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyNotIn(List<String> values) {
            addCriterion("alipaykey not in", values, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyBetween(String value1, String value2) {
            addCriterion("alipaykey between", value1, value2, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andAlipaykeyNotBetween(String value1, String value2) {
            addCriterion("alipaykey not between", value1, value2, "alipaykey");
            return (Criteria) this;
        }

        public Criteria andStockalertnumIsNull() {
            addCriterion("stockalertnum is null");
            return (Criteria) this;
        }

        public Criteria andStockalertnumIsNotNull() {
            addCriterion("stockalertnum is not null");
            return (Criteria) this;
        }

        public Criteria andStockalertnumEqualTo(Integer value) {
            addCriterion("stockalertnum =", value, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumNotEqualTo(Integer value) {
            addCriterion("stockalertnum <>", value, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumGreaterThan(Integer value) {
            addCriterion("stockalertnum >", value, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockalertnum >=", value, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumLessThan(Integer value) {
            addCriterion("stockalertnum <", value, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumLessThanOrEqualTo(Integer value) {
            addCriterion("stockalertnum <=", value, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumIn(List<Integer> values) {
            addCriterion("stockalertnum in", values, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumNotIn(List<Integer> values) {
            addCriterion("stockalertnum not in", values, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumBetween(Integer value1, Integer value2) {
            addCriterion("stockalertnum between", value1, value2, "stockalertnum");
            return (Criteria) this;
        }

        public Criteria andStockalertnumNotBetween(Integer value1, Integer value2) {
            addCriterion("stockalertnum not between", value1, value2, "stockalertnum");
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