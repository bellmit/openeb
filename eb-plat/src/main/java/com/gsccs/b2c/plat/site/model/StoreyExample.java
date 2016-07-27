package com.gsccs.b2c.plat.site.model;

import java.util.ArrayList;
import java.util.List;

public class StoreyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreyExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitlelineIsNull() {
            addCriterion("titleLine is null");
            return (Criteria) this;
        }

        public Criteria andTitlelineIsNotNull() {
            addCriterion("titleLine is not null");
            return (Criteria) this;
        }

        public Criteria andTitlelineEqualTo(String value) {
            addCriterion("titleLine =", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineNotEqualTo(String value) {
            addCriterion("titleLine <>", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineGreaterThan(String value) {
            addCriterion("titleLine >", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineGreaterThanOrEqualTo(String value) {
            addCriterion("titleLine >=", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineLessThan(String value) {
            addCriterion("titleLine <", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineLessThanOrEqualTo(String value) {
            addCriterion("titleLine <=", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineLike(String value) {
            addCriterion("titleLine like", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineNotLike(String value) {
            addCriterion("titleLine not like", value, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineIn(List<String> values) {
            addCriterion("titleLine in", values, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineNotIn(List<String> values) {
            addCriterion("titleLine not in", values, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineBetween(String value1, String value2) {
            addCriterion("titleLine between", value1, value2, "titleline");
            return (Criteria) this;
        }

        public Criteria andTitlelineNotBetween(String value1, String value2) {
            addCriterion("titleLine not between", value1, value2, "titleline");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andBgcolorIsNull() {
            addCriterion("bgColor is null");
            return (Criteria) this;
        }

        public Criteria andBgcolorIsNotNull() {
            addCriterion("bgColor is not null");
            return (Criteria) this;
        }

        public Criteria andBgcolorEqualTo(String value) {
            addCriterion("bgColor =", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotEqualTo(String value) {
            addCriterion("bgColor <>", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorGreaterThan(String value) {
            addCriterion("bgColor >", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorGreaterThanOrEqualTo(String value) {
            addCriterion("bgColor >=", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorLessThan(String value) {
            addCriterion("bgColor <", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorLessThanOrEqualTo(String value) {
            addCriterion("bgColor <=", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorLike(String value) {
            addCriterion("bgColor like", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotLike(String value) {
            addCriterion("bgColor not like", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorIn(List<String> values) {
            addCriterion("bgColor in", values, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotIn(List<String> values) {
            addCriterion("bgColor not in", values, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorBetween(String value1, String value2) {
            addCriterion("bgColor between", value1, value2, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotBetween(String value1, String value2) {
            addCriterion("bgColor not between", value1, value2, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andText1IsNull() {
            addCriterion("text1 is null");
            return (Criteria) this;
        }

        public Criteria andText1IsNotNull() {
            addCriterion("text1 is not null");
            return (Criteria) this;
        }

        public Criteria andText1EqualTo(String value) {
            addCriterion("text1 =", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1NotEqualTo(String value) {
            addCriterion("text1 <>", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1GreaterThan(String value) {
            addCriterion("text1 >", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1GreaterThanOrEqualTo(String value) {
            addCriterion("text1 >=", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1LessThan(String value) {
            addCriterion("text1 <", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1LessThanOrEqualTo(String value) {
            addCriterion("text1 <=", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1Like(String value) {
            addCriterion("text1 like", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1NotLike(String value) {
            addCriterion("text1 not like", value, "text1");
            return (Criteria) this;
        }

        public Criteria andText1In(List<String> values) {
            addCriterion("text1 in", values, "text1");
            return (Criteria) this;
        }

        public Criteria andText1NotIn(List<String> values) {
            addCriterion("text1 not in", values, "text1");
            return (Criteria) this;
        }

        public Criteria andText1Between(String value1, String value2) {
            addCriterion("text1 between", value1, value2, "text1");
            return (Criteria) this;
        }

        public Criteria andText1NotBetween(String value1, String value2) {
            addCriterion("text1 not between", value1, value2, "text1");
            return (Criteria) this;
        }

        public Criteria andText2IsNull() {
            addCriterion("text2 is null");
            return (Criteria) this;
        }

        public Criteria andText2IsNotNull() {
            addCriterion("text2 is not null");
            return (Criteria) this;
        }

        public Criteria andText2EqualTo(String value) {
            addCriterion("text2 =", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotEqualTo(String value) {
            addCriterion("text2 <>", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2GreaterThan(String value) {
            addCriterion("text2 >", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2GreaterThanOrEqualTo(String value) {
            addCriterion("text2 >=", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2LessThan(String value) {
            addCriterion("text2 <", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2LessThanOrEqualTo(String value) {
            addCriterion("text2 <=", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2Like(String value) {
            addCriterion("text2 like", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotLike(String value) {
            addCriterion("text2 not like", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2In(List<String> values) {
            addCriterion("text2 in", values, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotIn(List<String> values) {
            addCriterion("text2 not in", values, "text2");
            return (Criteria) this;
        }

        public Criteria andText2Between(String value1, String value2) {
            addCriterion("text2 between", value1, value2, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotBetween(String value1, String value2) {
            addCriterion("text2 not between", value1, value2, "text2");
            return (Criteria) this;
        }

        public Criteria andText3IsNull() {
            addCriterion("text3 is null");
            return (Criteria) this;
        }

        public Criteria andText3IsNotNull() {
            addCriterion("text3 is not null");
            return (Criteria) this;
        }

        public Criteria andText3EqualTo(String value) {
            addCriterion("text3 =", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3NotEqualTo(String value) {
            addCriterion("text3 <>", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3GreaterThan(String value) {
            addCriterion("text3 >", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3GreaterThanOrEqualTo(String value) {
            addCriterion("text3 >=", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3LessThan(String value) {
            addCriterion("text3 <", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3LessThanOrEqualTo(String value) {
            addCriterion("text3 <=", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3Like(String value) {
            addCriterion("text3 like", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3NotLike(String value) {
            addCriterion("text3 not like", value, "text3");
            return (Criteria) this;
        }

        public Criteria andText3In(List<String> values) {
            addCriterion("text3 in", values, "text3");
            return (Criteria) this;
        }

        public Criteria andText3NotIn(List<String> values) {
            addCriterion("text3 not in", values, "text3");
            return (Criteria) this;
        }

        public Criteria andText3Between(String value1, String value2) {
            addCriterion("text3 between", value1, value2, "text3");
            return (Criteria) this;
        }

        public Criteria andText3NotBetween(String value1, String value2) {
            addCriterion("text3 not between", value1, value2, "text3");
            return (Criteria) this;
        }

        public Criteria andText4IsNull() {
            addCriterion("text4 is null");
            return (Criteria) this;
        }

        public Criteria andText4IsNotNull() {
            addCriterion("text4 is not null");
            return (Criteria) this;
        }

        public Criteria andText4EqualTo(String value) {
            addCriterion("text4 =", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4NotEqualTo(String value) {
            addCriterion("text4 <>", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4GreaterThan(String value) {
            addCriterion("text4 >", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4GreaterThanOrEqualTo(String value) {
            addCriterion("text4 >=", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4LessThan(String value) {
            addCriterion("text4 <", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4LessThanOrEqualTo(String value) {
            addCriterion("text4 <=", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4Like(String value) {
            addCriterion("text4 like", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4NotLike(String value) {
            addCriterion("text4 not like", value, "text4");
            return (Criteria) this;
        }

        public Criteria andText4In(List<String> values) {
            addCriterion("text4 in", values, "text4");
            return (Criteria) this;
        }

        public Criteria andText4NotIn(List<String> values) {
            addCriterion("text4 not in", values, "text4");
            return (Criteria) this;
        }

        public Criteria andText4Between(String value1, String value2) {
            addCriterion("text4 between", value1, value2, "text4");
            return (Criteria) this;
        }

        public Criteria andText4NotBetween(String value1, String value2) {
            addCriterion("text4 not between", value1, value2, "text4");
            return (Criteria) this;
        }

        public Criteria andText5IsNull() {
            addCriterion("text5 is null");
            return (Criteria) this;
        }

        public Criteria andText5IsNotNull() {
            addCriterion("text5 is not null");
            return (Criteria) this;
        }

        public Criteria andText5EqualTo(String value) {
            addCriterion("text5 =", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5NotEqualTo(String value) {
            addCriterion("text5 <>", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5GreaterThan(String value) {
            addCriterion("text5 >", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5GreaterThanOrEqualTo(String value) {
            addCriterion("text5 >=", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5LessThan(String value) {
            addCriterion("text5 <", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5LessThanOrEqualTo(String value) {
            addCriterion("text5 <=", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5Like(String value) {
            addCriterion("text5 like", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5NotLike(String value) {
            addCriterion("text5 not like", value, "text5");
            return (Criteria) this;
        }

        public Criteria andText5In(List<String> values) {
            addCriterion("text5 in", values, "text5");
            return (Criteria) this;
        }

        public Criteria andText5NotIn(List<String> values) {
            addCriterion("text5 not in", values, "text5");
            return (Criteria) this;
        }

        public Criteria andText5Between(String value1, String value2) {
            addCriterion("text5 between", value1, value2, "text5");
            return (Criteria) this;
        }

        public Criteria andText5NotBetween(String value1, String value2) {
            addCriterion("text5 not between", value1, value2, "text5");
            return (Criteria) this;
        }

        public Criteria andText6IsNull() {
            addCriterion("text6 is null");
            return (Criteria) this;
        }

        public Criteria andText6IsNotNull() {
            addCriterion("text6 is not null");
            return (Criteria) this;
        }

        public Criteria andText6EqualTo(String value) {
            addCriterion("text6 =", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6NotEqualTo(String value) {
            addCriterion("text6 <>", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6GreaterThan(String value) {
            addCriterion("text6 >", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6GreaterThanOrEqualTo(String value) {
            addCriterion("text6 >=", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6LessThan(String value) {
            addCriterion("text6 <", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6LessThanOrEqualTo(String value) {
            addCriterion("text6 <=", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6Like(String value) {
            addCriterion("text6 like", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6NotLike(String value) {
            addCriterion("text6 not like", value, "text6");
            return (Criteria) this;
        }

        public Criteria andText6In(List<String> values) {
            addCriterion("text6 in", values, "text6");
            return (Criteria) this;
        }

        public Criteria andText6NotIn(List<String> values) {
            addCriterion("text6 not in", values, "text6");
            return (Criteria) this;
        }

        public Criteria andText6Between(String value1, String value2) {
            addCriterion("text6 between", value1, value2, "text6");
            return (Criteria) this;
        }

        public Criteria andText6NotBetween(String value1, String value2) {
            addCriterion("text6 not between", value1, value2, "text6");
            return (Criteria) this;
        }

        public Criteria andTextline1IsNull() {
            addCriterion("textLine1 is null");
            return (Criteria) this;
        }

        public Criteria andTextline1IsNotNull() {
            addCriterion("textLine1 is not null");
            return (Criteria) this;
        }

        public Criteria andTextline1EqualTo(String value) {
            addCriterion("textLine1 =", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1NotEqualTo(String value) {
            addCriterion("textLine1 <>", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1GreaterThan(String value) {
            addCriterion("textLine1 >", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1GreaterThanOrEqualTo(String value) {
            addCriterion("textLine1 >=", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1LessThan(String value) {
            addCriterion("textLine1 <", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1LessThanOrEqualTo(String value) {
            addCriterion("textLine1 <=", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1Like(String value) {
            addCriterion("textLine1 like", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1NotLike(String value) {
            addCriterion("textLine1 not like", value, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1In(List<String> values) {
            addCriterion("textLine1 in", values, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1NotIn(List<String> values) {
            addCriterion("textLine1 not in", values, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1Between(String value1, String value2) {
            addCriterion("textLine1 between", value1, value2, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline1NotBetween(String value1, String value2) {
            addCriterion("textLine1 not between", value1, value2, "textline1");
            return (Criteria) this;
        }

        public Criteria andTextline2IsNull() {
            addCriterion("textLine2 is null");
            return (Criteria) this;
        }

        public Criteria andTextline2IsNotNull() {
            addCriterion("textLine2 is not null");
            return (Criteria) this;
        }

        public Criteria andTextline2EqualTo(String value) {
            addCriterion("textLine2 =", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2NotEqualTo(String value) {
            addCriterion("textLine2 <>", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2GreaterThan(String value) {
            addCriterion("textLine2 >", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2GreaterThanOrEqualTo(String value) {
            addCriterion("textLine2 >=", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2LessThan(String value) {
            addCriterion("textLine2 <", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2LessThanOrEqualTo(String value) {
            addCriterion("textLine2 <=", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2Like(String value) {
            addCriterion("textLine2 like", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2NotLike(String value) {
            addCriterion("textLine2 not like", value, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2In(List<String> values) {
            addCriterion("textLine2 in", values, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2NotIn(List<String> values) {
            addCriterion("textLine2 not in", values, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2Between(String value1, String value2) {
            addCriterion("textLine2 between", value1, value2, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline2NotBetween(String value1, String value2) {
            addCriterion("textLine2 not between", value1, value2, "textline2");
            return (Criteria) this;
        }

        public Criteria andTextline3IsNull() {
            addCriterion("textLine3 is null");
            return (Criteria) this;
        }

        public Criteria andTextline3IsNotNull() {
            addCriterion("textLine3 is not null");
            return (Criteria) this;
        }

        public Criteria andTextline3EqualTo(String value) {
            addCriterion("textLine3 =", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3NotEqualTo(String value) {
            addCriterion("textLine3 <>", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3GreaterThan(String value) {
            addCriterion("textLine3 >", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3GreaterThanOrEqualTo(String value) {
            addCriterion("textLine3 >=", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3LessThan(String value) {
            addCriterion("textLine3 <", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3LessThanOrEqualTo(String value) {
            addCriterion("textLine3 <=", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3Like(String value) {
            addCriterion("textLine3 like", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3NotLike(String value) {
            addCriterion("textLine3 not like", value, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3In(List<String> values) {
            addCriterion("textLine3 in", values, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3NotIn(List<String> values) {
            addCriterion("textLine3 not in", values, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3Between(String value1, String value2) {
            addCriterion("textLine3 between", value1, value2, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline3NotBetween(String value1, String value2) {
            addCriterion("textLine3 not between", value1, value2, "textline3");
            return (Criteria) this;
        }

        public Criteria andTextline4IsNull() {
            addCriterion("textLine4 is null");
            return (Criteria) this;
        }

        public Criteria andTextline4IsNotNull() {
            addCriterion("textLine4 is not null");
            return (Criteria) this;
        }

        public Criteria andTextline4EqualTo(String value) {
            addCriterion("textLine4 =", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4NotEqualTo(String value) {
            addCriterion("textLine4 <>", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4GreaterThan(String value) {
            addCriterion("textLine4 >", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4GreaterThanOrEqualTo(String value) {
            addCriterion("textLine4 >=", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4LessThan(String value) {
            addCriterion("textLine4 <", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4LessThanOrEqualTo(String value) {
            addCriterion("textLine4 <=", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4Like(String value) {
            addCriterion("textLine4 like", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4NotLike(String value) {
            addCriterion("textLine4 not like", value, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4In(List<String> values) {
            addCriterion("textLine4 in", values, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4NotIn(List<String> values) {
            addCriterion("textLine4 not in", values, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4Between(String value1, String value2) {
            addCriterion("textLine4 between", value1, value2, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline4NotBetween(String value1, String value2) {
            addCriterion("textLine4 not between", value1, value2, "textline4");
            return (Criteria) this;
        }

        public Criteria andTextline5IsNull() {
            addCriterion("textLine5 is null");
            return (Criteria) this;
        }

        public Criteria andTextline5IsNotNull() {
            addCriterion("textLine5 is not null");
            return (Criteria) this;
        }

        public Criteria andTextline5EqualTo(String value) {
            addCriterion("textLine5 =", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5NotEqualTo(String value) {
            addCriterion("textLine5 <>", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5GreaterThan(String value) {
            addCriterion("textLine5 >", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5GreaterThanOrEqualTo(String value) {
            addCriterion("textLine5 >=", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5LessThan(String value) {
            addCriterion("textLine5 <", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5LessThanOrEqualTo(String value) {
            addCriterion("textLine5 <=", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5Like(String value) {
            addCriterion("textLine5 like", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5NotLike(String value) {
            addCriterion("textLine5 not like", value, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5In(List<String> values) {
            addCriterion("textLine5 in", values, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5NotIn(List<String> values) {
            addCriterion("textLine5 not in", values, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5Between(String value1, String value2) {
            addCriterion("textLine5 between", value1, value2, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline5NotBetween(String value1, String value2) {
            addCriterion("textLine5 not between", value1, value2, "textline5");
            return (Criteria) this;
        }

        public Criteria andTextline6IsNull() {
            addCriterion("textLine6 is null");
            return (Criteria) this;
        }

        public Criteria andTextline6IsNotNull() {
            addCriterion("textLine6 is not null");
            return (Criteria) this;
        }

        public Criteria andTextline6EqualTo(String value) {
            addCriterion("textLine6 =", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6NotEqualTo(String value) {
            addCriterion("textLine6 <>", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6GreaterThan(String value) {
            addCriterion("textLine6 >", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6GreaterThanOrEqualTo(String value) {
            addCriterion("textLine6 >=", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6LessThan(String value) {
            addCriterion("textLine6 <", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6LessThanOrEqualTo(String value) {
            addCriterion("textLine6 <=", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6Like(String value) {
            addCriterion("textLine6 like", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6NotLike(String value) {
            addCriterion("textLine6 not like", value, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6In(List<String> values) {
            addCriterion("textLine6 in", values, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6NotIn(List<String> values) {
            addCriterion("textLine6 not in", values, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6Between(String value1, String value2) {
            addCriterion("textLine6 between", value1, value2, "textline6");
            return (Criteria) this;
        }

        public Criteria andTextline6NotBetween(String value1, String value2) {
            addCriterion("textLine6 not between", value1, value2, "textline6");
            return (Criteria) this;
        }

        public Criteria andBrand1IsNull() {
            addCriterion("brand1 is null");
            return (Criteria) this;
        }

        public Criteria andBrand1IsNotNull() {
            addCriterion("brand1 is not null");
            return (Criteria) this;
        }

        public Criteria andBrand1EqualTo(String value) {
            addCriterion("brand1 =", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1NotEqualTo(String value) {
            addCriterion("brand1 <>", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1GreaterThan(String value) {
            addCriterion("brand1 >", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1GreaterThanOrEqualTo(String value) {
            addCriterion("brand1 >=", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1LessThan(String value) {
            addCriterion("brand1 <", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1LessThanOrEqualTo(String value) {
            addCriterion("brand1 <=", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1Like(String value) {
            addCriterion("brand1 like", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1NotLike(String value) {
            addCriterion("brand1 not like", value, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1In(List<String> values) {
            addCriterion("brand1 in", values, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1NotIn(List<String> values) {
            addCriterion("brand1 not in", values, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1Between(String value1, String value2) {
            addCriterion("brand1 between", value1, value2, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand1NotBetween(String value1, String value2) {
            addCriterion("brand1 not between", value1, value2, "brand1");
            return (Criteria) this;
        }

        public Criteria andBrand2IsNull() {
            addCriterion("brand2 is null");
            return (Criteria) this;
        }

        public Criteria andBrand2IsNotNull() {
            addCriterion("brand2 is not null");
            return (Criteria) this;
        }

        public Criteria andBrand2EqualTo(String value) {
            addCriterion("brand2 =", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2NotEqualTo(String value) {
            addCriterion("brand2 <>", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2GreaterThan(String value) {
            addCriterion("brand2 >", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2GreaterThanOrEqualTo(String value) {
            addCriterion("brand2 >=", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2LessThan(String value) {
            addCriterion("brand2 <", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2LessThanOrEqualTo(String value) {
            addCriterion("brand2 <=", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2Like(String value) {
            addCriterion("brand2 like", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2NotLike(String value) {
            addCriterion("brand2 not like", value, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2In(List<String> values) {
            addCriterion("brand2 in", values, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2NotIn(List<String> values) {
            addCriterion("brand2 not in", values, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2Between(String value1, String value2) {
            addCriterion("brand2 between", value1, value2, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand2NotBetween(String value1, String value2) {
            addCriterion("brand2 not between", value1, value2, "brand2");
            return (Criteria) this;
        }

        public Criteria andBrand3IsNull() {
            addCriterion("brand3 is null");
            return (Criteria) this;
        }

        public Criteria andBrand3IsNotNull() {
            addCriterion("brand3 is not null");
            return (Criteria) this;
        }

        public Criteria andBrand3EqualTo(String value) {
            addCriterion("brand3 =", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3NotEqualTo(String value) {
            addCriterion("brand3 <>", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3GreaterThan(String value) {
            addCriterion("brand3 >", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3GreaterThanOrEqualTo(String value) {
            addCriterion("brand3 >=", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3LessThan(String value) {
            addCriterion("brand3 <", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3LessThanOrEqualTo(String value) {
            addCriterion("brand3 <=", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3Like(String value) {
            addCriterion("brand3 like", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3NotLike(String value) {
            addCriterion("brand3 not like", value, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3In(List<String> values) {
            addCriterion("brand3 in", values, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3NotIn(List<String> values) {
            addCriterion("brand3 not in", values, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3Between(String value1, String value2) {
            addCriterion("brand3 between", value1, value2, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrand3NotBetween(String value1, String value2) {
            addCriterion("brand3 not between", value1, value2, "brand3");
            return (Criteria) this;
        }

        public Criteria andBrandline1IsNull() {
            addCriterion("brandLine1 is null");
            return (Criteria) this;
        }

        public Criteria andBrandline1IsNotNull() {
            addCriterion("brandLine1 is not null");
            return (Criteria) this;
        }

        public Criteria andBrandline1EqualTo(String value) {
            addCriterion("brandLine1 =", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1NotEqualTo(String value) {
            addCriterion("brandLine1 <>", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1GreaterThan(String value) {
            addCriterion("brandLine1 >", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1GreaterThanOrEqualTo(String value) {
            addCriterion("brandLine1 >=", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1LessThan(String value) {
            addCriterion("brandLine1 <", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1LessThanOrEqualTo(String value) {
            addCriterion("brandLine1 <=", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1Like(String value) {
            addCriterion("brandLine1 like", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1NotLike(String value) {
            addCriterion("brandLine1 not like", value, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1In(List<String> values) {
            addCriterion("brandLine1 in", values, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1NotIn(List<String> values) {
            addCriterion("brandLine1 not in", values, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1Between(String value1, String value2) {
            addCriterion("brandLine1 between", value1, value2, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline1NotBetween(String value1, String value2) {
            addCriterion("brandLine1 not between", value1, value2, "brandline1");
            return (Criteria) this;
        }

        public Criteria andBrandline2IsNull() {
            addCriterion("brandLine2 is null");
            return (Criteria) this;
        }

        public Criteria andBrandline2IsNotNull() {
            addCriterion("brandLine2 is not null");
            return (Criteria) this;
        }

        public Criteria andBrandline2EqualTo(String value) {
            addCriterion("brandLine2 =", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2NotEqualTo(String value) {
            addCriterion("brandLine2 <>", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2GreaterThan(String value) {
            addCriterion("brandLine2 >", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2GreaterThanOrEqualTo(String value) {
            addCriterion("brandLine2 >=", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2LessThan(String value) {
            addCriterion("brandLine2 <", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2LessThanOrEqualTo(String value) {
            addCriterion("brandLine2 <=", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2Like(String value) {
            addCriterion("brandLine2 like", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2NotLike(String value) {
            addCriterion("brandLine2 not like", value, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2In(List<String> values) {
            addCriterion("brandLine2 in", values, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2NotIn(List<String> values) {
            addCriterion("brandLine2 not in", values, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2Between(String value1, String value2) {
            addCriterion("brandLine2 between", value1, value2, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline2NotBetween(String value1, String value2) {
            addCriterion("brandLine2 not between", value1, value2, "brandline2");
            return (Criteria) this;
        }

        public Criteria andBrandline3IsNull() {
            addCriterion("brandLine3 is null");
            return (Criteria) this;
        }

        public Criteria andBrandline3IsNotNull() {
            addCriterion("brandLine3 is not null");
            return (Criteria) this;
        }

        public Criteria andBrandline3EqualTo(String value) {
            addCriterion("brandLine3 =", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3NotEqualTo(String value) {
            addCriterion("brandLine3 <>", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3GreaterThan(String value) {
            addCriterion("brandLine3 >", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3GreaterThanOrEqualTo(String value) {
            addCriterion("brandLine3 >=", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3LessThan(String value) {
            addCriterion("brandLine3 <", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3LessThanOrEqualTo(String value) {
            addCriterion("brandLine3 <=", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3Like(String value) {
            addCriterion("brandLine3 like", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3NotLike(String value) {
            addCriterion("brandLine3 not like", value, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3In(List<String> values) {
            addCriterion("brandLine3 in", values, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3NotIn(List<String> values) {
            addCriterion("brandLine3 not in", values, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3Between(String value1, String value2) {
            addCriterion("brandLine3 between", value1, value2, "brandline3");
            return (Criteria) this;
        }

        public Criteria andBrandline3NotBetween(String value1, String value2) {
            addCriterion("brandLine3 not between", value1, value2, "brandline3");
            return (Criteria) this;
        }

        public Criteria andMainimgIsNull() {
            addCriterion("mainImg is null");
            return (Criteria) this;
        }

        public Criteria andMainimgIsNotNull() {
            addCriterion("mainImg is not null");
            return (Criteria) this;
        }

        public Criteria andMainimgEqualTo(String value) {
            addCriterion("mainImg =", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotEqualTo(String value) {
            addCriterion("mainImg <>", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgGreaterThan(String value) {
            addCriterion("mainImg >", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgGreaterThanOrEqualTo(String value) {
            addCriterion("mainImg >=", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgLessThan(String value) {
            addCriterion("mainImg <", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgLessThanOrEqualTo(String value) {
            addCriterion("mainImg <=", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgLike(String value) {
            addCriterion("mainImg like", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotLike(String value) {
            addCriterion("mainImg not like", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgIn(List<String> values) {
            addCriterion("mainImg in", values, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotIn(List<String> values) {
            addCriterion("mainImg not in", values, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgBetween(String value1, String value2) {
            addCriterion("mainImg between", value1, value2, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotBetween(String value1, String value2) {
            addCriterion("mainImg not between", value1, value2, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimglineIsNull() {
            addCriterion("mainImgLine is null");
            return (Criteria) this;
        }

        public Criteria andMainimglineIsNotNull() {
            addCriterion("mainImgLine is not null");
            return (Criteria) this;
        }

        public Criteria andMainimglineEqualTo(String value) {
            addCriterion("mainImgLine =", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineNotEqualTo(String value) {
            addCriterion("mainImgLine <>", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineGreaterThan(String value) {
            addCriterion("mainImgLine >", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineGreaterThanOrEqualTo(String value) {
            addCriterion("mainImgLine >=", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineLessThan(String value) {
            addCriterion("mainImgLine <", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineLessThanOrEqualTo(String value) {
            addCriterion("mainImgLine <=", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineLike(String value) {
            addCriterion("mainImgLine like", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineNotLike(String value) {
            addCriterion("mainImgLine not like", value, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineIn(List<String> values) {
            addCriterion("mainImgLine in", values, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineNotIn(List<String> values) {
            addCriterion("mainImgLine not in", values, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineBetween(String value1, String value2) {
            addCriterion("mainImgLine between", value1, value2, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andMainimglineNotBetween(String value1, String value2) {
            addCriterion("mainImgLine not between", value1, value2, "mainimgline");
            return (Criteria) this;
        }

        public Criteria andTopimg1IsNull() {
            addCriterion("topImg1 is null");
            return (Criteria) this;
        }

        public Criteria andTopimg1IsNotNull() {
            addCriterion("topImg1 is not null");
            return (Criteria) this;
        }

        public Criteria andTopimg1EqualTo(String value) {
            addCriterion("topImg1 =", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1NotEqualTo(String value) {
            addCriterion("topImg1 <>", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1GreaterThan(String value) {
            addCriterion("topImg1 >", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1GreaterThanOrEqualTo(String value) {
            addCriterion("topImg1 >=", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1LessThan(String value) {
            addCriterion("topImg1 <", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1LessThanOrEqualTo(String value) {
            addCriterion("topImg1 <=", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1Like(String value) {
            addCriterion("topImg1 like", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1NotLike(String value) {
            addCriterion("topImg1 not like", value, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1In(List<String> values) {
            addCriterion("topImg1 in", values, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1NotIn(List<String> values) {
            addCriterion("topImg1 not in", values, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1Between(String value1, String value2) {
            addCriterion("topImg1 between", value1, value2, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg1NotBetween(String value1, String value2) {
            addCriterion("topImg1 not between", value1, value2, "topimg1");
            return (Criteria) this;
        }

        public Criteria andTopimg2IsNull() {
            addCriterion("topImg2 is null");
            return (Criteria) this;
        }

        public Criteria andTopimg2IsNotNull() {
            addCriterion("topImg2 is not null");
            return (Criteria) this;
        }

        public Criteria andTopimg2EqualTo(String value) {
            addCriterion("topImg2 =", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2NotEqualTo(String value) {
            addCriterion("topImg2 <>", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2GreaterThan(String value) {
            addCriterion("topImg2 >", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2GreaterThanOrEqualTo(String value) {
            addCriterion("topImg2 >=", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2LessThan(String value) {
            addCriterion("topImg2 <", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2LessThanOrEqualTo(String value) {
            addCriterion("topImg2 <=", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2Like(String value) {
            addCriterion("topImg2 like", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2NotLike(String value) {
            addCriterion("topImg2 not like", value, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2In(List<String> values) {
            addCriterion("topImg2 in", values, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2NotIn(List<String> values) {
            addCriterion("topImg2 not in", values, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2Between(String value1, String value2) {
            addCriterion("topImg2 between", value1, value2, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg2NotBetween(String value1, String value2) {
            addCriterion("topImg2 not between", value1, value2, "topimg2");
            return (Criteria) this;
        }

        public Criteria andTopimg3IsNull() {
            addCriterion("topImg3 is null");
            return (Criteria) this;
        }

        public Criteria andTopimg3IsNotNull() {
            addCriterion("topImg3 is not null");
            return (Criteria) this;
        }

        public Criteria andTopimg3EqualTo(String value) {
            addCriterion("topImg3 =", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3NotEqualTo(String value) {
            addCriterion("topImg3 <>", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3GreaterThan(String value) {
            addCriterion("topImg3 >", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3GreaterThanOrEqualTo(String value) {
            addCriterion("topImg3 >=", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3LessThan(String value) {
            addCriterion("topImg3 <", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3LessThanOrEqualTo(String value) {
            addCriterion("topImg3 <=", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3Like(String value) {
            addCriterion("topImg3 like", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3NotLike(String value) {
            addCriterion("topImg3 not like", value, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3In(List<String> values) {
            addCriterion("topImg3 in", values, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3NotIn(List<String> values) {
            addCriterion("topImg3 not in", values, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3Between(String value1, String value2) {
            addCriterion("topImg3 between", value1, value2, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimg3NotBetween(String value1, String value2) {
            addCriterion("topImg3 not between", value1, value2, "topimg3");
            return (Criteria) this;
        }

        public Criteria andTopimgline1IsNull() {
            addCriterion("topImgLine1 is null");
            return (Criteria) this;
        }

        public Criteria andTopimgline1IsNotNull() {
            addCriterion("topImgLine1 is not null");
            return (Criteria) this;
        }

        public Criteria andTopimgline1EqualTo(String value) {
            addCriterion("topImgLine1 =", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1NotEqualTo(String value) {
            addCriterion("topImgLine1 <>", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1GreaterThan(String value) {
            addCriterion("topImgLine1 >", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1GreaterThanOrEqualTo(String value) {
            addCriterion("topImgLine1 >=", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1LessThan(String value) {
            addCriterion("topImgLine1 <", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1LessThanOrEqualTo(String value) {
            addCriterion("topImgLine1 <=", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1Like(String value) {
            addCriterion("topImgLine1 like", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1NotLike(String value) {
            addCriterion("topImgLine1 not like", value, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1In(List<String> values) {
            addCriterion("topImgLine1 in", values, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1NotIn(List<String> values) {
            addCriterion("topImgLine1 not in", values, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1Between(String value1, String value2) {
            addCriterion("topImgLine1 between", value1, value2, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline1NotBetween(String value1, String value2) {
            addCriterion("topImgLine1 not between", value1, value2, "topimgline1");
            return (Criteria) this;
        }

        public Criteria andTopimgline2IsNull() {
            addCriterion("topImgLine2 is null");
            return (Criteria) this;
        }

        public Criteria andTopimgline2IsNotNull() {
            addCriterion("topImgLine2 is not null");
            return (Criteria) this;
        }

        public Criteria andTopimgline2EqualTo(String value) {
            addCriterion("topImgLine2 =", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2NotEqualTo(String value) {
            addCriterion("topImgLine2 <>", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2GreaterThan(String value) {
            addCriterion("topImgLine2 >", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2GreaterThanOrEqualTo(String value) {
            addCriterion("topImgLine2 >=", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2LessThan(String value) {
            addCriterion("topImgLine2 <", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2LessThanOrEqualTo(String value) {
            addCriterion("topImgLine2 <=", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2Like(String value) {
            addCriterion("topImgLine2 like", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2NotLike(String value) {
            addCriterion("topImgLine2 not like", value, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2In(List<String> values) {
            addCriterion("topImgLine2 in", values, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2NotIn(List<String> values) {
            addCriterion("topImgLine2 not in", values, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2Between(String value1, String value2) {
            addCriterion("topImgLine2 between", value1, value2, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline2NotBetween(String value1, String value2) {
            addCriterion("topImgLine2 not between", value1, value2, "topimgline2");
            return (Criteria) this;
        }

        public Criteria andTopimgline3IsNull() {
            addCriterion("topImgLine3 is null");
            return (Criteria) this;
        }

        public Criteria andTopimgline3IsNotNull() {
            addCriterion("topImgLine3 is not null");
            return (Criteria) this;
        }

        public Criteria andTopimgline3EqualTo(String value) {
            addCriterion("topImgLine3 =", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3NotEqualTo(String value) {
            addCriterion("topImgLine3 <>", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3GreaterThan(String value) {
            addCriterion("topImgLine3 >", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3GreaterThanOrEqualTo(String value) {
            addCriterion("topImgLine3 >=", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3LessThan(String value) {
            addCriterion("topImgLine3 <", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3LessThanOrEqualTo(String value) {
            addCriterion("topImgLine3 <=", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3Like(String value) {
            addCriterion("topImgLine3 like", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3NotLike(String value) {
            addCriterion("topImgLine3 not like", value, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3In(List<String> values) {
            addCriterion("topImgLine3 in", values, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3NotIn(List<String> values) {
            addCriterion("topImgLine3 not in", values, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3Between(String value1, String value2) {
            addCriterion("topImgLine3 between", value1, value2, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andTopimgline3NotBetween(String value1, String value2) {
            addCriterion("topImgLine3 not between", value1, value2, "topimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimg1IsNull() {
            addCriterion("bottomImg1 is null");
            return (Criteria) this;
        }

        public Criteria andBottomimg1IsNotNull() {
            addCriterion("bottomImg1 is not null");
            return (Criteria) this;
        }

        public Criteria andBottomimg1EqualTo(String value) {
            addCriterion("bottomImg1 =", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1NotEqualTo(String value) {
            addCriterion("bottomImg1 <>", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1GreaterThan(String value) {
            addCriterion("bottomImg1 >", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1GreaterThanOrEqualTo(String value) {
            addCriterion("bottomImg1 >=", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1LessThan(String value) {
            addCriterion("bottomImg1 <", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1LessThanOrEqualTo(String value) {
            addCriterion("bottomImg1 <=", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1Like(String value) {
            addCriterion("bottomImg1 like", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1NotLike(String value) {
            addCriterion("bottomImg1 not like", value, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1In(List<String> values) {
            addCriterion("bottomImg1 in", values, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1NotIn(List<String> values) {
            addCriterion("bottomImg1 not in", values, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1Between(String value1, String value2) {
            addCriterion("bottomImg1 between", value1, value2, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg1NotBetween(String value1, String value2) {
            addCriterion("bottomImg1 not between", value1, value2, "bottomimg1");
            return (Criteria) this;
        }

        public Criteria andBottomimg2IsNull() {
            addCriterion("bottomImg2 is null");
            return (Criteria) this;
        }

        public Criteria andBottomimg2IsNotNull() {
            addCriterion("bottomImg2 is not null");
            return (Criteria) this;
        }

        public Criteria andBottomimg2EqualTo(String value) {
            addCriterion("bottomImg2 =", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2NotEqualTo(String value) {
            addCriterion("bottomImg2 <>", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2GreaterThan(String value) {
            addCriterion("bottomImg2 >", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2GreaterThanOrEqualTo(String value) {
            addCriterion("bottomImg2 >=", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2LessThan(String value) {
            addCriterion("bottomImg2 <", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2LessThanOrEqualTo(String value) {
            addCriterion("bottomImg2 <=", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2Like(String value) {
            addCriterion("bottomImg2 like", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2NotLike(String value) {
            addCriterion("bottomImg2 not like", value, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2In(List<String> values) {
            addCriterion("bottomImg2 in", values, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2NotIn(List<String> values) {
            addCriterion("bottomImg2 not in", values, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2Between(String value1, String value2) {
            addCriterion("bottomImg2 between", value1, value2, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg2NotBetween(String value1, String value2) {
            addCriterion("bottomImg2 not between", value1, value2, "bottomimg2");
            return (Criteria) this;
        }

        public Criteria andBottomimg3IsNull() {
            addCriterion("bottomImg3 is null");
            return (Criteria) this;
        }

        public Criteria andBottomimg3IsNotNull() {
            addCriterion("bottomImg3 is not null");
            return (Criteria) this;
        }

        public Criteria andBottomimg3EqualTo(String value) {
            addCriterion("bottomImg3 =", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3NotEqualTo(String value) {
            addCriterion("bottomImg3 <>", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3GreaterThan(String value) {
            addCriterion("bottomImg3 >", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3GreaterThanOrEqualTo(String value) {
            addCriterion("bottomImg3 >=", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3LessThan(String value) {
            addCriterion("bottomImg3 <", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3LessThanOrEqualTo(String value) {
            addCriterion("bottomImg3 <=", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3Like(String value) {
            addCriterion("bottomImg3 like", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3NotLike(String value) {
            addCriterion("bottomImg3 not like", value, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3In(List<String> values) {
            addCriterion("bottomImg3 in", values, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3NotIn(List<String> values) {
            addCriterion("bottomImg3 not in", values, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3Between(String value1, String value2) {
            addCriterion("bottomImg3 between", value1, value2, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimg3NotBetween(String value1, String value2) {
            addCriterion("bottomImg3 not between", value1, value2, "bottomimg3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1IsNull() {
            addCriterion("bottomImgLine1 is null");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1IsNotNull() {
            addCriterion("bottomImgLine1 is not null");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1EqualTo(String value) {
            addCriterion("bottomImgLine1 =", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1NotEqualTo(String value) {
            addCriterion("bottomImgLine1 <>", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1GreaterThan(String value) {
            addCriterion("bottomImgLine1 >", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1GreaterThanOrEqualTo(String value) {
            addCriterion("bottomImgLine1 >=", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1LessThan(String value) {
            addCriterion("bottomImgLine1 <", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1LessThanOrEqualTo(String value) {
            addCriterion("bottomImgLine1 <=", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1Like(String value) {
            addCriterion("bottomImgLine1 like", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1NotLike(String value) {
            addCriterion("bottomImgLine1 not like", value, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1In(List<String> values) {
            addCriterion("bottomImgLine1 in", values, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1NotIn(List<String> values) {
            addCriterion("bottomImgLine1 not in", values, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1Between(String value1, String value2) {
            addCriterion("bottomImgLine1 between", value1, value2, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline1NotBetween(String value1, String value2) {
            addCriterion("bottomImgLine1 not between", value1, value2, "bottomimgline1");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2IsNull() {
            addCriterion("bottomImgLine2 is null");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2IsNotNull() {
            addCriterion("bottomImgLine2 is not null");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2EqualTo(String value) {
            addCriterion("bottomImgLine2 =", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2NotEqualTo(String value) {
            addCriterion("bottomImgLine2 <>", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2GreaterThan(String value) {
            addCriterion("bottomImgLine2 >", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2GreaterThanOrEqualTo(String value) {
            addCriterion("bottomImgLine2 >=", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2LessThan(String value) {
            addCriterion("bottomImgLine2 <", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2LessThanOrEqualTo(String value) {
            addCriterion("bottomImgLine2 <=", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2Like(String value) {
            addCriterion("bottomImgLine2 like", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2NotLike(String value) {
            addCriterion("bottomImgLine2 not like", value, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2In(List<String> values) {
            addCriterion("bottomImgLine2 in", values, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2NotIn(List<String> values) {
            addCriterion("bottomImgLine2 not in", values, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2Between(String value1, String value2) {
            addCriterion("bottomImgLine2 between", value1, value2, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline2NotBetween(String value1, String value2) {
            addCriterion("bottomImgLine2 not between", value1, value2, "bottomimgline2");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3IsNull() {
            addCriterion("bottomImgLine3 is null");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3IsNotNull() {
            addCriterion("bottomImgLine3 is not null");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3EqualTo(String value) {
            addCriterion("bottomImgLine3 =", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3NotEqualTo(String value) {
            addCriterion("bottomImgLine3 <>", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3GreaterThan(String value) {
            addCriterion("bottomImgLine3 >", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3GreaterThanOrEqualTo(String value) {
            addCriterion("bottomImgLine3 >=", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3LessThan(String value) {
            addCriterion("bottomImgLine3 <", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3LessThanOrEqualTo(String value) {
            addCriterion("bottomImgLine3 <=", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3Like(String value) {
            addCriterion("bottomImgLine3 like", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3NotLike(String value) {
            addCriterion("bottomImgLine3 not like", value, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3In(List<String> values) {
            addCriterion("bottomImgLine3 in", values, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3NotIn(List<String> values) {
            addCriterion("bottomImgLine3 not in", values, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3Between(String value1, String value2) {
            addCriterion("bottomImgLine3 between", value1, value2, "bottomimgline3");
            return (Criteria) this;
        }

        public Criteria andBottomimgline3NotBetween(String value1, String value2) {
            addCriterion("bottomImgLine3 not between", value1, value2, "bottomimgline3");
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

        public Criteria andOrdernumEqualTo(Integer value) {
            addCriterion("orderNum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(Integer value) {
            addCriterion("orderNum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(Integer value) {
            addCriterion("orderNum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(Integer value) {
            addCriterion("orderNum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("orderNum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<Integer> values) {
            addCriterion("orderNum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<Integer> values) {
            addCriterion("orderNum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("orderNum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNum not between", value1, value2, "ordernum");
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