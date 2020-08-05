package com.xrikui.mashup.stock.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MashupConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MashupConfigExample() {
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

        public Criteria andMashupNameIsNull() {
            addCriterion("mashup_name is null");
            return (Criteria) this;
        }

        public Criteria andMashupNameIsNotNull() {
            addCriterion("mashup_name is not null");
            return (Criteria) this;
        }

        public Criteria andMashupNameEqualTo(String value) {
            addCriterion("mashup_name =", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameNotEqualTo(String value) {
            addCriterion("mashup_name <>", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameGreaterThan(String value) {
            addCriterion("mashup_name >", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameGreaterThanOrEqualTo(String value) {
            addCriterion("mashup_name >=", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameLessThan(String value) {
            addCriterion("mashup_name <", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameLessThanOrEqualTo(String value) {
            addCriterion("mashup_name <=", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameLike(String value) {
            addCriterion("mashup_name like", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameNotLike(String value) {
            addCriterion("mashup_name not like", value, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameIn(List<String> values) {
            addCriterion("mashup_name in", values, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameNotIn(List<String> values) {
            addCriterion("mashup_name not in", values, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameBetween(String value1, String value2) {
            addCriterion("mashup_name between", value1, value2, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupNameNotBetween(String value1, String value2) {
            addCriterion("mashup_name not between", value1, value2, "mashupName");
            return (Criteria) this;
        }

        public Criteria andMashupValueIsNull() {
            addCriterion("mashup_value is null");
            return (Criteria) this;
        }

        public Criteria andMashupValueIsNotNull() {
            addCriterion("mashup_value is not null");
            return (Criteria) this;
        }

        public Criteria andMashupValueEqualTo(String value) {
            addCriterion("mashup_value =", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueNotEqualTo(String value) {
            addCriterion("mashup_value <>", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueGreaterThan(String value) {
            addCriterion("mashup_value >", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueGreaterThanOrEqualTo(String value) {
            addCriterion("mashup_value >=", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueLessThan(String value) {
            addCriterion("mashup_value <", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueLessThanOrEqualTo(String value) {
            addCriterion("mashup_value <=", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueLike(String value) {
            addCriterion("mashup_value like", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueNotLike(String value) {
            addCriterion("mashup_value not like", value, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueIn(List<String> values) {
            addCriterion("mashup_value in", values, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueNotIn(List<String> values) {
            addCriterion("mashup_value not in", values, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueBetween(String value1, String value2) {
            addCriterion("mashup_value between", value1, value2, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupValueNotBetween(String value1, String value2) {
            addCriterion("mashup_value not between", value1, value2, "mashupValue");
            return (Criteria) this;
        }

        public Criteria andMashupDescIsNull() {
            addCriterion("mashup_desc is null");
            return (Criteria) this;
        }

        public Criteria andMashupDescIsNotNull() {
            addCriterion("mashup_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMashupDescEqualTo(String value) {
            addCriterion("mashup_desc =", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescNotEqualTo(String value) {
            addCriterion("mashup_desc <>", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescGreaterThan(String value) {
            addCriterion("mashup_desc >", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescGreaterThanOrEqualTo(String value) {
            addCriterion("mashup_desc >=", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescLessThan(String value) {
            addCriterion("mashup_desc <", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescLessThanOrEqualTo(String value) {
            addCriterion("mashup_desc <=", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescLike(String value) {
            addCriterion("mashup_desc like", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescNotLike(String value) {
            addCriterion("mashup_desc not like", value, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescIn(List<String> values) {
            addCriterion("mashup_desc in", values, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescNotIn(List<String> values) {
            addCriterion("mashup_desc not in", values, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescBetween(String value1, String value2) {
            addCriterion("mashup_desc between", value1, value2, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andMashupDescNotBetween(String value1, String value2) {
            addCriterion("mashup_desc not between", value1, value2, "mashupDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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