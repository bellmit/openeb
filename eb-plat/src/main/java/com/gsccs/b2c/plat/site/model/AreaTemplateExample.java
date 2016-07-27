package com.gsccs.b2c.plat.site.model;

import java.util.ArrayList;
import java.util.List;

public class AreaTemplateExample {
	
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public AreaTemplateExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressIsNull() {
            addCriterion("dispatchingAddress is null");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressIsNotNull() {
            addCriterion("dispatchingAddress is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressEqualTo(String value) {
            addCriterion("dispatchingAddress =", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressNotEqualTo(String value) {
            addCriterion("dispatchingAddress <>", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressGreaterThan(String value) {
            addCriterion("dispatchingAddress >", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressGreaterThanOrEqualTo(String value) {
            addCriterion("dispatchingAddress >=", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressLessThan(String value) {
            addCriterion("dispatchingAddress <", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressLessThanOrEqualTo(String value) {
            addCriterion("dispatchingAddress <=", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressLike(String value) {
            addCriterion("dispatchingAddress like", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressNotLike(String value) {
            addCriterion("dispatchingAddress not like", value, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressIn(List<String> values) {
            addCriterion("dispatchingAddress in", values, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressNotIn(List<String> values) {
            addCriterion("dispatchingAddress not in", values, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressBetween(String value1, String value2) {
            addCriterion("dispatchingAddress between", value1, value2, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andDispatchingaddressNotBetween(String value1, String value2) {
            addCriterion("dispatchingAddress not between", value1, value2, "dispatchingaddress");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostIsNull() {
            addCriterion("firstweightcost is null");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostIsNotNull() {
            addCriterion("firstweightcost is not null");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostEqualTo(Double value) {
            addCriterion("firstweightcost =", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostNotEqualTo(Double value) {
            addCriterion("firstweightcost <>", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostGreaterThan(Double value) {
            addCriterion("firstweightcost >", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostGreaterThanOrEqualTo(Double value) {
            addCriterion("firstweightcost >=", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostLessThan(Double value) {
            addCriterion("firstweightcost <", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostLessThanOrEqualTo(Double value) {
            addCriterion("firstweightcost <=", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostIn(List<Double> values) {
            addCriterion("firstweightcost in", values, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostNotIn(List<Double> values) {
            addCriterion("firstweightcost not in", values, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostBetween(Double value1, Double value2) {
            addCriterion("firstweightcost between", value1, value2, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostNotBetween(Double value1, Double value2) {
            addCriterion("firstweightcost not between", value1, value2, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostIsNull() {
            addCriterion("plusweightcost is null");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostIsNotNull() {
            addCriterion("plusweightcost is not null");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostEqualTo(Double value) {
            addCriterion("plusweightcost =", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostNotEqualTo(Double value) {
            addCriterion("plusweightcost <>", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostGreaterThan(Double value) {
            addCriterion("plusweightcost >", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostGreaterThanOrEqualTo(Double value) {
            addCriterion("plusweightcost >=", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostLessThan(Double value) {
            addCriterion("plusweightcost <", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostLessThanOrEqualTo(Double value) {
            addCriterion("plusweightcost <=", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostIn(List<Double> values) {
            addCriterion("plusweightcost in", values, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostNotIn(List<Double> values) {
            addCriterion("plusweightcost not in", values, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostBetween(Double value1, Double value2) {
            addCriterion("plusweightcost between", value1, value2, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostNotBetween(Double value1, Double value2) {
            addCriterion("plusweightcost not between", value1, value2, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidIsNull() {
            addCriterion("becomeTemplateId is null");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidIsNotNull() {
            addCriterion("becomeTemplateId is not null");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidEqualTo(Integer value) {
            addCriterion("becomeTemplateId =", value, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidNotEqualTo(Integer value) {
            addCriterion("becomeTemplateId <>", value, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidGreaterThan(Integer value) {
            addCriterion("becomeTemplateId >", value, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("becomeTemplateId >=", value, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidLessThan(Integer value) {
            addCriterion("becomeTemplateId <", value, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidLessThanOrEqualTo(Integer value) {
            addCriterion("becomeTemplateId <=", value, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidIn(List<Integer> values) {
            addCriterion("becomeTemplateId in", values, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidNotIn(List<Integer> values) {
            addCriterion("becomeTemplateId not in", values, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidBetween(Integer value1, Integer value2) {
            addCriterion("becomeTemplateId between", value1, value2, "becometemplateid");
            return (Criteria) this;
        }

        public Criteria andBecometemplateidNotBetween(Integer value1, Integer value2) {
            addCriterion("becomeTemplateId not between", value1, value2, "becometemplateid");
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