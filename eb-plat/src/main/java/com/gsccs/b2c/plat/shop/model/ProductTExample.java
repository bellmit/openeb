package com.gsccs.b2c.plat.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.b2c.plat.bass.BaseExample;

public class ProductTExample extends BaseExample {

	protected String orderByClause;
	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ProductTExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andSiteIsNull() {
			addCriterion("site is null");
			return (Criteria) this;
		}

		public Criteria andSiteIsNotNull() {
			addCriterion("site is not null");
			return (Criteria) this;
		}

		public Criteria andSiteEqualTo(Long value) {
			addCriterion("site =", value, "site");
			return (Criteria) this;
		}

		public Criteria andSiteNotEqualTo(Long value) {
			addCriterion("site <>", value, "site");
			return (Criteria) this;
		}

		public Criteria andSiteIn(List<Long> values) {
			addCriterion("site in", values, "site");
			return (Criteria) this;
		}

		public Criteria andSiteNotIn(List<Long> values) {
			addCriterion("site not in", values, "site");
			return (Criteria) this;
		}

		public Criteria andSiteBetween(Long value1, Long value2) {
			addCriterion("site between", value1, value2, "site");
			return (Criteria) this;
		}

		public Criteria andSiteNotBetween(Long value1, Long value2) {
			addCriterion("site not between", value1, value2, "site");
			return (Criteria) this;
		}

		public Criteria andBrandIsNull() {
			addCriterion("brand is null");
			return (Criteria) this;
		}

		public Criteria andBrandIsNotNull() {
			addCriterion("brand is not null");
			return (Criteria) this;
		}

