package com.witsafe.contracts.model.flow;

import java.util.ArrayList;
import java.util.List;

public class WfSurrogateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WfSurrogateExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("process_Name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_Name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_Name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_Name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_Name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_Name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_Name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_Name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_Name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_Name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_Name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_Name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_Name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_Name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andSurrogateIsNull() {
            addCriterion("surrogate is null");
            return (Criteria) this;
        }

        public Criteria andSurrogateIsNotNull() {
            addCriterion("surrogate is not null");
            return (Criteria) this;
        }

        public Criteria andSurrogateEqualTo(String value) {
            addCriterion("surrogate =", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateNotEqualTo(String value) {
            addCriterion("surrogate <>", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateGreaterThan(String value) {
            addCriterion("surrogate >", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateGreaterThanOrEqualTo(String value) {
            addCriterion("surrogate >=", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateLessThan(String value) {
            addCriterion("surrogate <", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateLessThanOrEqualTo(String value) {
            addCriterion("surrogate <=", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateLike(String value) {
            addCriterion("surrogate like", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateNotLike(String value) {
            addCriterion("surrogate not like", value, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateIn(List<String> values) {
            addCriterion("surrogate in", values, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateNotIn(List<String> values) {
            addCriterion("surrogate not in", values, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateBetween(String value1, String value2) {
            addCriterion("surrogate between", value1, value2, "surrogate");
            return (Criteria) this;
        }

        public Criteria andSurrogateNotBetween(String value1, String value2) {
            addCriterion("surrogate not between", value1, value2, "surrogate");
            return (Criteria) this;
        }

        public Criteria andOdateIsNull() {
            addCriterion("odate is null");
            return (Criteria) this;
        }

        public Criteria andOdateIsNotNull() {
            addCriterion("odate is not null");
            return (Criteria) this;
        }

        public Criteria andOdateEqualTo(String value) {
            addCriterion("odate =", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotEqualTo(String value) {
            addCriterion("odate <>", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThan(String value) {
            addCriterion("odate >", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThanOrEqualTo(String value) {
            addCriterion("odate >=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThan(String value) {
            addCriterion("odate <", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThanOrEqualTo(String value) {
            addCriterion("odate <=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLike(String value) {
            addCriterion("odate like", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotLike(String value) {
            addCriterion("odate not like", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateIn(List<String> values) {
            addCriterion("odate in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotIn(List<String> values) {
            addCriterion("odate not in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateBetween(String value1, String value2) {
            addCriterion("odate between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotBetween(String value1, String value2) {
            addCriterion("odate not between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andSdateIsNull() {
            addCriterion("sdate is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("sdate is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(String value) {
            addCriterion("sdate =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(String value) {
            addCriterion("sdate <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(String value) {
            addCriterion("sdate >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(String value) {
            addCriterion("sdate >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(String value) {
            addCriterion("sdate <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(String value) {
            addCriterion("sdate <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLike(String value) {
            addCriterion("sdate like", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotLike(String value) {
            addCriterion("sdate not like", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<String> values) {
            addCriterion("sdate in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<String> values) {
            addCriterion("sdate not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(String value1, String value2) {
            addCriterion("sdate between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(String value1, String value2) {
            addCriterion("sdate not between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andEdateIsNull() {
            addCriterion("edate is null");
            return (Criteria) this;
        }

        public Criteria andEdateIsNotNull() {
            addCriterion("edate is not null");
            return (Criteria) this;
        }

        public Criteria andEdateEqualTo(String value) {
            addCriterion("edate =", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotEqualTo(String value) {
            addCriterion("edate <>", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThan(String value) {
            addCriterion("edate >", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThanOrEqualTo(String value) {
            addCriterion("edate >=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThan(String value) {
            addCriterion("edate <", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThanOrEqualTo(String value) {
            addCriterion("edate <=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLike(String value) {
            addCriterion("edate like", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotLike(String value) {
            addCriterion("edate not like", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateIn(List<String> values) {
            addCriterion("edate in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotIn(List<String> values) {
            addCriterion("edate not in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateBetween(String value1, String value2) {
            addCriterion("edate between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotBetween(String value1, String value2) {
            addCriterion("edate not between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Boolean value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Boolean value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Boolean value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Boolean value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Boolean value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Boolean> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Boolean> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Boolean value1, Boolean value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("state not between", value1, value2, "state");
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