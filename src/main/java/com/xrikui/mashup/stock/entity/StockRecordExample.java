package com.xrikui.mashup.stock.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockRecordExample() {
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

        public Criteria andCurrentPriceIsNull() {
            addCriterion("current_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNotNull() {
            addCriterion("current_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceEqualTo(BigDecimal value) {
            addCriterion("current_price =", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotEqualTo(BigDecimal value) {
            addCriterion("current_price <>", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThan(BigDecimal value) {
            addCriterion("current_price >", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price >=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThan(BigDecimal value) {
            addCriterion("current_price <", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price <=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIn(List<BigDecimal> values) {
            addCriterion("current_price in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotIn(List<BigDecimal> values) {
            addCriterion("current_price not in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price not between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andNowRateIsNull() {
            addCriterion("now_rate is null");
            return (Criteria) this;
        }

        public Criteria andNowRateIsNotNull() {
            addCriterion("now_rate is not null");
            return (Criteria) this;
        }

        public Criteria andNowRateEqualTo(String value) {
            addCriterion("now_rate =", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateNotEqualTo(String value) {
            addCriterion("now_rate <>", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateGreaterThan(String value) {
            addCriterion("now_rate >", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateGreaterThanOrEqualTo(String value) {
            addCriterion("now_rate >=", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateLessThan(String value) {
            addCriterion("now_rate <", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateLessThanOrEqualTo(String value) {
            addCriterion("now_rate <=", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateLike(String value) {
            addCriterion("now_rate like", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateNotLike(String value) {
            addCriterion("now_rate not like", value, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateIn(List<String> values) {
            addCriterion("now_rate in", values, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateNotIn(List<String> values) {
            addCriterion("now_rate not in", values, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateBetween(String value1, String value2) {
            addCriterion("now_rate between", value1, value2, "nowRate");
            return (Criteria) this;
        }

        public Criteria andNowRateNotBetween(String value1, String value2) {
            addCriterion("now_rate not between", value1, value2, "nowRate");
            return (Criteria) this;
        }

        public Criteria andLastRateIsNull() {
            addCriterion("last_rate is null");
            return (Criteria) this;
        }

        public Criteria andLastRateIsNotNull() {
            addCriterion("last_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLastRateEqualTo(String value) {
            addCriterion("last_rate =", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateNotEqualTo(String value) {
            addCriterion("last_rate <>", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateGreaterThan(String value) {
            addCriterion("last_rate >", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateGreaterThanOrEqualTo(String value) {
            addCriterion("last_rate >=", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateLessThan(String value) {
            addCriterion("last_rate <", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateLessThanOrEqualTo(String value) {
            addCriterion("last_rate <=", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateLike(String value) {
            addCriterion("last_rate like", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateNotLike(String value) {
            addCriterion("last_rate not like", value, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateIn(List<String> values) {
            addCriterion("last_rate in", values, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateNotIn(List<String> values) {
            addCriterion("last_rate not in", values, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateBetween(String value1, String value2) {
            addCriterion("last_rate between", value1, value2, "lastRate");
            return (Criteria) this;
        }

        public Criteria andLastRateNotBetween(String value1, String value2) {
            addCriterion("last_rate not between", value1, value2, "lastRate");
            return (Criteria) this;
        }

        public Criteria andTodayDateIsNull() {
            addCriterion("today_date is null");
            return (Criteria) this;
        }

        public Criteria andTodayDateIsNotNull() {
            addCriterion("today_date is not null");
            return (Criteria) this;
        }

        public Criteria andTodayDateEqualTo(String value) {
            addCriterion("today_date =", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateNotEqualTo(String value) {
            addCriterion("today_date <>", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateGreaterThan(String value) {
            addCriterion("today_date >", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateGreaterThanOrEqualTo(String value) {
            addCriterion("today_date >=", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateLessThan(String value) {
            addCriterion("today_date <", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateLessThanOrEqualTo(String value) {
            addCriterion("today_date <=", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateLike(String value) {
            addCriterion("today_date like", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateNotLike(String value) {
            addCriterion("today_date not like", value, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateIn(List<String> values) {
            addCriterion("today_date in", values, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateNotIn(List<String> values) {
            addCriterion("today_date not in", values, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateBetween(String value1, String value2) {
            addCriterion("today_date between", value1, value2, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayDateNotBetween(String value1, String value2) {
            addCriterion("today_date not between", value1, value2, "todayDate");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceIsNull() {
            addCriterion("today_open_price is null");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceIsNotNull() {
            addCriterion("today_open_price is not null");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceEqualTo(BigDecimal value) {
            addCriterion("today_open_price =", value, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceNotEqualTo(BigDecimal value) {
            addCriterion("today_open_price <>", value, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceGreaterThan(BigDecimal value) {
            addCriterion("today_open_price >", value, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_open_price >=", value, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceLessThan(BigDecimal value) {
            addCriterion("today_open_price <", value, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_open_price <=", value, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceIn(List<BigDecimal> values) {
            addCriterion("today_open_price in", values, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceNotIn(List<BigDecimal> values) {
            addCriterion("today_open_price not in", values, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_open_price between", value1, value2, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayOpenPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_open_price not between", value1, value2, "todayOpenPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceIsNull() {
            addCriterion("today_highest_price is null");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceIsNotNull() {
            addCriterion("today_highest_price is not null");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceEqualTo(BigDecimal value) {
            addCriterion("today_highest_price =", value, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceNotEqualTo(BigDecimal value) {
            addCriterion("today_highest_price <>", value, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceGreaterThan(BigDecimal value) {
            addCriterion("today_highest_price >", value, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_highest_price >=", value, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceLessThan(BigDecimal value) {
            addCriterion("today_highest_price <", value, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_highest_price <=", value, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceIn(List<BigDecimal> values) {
            addCriterion("today_highest_price in", values, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceNotIn(List<BigDecimal> values) {
            addCriterion("today_highest_price not in", values, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_highest_price between", value1, value2, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayHighestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_highest_price not between", value1, value2, "todayHighestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceIsNull() {
            addCriterion("today_lowest_price is null");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceIsNotNull() {
            addCriterion("today_lowest_price is not null");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceEqualTo(BigDecimal value) {
            addCriterion("today_lowest_price =", value, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceNotEqualTo(BigDecimal value) {
            addCriterion("today_lowest_price <>", value, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceGreaterThan(BigDecimal value) {
            addCriterion("today_lowest_price >", value, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_lowest_price >=", value, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceLessThan(BigDecimal value) {
            addCriterion("today_lowest_price <", value, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_lowest_price <=", value, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceIn(List<BigDecimal> values) {
            addCriterion("today_lowest_price in", values, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceNotIn(List<BigDecimal> values) {
            addCriterion("today_lowest_price not in", values, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_lowest_price between", value1, value2, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andTodayLowestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_lowest_price not between", value1, value2, "todayLowestPrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceIsNull() {
            addCriterion("yesterday_close_price is null");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceIsNotNull() {
            addCriterion("yesterday_close_price is not null");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceEqualTo(BigDecimal value) {
            addCriterion("yesterday_close_price =", value, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceNotEqualTo(BigDecimal value) {
            addCriterion("yesterday_close_price <>", value, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceGreaterThan(BigDecimal value) {
            addCriterion("yesterday_close_price >", value, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yesterday_close_price >=", value, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceLessThan(BigDecimal value) {
            addCriterion("yesterday_close_price <", value, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yesterday_close_price <=", value, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceIn(List<BigDecimal> values) {
            addCriterion("yesterday_close_price in", values, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceNotIn(List<BigDecimal> values) {
            addCriterion("yesterday_close_price not in", values, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yesterday_close_price between", value1, value2, "yesterdayClosePrice");
            return (Criteria) this;
        }

        public Criteria andYesterdayClosePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yesterday_close_price not between", value1, value2, "yesterdayClosePrice");
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