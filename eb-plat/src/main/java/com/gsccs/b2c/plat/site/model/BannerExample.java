package com.gsccs.b2c.plat.site.model;

import java.util.ArrayList;
import java.util.List;

public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
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

        public Criteria andMaingraphIsNull() {
            addCriterion("maingraph is null");
            return (Criteria) this;
        }

        public Criteria andMaingraphIsNotNull() {
            addCriterion("maingraph is not null");
            return (Criteria) this;
        }

        public Criteria andMaingraphEqualTo(String value) {
            addCriterion("maingraph =", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphNotEqualTo(String value) {
            addCriterion("maingraph <>", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphGreaterThan(String value) {
            addCriterion("maingraph >", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphGreaterThanOrEqualTo(String value) {
            addCriterion("maingraph >=", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphLessThan(String value) {
            addCriterion("maingraph <", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphLessThanOrEqualTo(String value) {
            addCriterion("maingraph <=", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphLike(String value) {
            addCriterion("maingraph like", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphNotLike(String value) {
            addCriterion("maingraph not like", value, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphIn(List<String> values) {
            addCriterion("maingraph in", values, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphNotIn(List<String> values) {
            addCriterion("maingraph not in", values, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphBetween(String value1, String value2) {
            addCriterion("maingraph between", value1, value2, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphNotBetween(String value1, String value2) {
            addCriterion("maingraph not between", value1, value2, "maingraph");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineIsNull() {
            addCriterion("maingraphline is null");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineIsNotNull() {
            addCriterion("maingraphline is not null");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineEqualTo(String value) {
            addCriterion("maingraphline =", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineNotEqualTo(String value) {
            addCriterion("maingraphline <>", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineGreaterThan(String value) {
            addCriterion("maingraphline >", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineGreaterThanOrEqualTo(String value) {
            addCriterion("maingraphline >=", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineLessThan(String value) {
            addCriterion("maingraphline <", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineLessThanOrEqualTo(String value) {
            addCriterion("maingraphline <=", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineLike(String value) {
            addCriterion("maingraphline like", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineNotLike(String value) {
            addCriterion("maingraphline not like", value, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineIn(List<String> values) {
            addCriterion("maingraphline in", values, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineNotIn(List<String> values) {
            addCriterion("maingraphline not in", values, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineBetween(String value1, String value2) {
            addCriterion("maingraphline between", value1, value2, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andMaingraphlineNotBetween(String value1, String value2) {
            addCriterion("maingraphline not between", value1, value2, "maingraphline");
            return (Criteria) this;
        }

        public Criteria andSubgraph1IsNull() {
            addCriterion("subgraph1 is null");
            return (Criteria) this;
        }

        public Criteria andSubgraph1IsNotNull() {
            addCriterion("subgraph1 is not null");
            return (Criteria) this;
        }

        public Criteria andSubgraph1EqualTo(String value) {
            addCriterion("subgraph1 =", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1NotEqualTo(String value) {
            addCriterion("subgraph1 <>", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1GreaterThan(String value) {
            addCriterion("subgraph1 >", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1GreaterThanOrEqualTo(String value) {
            addCriterion("subgraph1 >=", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1LessThan(String value) {
            addCriterion("subgraph1 <", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1LessThanOrEqualTo(String value) {
            addCriterion("subgraph1 <=", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1Like(String value) {
            addCriterion("subgraph1 like", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1NotLike(String value) {
            addCriterion("subgraph1 not like", value, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1In(List<String> values) {
            addCriterion("subgraph1 in", values, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1NotIn(List<String> values) {
            addCriterion("subgraph1 not in", values, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1Between(String value1, String value2) {
            addCriterion("subgraph1 between", value1, value2, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph1NotBetween(String value1, String value2) {
            addCriterion("subgraph1 not between", value1, value2, "subgraph1");
            return (Criteria) this;
        }

        public Criteria andSubgraph2IsNull() {
            addCriterion("subgraph2 is null");
            return (Criteria) this;
        }

        public Criteria andSubgraph2IsNotNull() {
            addCriterion("subgraph2 is not null");
            return (Criteria) this;
        }

        public Criteria andSubgraph2EqualTo(String value) {
            addCriterion("subgraph2 =", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2NotEqualTo(String value) {
            addCriterion("subgraph2 <>", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2GreaterThan(String value) {
            addCriterion("subgraph2 >", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2GreaterThanOrEqualTo(String value) {
            addCriterion("subgraph2 >=", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2LessThan(String value) {
            addCriterion("subgraph2 <", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2LessThanOrEqualTo(String value) {
            addCriterion("subgraph2 <=", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2Like(String value) {
            addCriterion("subgraph2 like", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2NotLike(String value) {
            addCriterion("subgraph2 not like", value, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2In(List<String> values) {
            addCriterion("subgraph2 in", values, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2NotIn(List<String> values) {
            addCriterion("subgraph2 not in", values, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2Between(String value1, String value2) {
            addCriterion("subgraph2 between", value1, value2, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraph2NotBetween(String value1, String value2) {
            addCriterion("subgraph2 not between", value1, value2, "subgraph2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1IsNull() {
            addCriterion("subgraphline1 is null");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1IsNotNull() {
            addCriterion("subgraphline1 is not null");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1EqualTo(String value) {
            addCriterion("subgraphline1 =", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1NotEqualTo(String value) {
            addCriterion("subgraphline1 <>", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1GreaterThan(String value) {
            addCriterion("subgraphline1 >", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1GreaterThanOrEqualTo(String value) {
            addCriterion("subgraphline1 >=", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1LessThan(String value) {
            addCriterion("subgraphline1 <", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1LessThanOrEqualTo(String value) {
            addCriterion("subgraphline1 <=", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1Like(String value) {
            addCriterion("subgraphline1 like", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1NotLike(String value) {
            addCriterion("subgraphline1 not like", value, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1In(List<String> values) {
            addCriterion("subgraphline1 in", values, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1NotIn(List<String> values) {
            addCriterion("subgraphline1 not in", values, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1Between(String value1, String value2) {
            addCriterion("subgraphline1 between", value1, value2, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline1NotBetween(String value1, String value2) {
            addCriterion("subgraphline1 not between", value1, value2, "subgraphline1");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2IsNull() {
            addCriterion("subgraphline2 is null");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2IsNotNull() {
            addCriterion("subgraphline2 is not null");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2EqualTo(String value) {
            addCriterion("subgraphline2 =", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2NotEqualTo(String value) {
            addCriterion("subgraphline2 <>", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2GreaterThan(String value) {
            addCriterion("subgraphline2 >", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2GreaterThanOrEqualTo(String value) {
            addCriterion("subgraphline2 >=", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2LessThan(String value) {
            addCriterion("subgraphline2 <", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2LessThanOrEqualTo(String value) {
            addCriterion("subgraphline2 <=", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2Like(String value) {
            addCriterion("subgraphline2 like", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2NotLike(String value) {
            addCriterion("subgraphline2 not like", value, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2In(List<String> values) {
            addCriterion("subgraphline2 in", values, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2NotIn(List<String> values) {
            addCriterion("subgraphline2 not in", values, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2Between(String value1, String value2) {
            addCriterion("subgraphline2 between", value1, value2, "subgraphline2");
            return (Criteria) this;
        }

        public Criteria andSubgraphline2NotBetween(String value1, String value2) {
            addCriterion("subgraphline2 not between", value1, value2, "subgraphline2");
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