		public Criteria andBrandEqualTo(Long value) {
			addCriterion("brand =", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandNotEqualTo(Long value) {
			addCriterion("brand <>", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandGreaterThan(Long value) {
			addCriterion("brand >", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandGreaterThanOrEqualTo(Long value) {
			addCriterion("brand >=", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandLessThan(Long value) {
			addCriterion("brand <", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandLessThanOrEqualTo(Long value) {
			addCriterion("brand <=", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandIn(List<Long> values) {
			addCriterion("brand in", values, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandNotIn(List<Long> values) {
			addCriterion("brand not in", values, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandBetween(Long value1, Long value2) {
			addCriterion("brand between", value1, value2, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandNotBetween(Long value1, Long value2) {
			addCriterion("brand not between", value1, value2, "brand");
			return (Criteria) this;
		}

		public Criteria andCateIsNull() {
			addCriterion("cate is null");
			return (Criteria) this;
		}

		public Criteria andCateIsNotNull() {
			addCriterion("cate is not null");
			return (Criteria) this;
		}

		public Criteria andCateEqualTo(String value) {
			addCriterion("cate =", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateNotEqualTo(String value) {
			addCriterion("cate <>", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateGreaterThan(String value) {
			addCriterion("cate >", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateGreaterThanOrEqualTo(String value) {
			addCriterion("cate >=", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateLessThan(String value) {
			addCriterion("cate <", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateLessThanOrEqualTo(String value) {
			addCriterion("cate <=", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateLike(String value) {
			addCriterion("cate like", value, "cate");
			return (Criteria) this;
		}

		public Criteria andCateIn(List<String> values) {
			addCriterion("cate in", values, "cate");
			return (Criteria) this;
		}

		public Criteria andCateNotIn(List<String> values) {
			addCriterion("cate not in", values, "cate");
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

		public Criteria andTempletIsNull() {
			addCriterion("templet is null");
			return (Criteria) this;
		}

		public Criteria andTempletIsNotNull() {
			addCriterion("templet is not null");
			return (Criteria) this;
		}

		public Criteria andTempletEqualTo(String value) {
			addCriterion("templet =", value, "templet");
			return (Criteria) this;
		}

		public Criteria andIshotIsNull() {
			addCriterion("isHot is null");
			return (Criteria) this;
		}

		public Criteria andIshotIsNotNull() {
			addCriterion("isHot is not null");
			return (Criteria) this;
		}

		public Criteria andIshotEqualTo(String value) {
			addCriterion("isHot =", value, "ishot");
			return (Criteria) this;
		}

		public Criteria andIshotNotEqualTo(String value) {
			addCriterion("isHot <>", value, "ishot");
			return (Criteria) this;
		}

		public Criteria andIshotIn(List<String> values) {
			addCriterion("isHot in", values, "ishot");
			return (Criteria) this;
		}

		public Criteria andIshotNotIn(List<String> values) {
			addCriterion("isHot not in", values, "ishot");
			return (Criteria) this;
		}

		public Criteria andIstopIsNull() {
			addCriterion("isTop is null");
			return (Criteria) this;
		}

		public Criteria andIstopIsNotNull() {
			addCriterion("isTop is not null");
			return (Criteria) this;
		}

		public Criteria andIstopEqualTo(String value) {
			addCriterion("isTop =", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopNotEqualTo(String value) {
			addCriterion("isTop <>", value, "istop");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNull() {
			addCriterion("addtime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addtime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Date value) {
			addCriterion("addtime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Date value) {
			addCriterion("addtime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Date value) {
			addCriterion("addtime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addtime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Date value) {
			addCriterion("addtime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Date value) {
			addCriterion("addtime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Date> values) {
			addCriterion("addtime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Date> values) {
			addCriterion("addtime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Date value1, Date value2) {
			addCriterion("addtime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Date value1, Date value2) {
			addCriterion("addtime not between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeIsNull() {
			addCriterion("topEndTime is null");
			return (Criteria) this;
		}

		public Criteria andTopendtimeIsNotNull() {
			addCriterion("topEndTime is not null");
			return (Criteria) this;
		}

		public Criteria andTopendtimeEqualTo(Date value) {
			addCriterion("topEndTime =", value, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeNotEqualTo(Date value) {
			addCriterion("topEndTime <>", value, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeGreaterThan(Date value) {
			addCriterion("topEndTime >", value, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("topEndTime >=", value, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeLessThan(Date value) {
			addCriterion("topEndTime <", value, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeLessThanOrEqualTo(Date value) {
			addCriterion("topEndTime <=", value, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeIn(List<Date> values) {
			addCriterion("topEndTime in", values, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeNotIn(List<Date> values) {
			addCriterion("topEndTime not in", values, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeBetween(Date value1, Date value2) {
			addCriterion("topEndTime between", value1, value2, "topendtime");
			return (Criteria) this;
		}

		public Criteria andTopendtimeNotBetween(Date value1, Date value2) {
			addCriterion("topEndTime not between", value1, value2, "topendtime");
			return (Criteria) this;
		}

		public Criteria andClicknumIsNull() {
			addCriterion("clickNum is null");
			return (Criteria) this;
		}

		public Criteria andClicknumIsNotNull() {
			addCriterion("clickNum is not null");
			return (Criteria) this;
		}

		public Criteria andClicknumEqualTo(Integer value) {
			addCriterion("clickNum =", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotEqualTo(Integer value) {
			addCriterion("clickNum <>", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumGreaterThan(Integer value) {
			addCriterion("clickNum >", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumGreaterThanOrEqualTo(Integer value) {
			addCriterion("clickNum >=", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumLessThan(Integer value) {
			addCriterion("clickNum <", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumLessThanOrEqualTo(Integer value) {
			addCriterion("clickNum <=", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumIn(List<Integer> values) {
			addCriterion("clickNum in", values, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotIn(List<Integer> values) {
			addCriterion("clickNum not in", values, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumBetween(Integer value1, Integer value2) {
			addCriterion("clickNum between", value1, value2, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotBetween(Integer value1, Integer value2) {
			addCriterion("clickNum not between", value1, value2, "clicknum");
			return (Criteria) this;
		}

		public Criteria andAdduserIsNull() {
			addCriterion("addUser is null");
			return (Criteria) this;
		}

		public Criteria andAdduserIsNotNull() {
			addCriterion("addUser is not null");
			return (Criteria) this;
		}

		public Criteria andAdduserEqualTo(String value) {
			addCriterion("addUser =", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserNotEqualTo(String value) {
			addCriterion("addUser <>", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserGreaterThan(String value) {
			addCriterion("addUser >", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserGreaterThanOrEqualTo(String value) {
			addCriterion("addUser >=", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserLessThan(String value) {
			addCriterion("addUser <", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserLessThanOrEqualTo(String value) {
			addCriterion("addUser <=", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserLike(String value) {
			addCriterion("addUser like", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserNotLike(String value) {
			addCriterion("addUser not like", value, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserIn(List<String> values) {
			addCriterion("addUser in", values, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserNotIn(List<String> values) {
			addCriterion("addUser not in", values, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserBetween(String value1, String value2) {
			addCriterion("addUser between", value1, value2, "adduser");
			return (Criteria) this;
		}

		public Criteria andAdduserNotBetween(String value1, String value2) {
			addCriterion("addUser not between", value1, value2, "adduser");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andEvalnumGreaterThan(String value) {
			addCriterion("evalnum >", value, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumGreaterThanOrEqualTo(String value) {
			addCriterion("evalnum >=", value, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumLessThan(String value) {
			addCriterion("evalnum <", value, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumLessThanOrEqualTo(String value) {
			addCriterion("evalnum <=", value, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumIn(List<String> values) {
			addCriterion("evalnum in", values, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumNotIn(List<String> values) {
			addCriterion("evalnum not in", values, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumBetween(String value1, String value2) {
			addCriterion("evalnum between", value1, value2, "evalnum");
			return (Criteria) this;
		}

		public Criteria andEvalnumNotBetween(String value1, String value2) {
			addCriterion("evalnum not between", value1, value2, "evalnum");
			return (Criteria) this;
		}

		public Criteria andKindIsNull() {
			addCriterion("kind is null");
			return (Criteria) this;
		}

		public Criteria andKindIsNotNull() {
			addCriterion("kind is not null");
			return (Criteria) this;
		}

		public Criteria andKindEqualTo(String value) {
			addCriterion("kind =", value, "kind");
			return (Criteria) this;
		}

		public Criteria andKindNotEqualTo(String value) {
			addCriterion("kind <>", value, "kind");
			return (Criteria) this;
		}

		public Criteria andKindGreaterThan(String value) {
			addCriterion("kind >", value, "kind");
			return (Criteria) this;
		}

		public Criteria andKindGreaterThanOrEqualTo(String value) {
			addCriterion("kind >=", value, "kind");
			return (Criteria) this;
		}

		public Criteria andKindIn(List<String> values) {
			addCriterion("kind in", values, "kind");
			return (Criteria) this;
		}

		public Criteria andKindNotIn(List<String> values) {
			addCriterion("kind not in", values, "kind");
			return (Criteria) this;
		}

		public Criteria andKindBetween(String value1, String value2) {
			addCriterion("kind between", value1, value2, "kind");
			return (Criteria) this;
		}

		public Criteria andKindNotBetween(String value1, String value2) {
			addCriterion("kind not between", value1, value2, "kind");
			return (Criteria) this;
		}

		public Criteria andTagsIsNull() {
			addCriterion("tags is null");
			return (Criteria) this;
		}

		public Criteria andTagsIsNotNull() {
			addCriterion("tags is not null");
			return (Criteria) this;
		}

		public Criteria andTagsEqualTo(String value) {
			addCriterion("tags =", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotEqualTo(String value) {
			addCriterion("tags <>", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsGreaterThan(String value) {
			addCriterion("tags >", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsGreaterThanOrEqualTo(String value) {
			addCriterion("tags >=", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsLessThan(String value) {
			addCriterion("tags <", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsLessThanOrEqualTo(String value) {
			addCriterion("tags <=", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsLike(String value) {
			addCriterion("tags like", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotLike(String value) {
			addCriterion("tags not like", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsIn(List<String> values) {
			addCriterion("tags in", values, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotIn(List<String> values) {
			addCriterion("tags not in", values, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsBetween(String value1, String value2) {
			addCriterion("tags between", value1, value2, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotBetween(String value1, String value2) {
			addCriterion("tags not between", value1, value2, "tags");
			return (Criteria) this;
		}

		public Criteria andBarcodeIsNull() {
			addCriterion("barcode is null");
			return (Criteria) this;
		}

		public Criteria andBarcodeIsNotNull() {
			addCriterion("barcode is not null");
			return (Criteria) this;
		}

		public Criteria andBarcodeEqualTo(String value) {
			addCriterion("barcode =", value, "barcode");
			return (Criteria) this;
		}

		public Criteria andBarcodeLike(String value) {
			addCriterion("barcode like", value, "barcode");
			return (Criteria) this;
		}

		public Criteria andBarcodeNotLike(String value) {
			addCriterion("barcode not like", value, "barcode");
			return (Criteria) this;
		}

		public Criteria andBarcodeIn(List<String> values) {
			addCriterion("barcode in", values, "barcode");
			return (Criteria) this;
		}

		public Criteria andBarcodeNotIn(List<String> values) {
			addCriterion("barcode not in", values, "barcode");
			return (Criteria) this;
		}

		public Criteria andBarcodeBetween(String value1, String value2) {
			addCriterion("barcode between", value1, value2, "barcode");
			return (Criteria) this;
		}

		public Criteria andBarcodeNotBetween(String value1, String value2) {
			addCriterion("barcode not between", value1, value2, "barcode");
			return (Criteria) this;
		}

		public Criteria andBriefIsNull() {
			addCriterion("brief is null");
			return (Criteria) this;
		}

		public Criteria andBriefIsNotNull() {
			addCriterion("brief is not null");
			return (Criteria) this;
		}

		public Criteria andBriefEqualTo(String value) {
			addCriterion("brief =", value, "brief");
			return (Criteria) this;
		}

		public Criteria andBriefLike(String value) {
			addCriterion("brief like", value, "brief");
			return (Criteria) this;
		}

		public Criteria andBriefNotLike(String value) {
			addCriterion("brief not like", value, "brief");
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

		public Criteria andPriceEqualTo(Double value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(Double value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(Double value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(Double value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(Double value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<Double> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<Double> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(Double value1, Double value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(Double value1, Double value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andMktpriceIsNull() {
			addCriterion("mktprice is null");
			return (Criteria) this;
		}

		public Criteria andMktpriceIsNotNull() {
			addCriterion("mktprice is not null");
			return (Criteria) this;
		}

		public Criteria andMktpriceEqualTo(Double value) {
			addCriterion("mktprice =", value, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceNotEqualTo(Double value) {
			addCriterion("mktprice <>", value, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceGreaterThan(Double value) {
			addCriterion("mktprice >", value, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceGreaterThanOrEqualTo(Double value) {
			addCriterion("mktprice >=", value, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceLessThan(Double value) {
			addCriterion("mktprice <", value, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceLessThanOrEqualTo(Double value) {
			addCriterion("mktprice <=", value, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceIn(List<Double> values) {
			addCriterion("mktprice in", values, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceNotIn(List<Double> values) {
			addCriterion("mktprice not in", values, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceBetween(Double value1, Double value2) {
			addCriterion("mktprice between", value1, value2, "mktprice");
			return (Criteria) this;
		}

		public Criteria andMktpriceNotBetween(Double value1, Double value2) {
			addCriterion("mktprice not between", value1, value2, "mktprice");
			return (Criteria) this;
		}

		public Criteria andWeightIsNull() {
			addCriterion("weight is null");
			return (Criteria) this;
		}

		public Criteria andWeightIsNotNull() {
			addCriterion("weight is not null");
			return (Criteria) this;
		}

		public Criteria andWeightEqualTo(Double value) {
			addCriterion("weight =", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotEqualTo(Double value) {
			addCriterion("weight <>", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThan(Double value) {
			addCriterion("weight >", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThanOrEqualTo(Double value) {
			addCriterion("weight >=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThan(Double value) {
			addCriterion("weight <", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThanOrEqualTo(Double value) {
			addCriterion("weight <=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightIn(List<Double> values) {
			addCriterion("weight in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotIn(List<Double> values) {
			addCriterion("weight not in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightBetween(Double value1, Double value2) {
			addCriterion("weight between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotBetween(Double value1, Double value2) {
			addCriterion("weight not between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andStorenumGreaterThan(Integer value) {
			addCriterion("storenum >", value, "storenum");
			return (Criteria) this;
		}

		public Criteria andStorenumGreaterThanOrEqualTo(Integer value) {
			addCriterion("storenum >=", value, "storenum");
			return (Criteria) this;
		}

		public Criteria andStorenumLessThan(Integer value) {
			addCriterion("storenum <", value, "storenum");
			return (Criteria) this;
		}

		public Criteria andStorenumLessThanOrEqualTo(Integer value) {
			addCriterion("storenum <=", value, "storenum");
			return (Criteria) this;
		}

		public Criteria andStorenumBetween(Integer value1, Integer value2) {
			addCriterion("storenum between", value1, value2, "storenum");
			return (Criteria) this;
		}

		public Criteria andStoreNotBetween(Integer value1, Integer value2) {
			addCriterion("storenum not between", value1, value2, "storenum");
			return (Criteria) this;
		}

		public Criteria andFreightIsNull() {
			addCriterion("freight is null");
			return (Criteria) this;
		}

		public Criteria andFreightIsNotNull() {
			addCriterion("freight is not null");
			return (Criteria) this;
		}

		public Criteria andFreightEqualTo(String value) {
			addCriterion("freight =", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightNotEqualTo(String value) {
			addCriterion("freight <>", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightGreaterThan(String value) {
			addCriterion("freight >", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightGreaterThanOrEqualTo(String value) {
			addCriterion("freight >=", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightLessThan(String value) {
			addCriterion("freight <", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightLessThanOrEqualTo(String value) {
			addCriterion("freight <=", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightLike(String value) {
			addCriterion("freight like", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightNotLike(String value) {
			addCriterion("freight not like", value, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightIn(List<String> values) {
			addCriterion("freight in", values, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightNotIn(List<String> values) {
			addCriterion("freight not in", values, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightBetween(String value1, String value2) {
			addCriterion("freight between", value1, value2, "freight");
			return (Criteria) this;
		}

		public Criteria andFreightNotBetween(String value1, String value2) {
			addCriterion("freight not between", value1, value2, "freight");
			return (Criteria) this;
		}

		public Criteria andSalenumGreaterThan(Integer value) {
			addCriterion("salenum >", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumGreaterThanOrEqualTo(Integer value) {
			addCriterion("salenum >=", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumLessThan(Integer value) {
			addCriterion("salenum <", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumLessThanOrEqualTo(Integer value) {
			addCriterion("salenum <=", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andGainScoreIsNull() {
			addCriterion("gain_score is null");
			return (Criteria) this;
		}

		public Criteria andGainScoreIsNotNull() {
			addCriterion("gain_score is not null");
			return (Criteria) this;
		}

		public Criteria andGainScoreEqualTo(Float value) {
			addCriterion("gain_score =", value, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreNotEqualTo(Float value) {
			addCriterion("gain_score <>", value, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreGreaterThan(Float value) {
			addCriterion("gain_score >", value, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreGreaterThanOrEqualTo(Float value) {
			addCriterion("gain_score >=", value, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreLessThan(Float value) {
			addCriterion("gain_score <", value, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreLessThanOrEqualTo(Float value) {
			addCriterion("gain_score <=", value, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreIn(List<Float> values) {
			addCriterion("gain_score in", values, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreNotIn(List<Float> values) {
			addCriterion("gain_score not in", values, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreBetween(Float value1, Float value2) {
			addCriterion("gain_score between", value1, value2, "gainScore");
			return (Criteria) this;
		}

		public Criteria andGainScoreNotBetween(Float value1, Float value2) {
			addCriterion("gain_score not between", value1, value2, "gainScore");
			return (Criteria) this;
		}

		public Criteria andTypeidIsNull() {
			addCriterion("typeid is null");
			return (Criteria) this;
		}

		public Criteria andTypeidIsNotNull() {
			addCriterion("typeid is not null");
			return (Criteria) this;
		}

		public Criteria andTypeidEqualTo(Long value) {
			addCriterion("typeid =", value, "typeid");
			return (Criteria) this;
		}

		public Criteria andTypeidNotEqualTo(Long value) {
			addCriterion("typeid <>", value, "typeid");
			return (Criteria) this;
		}

		public Criteria andTypeidIn(List<Long> values) {
			addCriterion("typeid in", values, "typeid");
			return (Criteria) this;
		}

		public Criteria andTypeidNotIn(List<Long> values) {
			addCriterion("typeid not in", values, "typeid");
			return (Criteria) this;
		}

		public Criteria andApprovestatusIsNull() {
			addCriterion("approveStatus is null");
			return (Criteria) this;
		}

		public Criteria andApprovestatusIsNotNull() {
			addCriterion("approveStatus is not null");
			return (Criteria) this;
		}

		public Criteria andApprovestatusEqualTo(String value) {
			addCriterion("approveStatus =", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusNotEqualTo(String value) {
			addCriterion("approveStatus <>", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusGreaterThan(String value) {
			addCriterion("approveStatus >", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusGreaterThanOrEqualTo(String value) {
			addCriterion("approveStatus >=", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusLessThan(String value) {
			addCriterion("approveStatus <", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusLessThanOrEqualTo(String value) {
			addCriterion("approveStatus <=", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusLike(String value) {
			addCriterion("approveStatus like", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusNotLike(String value) {
			addCriterion("approveStatus not like", value, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusIn(List<String> values) {
			addCriterion("approveStatus in", values, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusNotIn(List<String> values) {
			addCriterion("approveStatus not in", values, "approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusBetween(String value1, String value2) {
			addCriterion("approveStatus between", value1, value2,
					"approvestatus");
			return (Criteria) this;
		}

		public Criteria andApprovestatusNotBetween(String value1, String value2) {
			addCriterion("approveStatus not between", value1, value2,
					"approvestatus");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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