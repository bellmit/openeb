package com.gsccs.b2c.plat.site.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @说明  添加物流配送模板
 * @开发者 mahong
 * @年月日 2015年4月27日
 * @时分秒 下午3:18:01
 */
public class DistriTemplateExample {
	
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DistriTemplateExample() {
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

        public Criteria andDispatchingnameIsNull() {
            addCriterion("dispatchingName is null");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameIsNotNull() {
            addCriterion("dispatchingName is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameEqualTo(String value) {
            addCriterion("dispatchingName =", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameNotEqualTo(String value) {
            addCriterion("dispatchingName <>", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameGreaterThan(String value) {
            addCriterion("dispatchingName >", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameGreaterThanOrEqualTo(String value) {
            addCriterion("dispatchingName >=", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameLessThan(String value) {
            addCriterion("dispatchingName <", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameLessThanOrEqualTo(String value) {
            addCriterion("dispatchingName <=", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameLike(String value) {
            addCriterion("dispatchingName like", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameNotLike(String value) {
            addCriterion("dispatchingName not like", value, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameIn(List<String> values) {
            addCriterion("dispatchingName in", values, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameNotIn(List<String> values) {
            addCriterion("dispatchingName not in", values, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameBetween(String value1, String value2) {
            addCriterion("dispatchingName between", value1, value2, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andDispatchingnameNotBetween(String value1, String value2) {
            addCriterion("dispatchingName not between", value1, value2, "dispatchingname");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyIsNull() {
            addCriterion("logisticsCompany is null");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyIsNotNull() {
            addCriterion("logisticsCompany is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyEqualTo(String value) {
            addCriterion("logisticsCompany =", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyNotEqualTo(String value) {
            addCriterion("logisticsCompany <>", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyGreaterThan(String value) {
            addCriterion("logisticsCompany >", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyGreaterThanOrEqualTo(String value) {
            addCriterion("logisticsCompany >=", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyLessThan(String value) {
            addCriterion("logisticsCompany <", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyLessThanOrEqualTo(String value) {
            addCriterion("logisticsCompany <=", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyLike(String value) {
            addCriterion("logisticsCompany like", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyNotLike(String value) {
            addCriterion("logisticsCompany not like", value, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyIn(List<String> values) {
            addCriterion("logisticsCompany in", values, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyNotIn(List<String> values) {
            addCriterion("logisticsCompany not in", values, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyBetween(String value1, String value2) {
            addCriterion("logisticsCompany between", value1, value2, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andLogisticscompanyNotBetween(String value1, String value2) {
            addCriterion("logisticsCompany not between", value1, value2, "logisticscompany");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFirstweightIsNull() {
            addCriterion("firstWeight is null");
            return (Criteria) this;
        }

        public Criteria andFirstweightIsNotNull() {
            addCriterion("firstWeight is not null");
            return (Criteria) this;
        }

        public Criteria andFirstweightEqualTo(Double value) {
            addCriterion("firstWeight =", value, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightNotEqualTo(Double value) {
            addCriterion("firstWeight <>", value, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightGreaterThan(Double value) {
            addCriterion("firstWeight >", value, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightGreaterThanOrEqualTo(Double value) {
            addCriterion("firstWeight >=", value, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightLessThan(Double value) {
            addCriterion("firstWeight <", value, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightLessThanOrEqualTo(Double value) {
            addCriterion("firstWeight <=", value, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightIn(List<Double> values) {
            addCriterion("firstWeight in", values, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightNotIn(List<Double> values) {
            addCriterion("firstWeight not in", values, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightBetween(Double value1, Double value2) {
            addCriterion("firstWeight between", value1, value2, "firstweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightNotBetween(Double value1, Double value2) {
            addCriterion("firstWeight not between", value1, value2, "firstweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightIsNull() {
            addCriterion("plusWeight is null");
            return (Criteria) this;
        }

        public Criteria andPlusweightIsNotNull() {
            addCriterion("plusWeight is not null");
            return (Criteria) this;
        }

        public Criteria andPlusweightEqualTo(Double value) {
            addCriterion("plusWeight =", value, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightNotEqualTo(Double value) {
            addCriterion("plusWeight <>", value, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightGreaterThan(Double value) {
            addCriterion("plusWeight >", value, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightGreaterThanOrEqualTo(Double value) {
            addCriterion("plusWeight >=", value, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightLessThan(Double value) {
            addCriterion("plusWeight <", value, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightLessThanOrEqualTo(Double value) {
            addCriterion("plusWeight <=", value, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightIn(List<Double> values) {
            addCriterion("plusWeight in", values, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightNotIn(List<Double> values) {
            addCriterion("plusWeight not in", values, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightBetween(Double value1, Double value2) {
            addCriterion("plusWeight between", value1, value2, "plusweight");
            return (Criteria) this;
        }

        public Criteria andPlusweightNotBetween(Double value1, Double value2) {
            addCriterion("plusWeight not between", value1, value2, "plusweight");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostIsNull() {
            addCriterion("firstWeightCost is null");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostIsNotNull() {
            addCriterion("firstWeightCost is not null");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostEqualTo(Double value) {
            addCriterion("firstWeightCost =", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostNotEqualTo(Double value) {
            addCriterion("firstWeightCost <>", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostGreaterThan(Double value) {
            addCriterion("firstWeightCost >", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostGreaterThanOrEqualTo(Double value) {
            addCriterion("firstWeightCost >=", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostLessThan(Double value) {
            addCriterion("firstWeightCost <", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostLessThanOrEqualTo(Double value) {
            addCriterion("firstWeightCost <=", value, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostIn(List<Double> values) {
            addCriterion("firstWeightCost in", values, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostNotIn(List<Double> values) {
            addCriterion("firstWeightCost not in", values, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostBetween(Double value1, Double value2) {
            addCriterion("firstWeightCost between", value1, value2, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andFirstweightcostNotBetween(Double value1, Double value2) {
            addCriterion("firstWeightCost not between", value1, value2, "firstweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostIsNull() {
            addCriterion("plusWeightCost is null");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostIsNotNull() {
            addCriterion("plusWeightCost is not null");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostEqualTo(Double value) {
            addCriterion("plusWeightCost =", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostNotEqualTo(Double value) {
            addCriterion("plusWeightCost <>", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostGreaterThan(Double value) {
            addCriterion("plusWeightCost >", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostGreaterThanOrEqualTo(Double value) {
            addCriterion("plusWeightCost >=", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostLessThan(Double value) {
            addCriterion("plusWeightCost <", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostLessThanOrEqualTo(Double value) {
            addCriterion("plusWeightCost <=", value, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostIn(List<Double> values) {
            addCriterion("plusWeightCost in", values, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostNotIn(List<Double> values) {
            addCriterion("plusWeightCost not in", values, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostBetween(Double value1, Double value2) {
            addCriterion("plusWeightCost between", value1, value2, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andPlusweightcostNotBetween(Double value1, Double value2) {
            addCriterion("plusWeightCost not between", value1, value2, "plusweightcost");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumIsNull() {
            addCriterion("isNotSupportPremium is null");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumIsNotNull() {
            addCriterion("isNotSupportPremium is not null");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumEqualTo(String value) {
            addCriterion("isNotSupportPremium =", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumNotEqualTo(String value) {
            addCriterion("isNotSupportPremium <>", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumGreaterThan(String value) {
            addCriterion("isNotSupportPremium >", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumGreaterThanOrEqualTo(String value) {
            addCriterion("isNotSupportPremium >=", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumLessThan(String value) {
            addCriterion("isNotSupportPremium <", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumLessThanOrEqualTo(String value) {
            addCriterion("isNotSupportPremium <=", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumLike(String value) {
            addCriterion("isNotSupportPremium like", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumNotLike(String value) {
            addCriterion("isNotSupportPremium not like", value, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumIn(List<String> values) {
            addCriterion("isNotSupportPremium in", values, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumNotIn(List<String> values) {
            addCriterion("isNotSupportPremium not in", values, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumBetween(String value1, String value2) {
            addCriterion("isNotSupportPremium between", value1, value2, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andIsnotsupportpremiumNotBetween(String value1, String value2) {
            addCriterion("isNotSupportPremium not between", value1, value2, "isnotsupportpremium");
            return (Criteria) this;
        }

        public Criteria andPremiumrateIsNull() {
            addCriterion("premiumRate is null");
            return (Criteria) this;
        }

        public Criteria andPremiumrateIsNotNull() {
            addCriterion("premiumRate is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumrateEqualTo(Double value) {
            addCriterion("premiumRate =", value, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateNotEqualTo(Double value) {
            addCriterion("premiumRate <>", value, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateGreaterThan(Double value) {
            addCriterion("premiumRate >", value, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateGreaterThanOrEqualTo(Double value) {
            addCriterion("premiumRate >=", value, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateLessThan(Double value) {
            addCriterion("premiumRate <", value, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateLessThanOrEqualTo(Double value) {
            addCriterion("premiumRate <=", value, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateIn(List<Double> values) {
            addCriterion("premiumRate in", values, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateNotIn(List<Double> values) {
            addCriterion("premiumRate not in", values, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateBetween(Double value1, Double value2) {
            addCriterion("premiumRate between", value1, value2, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andPremiumrateNotBetween(Double value1, Double value2) {
            addCriterion("premiumRate not between", value1, value2, "premiumrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateIsNull() {
            addCriterion("lowestRate is null");
            return (Criteria) this;
        }

        public Criteria andLowestrateIsNotNull() {
            addCriterion("lowestRate is not null");
            return (Criteria) this;
        }

        public Criteria andLowestrateEqualTo(Double value) {
            addCriterion("lowestRate =", value, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateNotEqualTo(Double value) {
            addCriterion("lowestRate <>", value, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateGreaterThan(Double value) {
            addCriterion("lowestRate >", value, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateGreaterThanOrEqualTo(Double value) {
            addCriterion("lowestRate >=", value, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateLessThan(Double value) {
            addCriterion("lowestRate <", value, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateLessThanOrEqualTo(Double value) {
            addCriterion("lowestRate <=", value, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateIn(List<Double> values) {
            addCriterion("lowestRate in", values, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateNotIn(List<Double> values) {
            addCriterion("lowestRate not in", values, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateBetween(Double value1, Double value2) {
            addCriterion("lowestRate between", value1, value2, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andLowestrateNotBetween(Double value1, Double value2) {
            addCriterion("lowestRate not between", value1, value2, "lowestrate");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyIsNull() {
            addCriterion("allCityApply is null");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyIsNotNull() {
            addCriterion("allCityApply is not null");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyEqualTo(String value) {
            addCriterion("allCityApply =", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyNotEqualTo(String value) {
            addCriterion("allCityApply <>", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyGreaterThan(String value) {
            addCriterion("allCityApply >", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyGreaterThanOrEqualTo(String value) {
            addCriterion("allCityApply >=", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyLessThan(String value) {
            addCriterion("allCityApply <", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyLessThanOrEqualTo(String value) {
            addCriterion("allCityApply <=", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyLike(String value) {
            addCriterion("allCityApply like", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyNotLike(String value) {
            addCriterion("allCityApply not like", value, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyIn(List<String> values) {
            addCriterion("allCityApply in", values, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyNotIn(List<String> values) {
            addCriterion("allCityApply not in", values, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyBetween(String value1, String value2) {
            addCriterion("allCityApply between", value1, value2, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andAllcityapplyNotBetween(String value1, String value2) {
            addCriterion("allCityApply not between", value1, value2, "allcityapply");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsIsNull() {
            addCriterion("designatedRegions is null");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsIsNotNull() {
            addCriterion("designatedRegions is not null");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsEqualTo(String value) {
            addCriterion("designatedRegions =", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsNotEqualTo(String value) {
            addCriterion("designatedRegions <>", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsGreaterThan(String value) {
            addCriterion("designatedRegions >", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsGreaterThanOrEqualTo(String value) {
            addCriterion("designatedRegions >=", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsLessThan(String value) {
            addCriterion("designatedRegions <", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsLessThanOrEqualTo(String value) {
            addCriterion("designatedRegions <=", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsLike(String value) {
            addCriterion("designatedRegions like", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsNotLike(String value) {
            addCriterion("designatedRegions not like", value, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsIn(List<String> values) {
            addCriterion("designatedRegions in", values, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsNotIn(List<String> values) {
            addCriterion("designatedRegions not in", values, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsBetween(String value1, String value2) {
            addCriterion("designatedRegions between", value1, value2, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDesignatedregionsNotBetween(String value1, String value2) {
            addCriterion("designatedRegions not between", value1, value2, "designatedregions");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andWhetherenableIsNull() {
            addCriterion("whetherEnable is null");
            return (Criteria) this;
        }

        public Criteria andWhetherenableIsNotNull() {
            addCriterion("whetherEnable is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherenableEqualTo(String value) {
            addCriterion("whetherEnable =", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableNotEqualTo(String value) {
            addCriterion("whetherEnable <>", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableGreaterThan(String value) {
            addCriterion("whetherEnable >", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableGreaterThanOrEqualTo(String value) {
            addCriterion("whetherEnable >=", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableLessThan(String value) {
            addCriterion("whetherEnable <", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableLessThanOrEqualTo(String value) {
            addCriterion("whetherEnable <=", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableLike(String value) {
            addCriterion("whetherEnable like", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableNotLike(String value) {
            addCriterion("whetherEnable not like", value, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableIn(List<String> values) {
            addCriterion("whetherEnable in", values, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableNotIn(List<String> values) {
            addCriterion("whetherEnable not in", values, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableBetween(String value1, String value2) {
            addCriterion("whetherEnable between", value1, value2, "whetherenable");
            return (Criteria) this;
        }

        public Criteria andWhetherenableNotBetween(String value1, String value2) {
            addCriterion("whetherEnable not between", value1, value2, "whetherenable");
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