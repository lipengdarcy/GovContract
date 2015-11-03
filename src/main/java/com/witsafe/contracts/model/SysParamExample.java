package com.witsafe.contracts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysParamExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andParamtypecodeIsNull() {
            addCriterion("paramTypeCode is null");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeIsNotNull() {
            addCriterion("paramTypeCode is not null");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeEqualTo(String value) {
            addCriterion("paramTypeCode =", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeNotEqualTo(String value) {
            addCriterion("paramTypeCode <>", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeGreaterThan(String value) {
            addCriterion("paramTypeCode >", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("paramTypeCode >=", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeLessThan(String value) {
            addCriterion("paramTypeCode <", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeLessThanOrEqualTo(String value) {
            addCriterion("paramTypeCode <=", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeLike(String value) {
            addCriterion("paramTypeCode like", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeNotLike(String value) {
            addCriterion("paramTypeCode not like", value, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeIn(List<String> values) {
            addCriterion("paramTypeCode in", values, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeNotIn(List<String> values) {
            addCriterion("paramTypeCode not in", values, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeBetween(String value1, String value2) {
            addCriterion("paramTypeCode between", value1, value2, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypecodeNotBetween(String value1, String value2) {
            addCriterion("paramTypeCode not between", value1, value2, "paramtypecode");
            return (Criteria) this;
        }

        public Criteria andParamtypenameIsNull() {
            addCriterion("paramTypeName is null");
            return (Criteria) this;
        }

        public Criteria andParamtypenameIsNotNull() {
            addCriterion("paramTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andParamtypenameEqualTo(String value) {
            addCriterion("paramTypeName =", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameNotEqualTo(String value) {
            addCriterion("paramTypeName <>", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameGreaterThan(String value) {
            addCriterion("paramTypeName >", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("paramTypeName >=", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameLessThan(String value) {
            addCriterion("paramTypeName <", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameLessThanOrEqualTo(String value) {
            addCriterion("paramTypeName <=", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameLike(String value) {
            addCriterion("paramTypeName like", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameNotLike(String value) {
            addCriterion("paramTypeName not like", value, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameIn(List<String> values) {
            addCriterion("paramTypeName in", values, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameNotIn(List<String> values) {
            addCriterion("paramTypeName not in", values, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameBetween(String value1, String value2) {
            addCriterion("paramTypeName between", value1, value2, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamtypenameNotBetween(String value1, String value2) {
            addCriterion("paramTypeName not between", value1, value2, "paramtypename");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeIsNull() {
            addCriterion("paramFatherType is null");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeIsNotNull() {
            addCriterion("paramFatherType is not null");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeEqualTo(String value) {
            addCriterion("paramFatherType =", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeNotEqualTo(String value) {
            addCriterion("paramFatherType <>", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeGreaterThan(String value) {
            addCriterion("paramFatherType >", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeGreaterThanOrEqualTo(String value) {
            addCriterion("paramFatherType >=", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeLessThan(String value) {
            addCriterion("paramFatherType <", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeLessThanOrEqualTo(String value) {
            addCriterion("paramFatherType <=", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeLike(String value) {
            addCriterion("paramFatherType like", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeNotLike(String value) {
            addCriterion("paramFatherType not like", value, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeIn(List<String> values) {
            addCriterion("paramFatherType in", values, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeNotIn(List<String> values) {
            addCriterion("paramFatherType not in", values, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeBetween(String value1, String value2) {
            addCriterion("paramFatherType between", value1, value2, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamfathertypeNotBetween(String value1, String value2) {
            addCriterion("paramFatherType not between", value1, value2, "paramfathertype");
            return (Criteria) this;
        }

        public Criteria andParamcodeIsNull() {
            addCriterion("paramCode is null");
            return (Criteria) this;
        }

        public Criteria andParamcodeIsNotNull() {
            addCriterion("paramCode is not null");
            return (Criteria) this;
        }

        public Criteria andParamcodeEqualTo(String value) {
            addCriterion("paramCode =", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotEqualTo(String value) {
            addCriterion("paramCode <>", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeGreaterThan(String value) {
            addCriterion("paramCode >", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeGreaterThanOrEqualTo(String value) {
            addCriterion("paramCode >=", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeLessThan(String value) {
            addCriterion("paramCode <", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeLessThanOrEqualTo(String value) {
            addCriterion("paramCode <=", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeLike(String value) {
            addCriterion("paramCode like", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotLike(String value) {
            addCriterion("paramCode not like", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeIn(List<String> values) {
            addCriterion("paramCode in", values, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotIn(List<String> values) {
            addCriterion("paramCode not in", values, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeBetween(String value1, String value2) {
            addCriterion("paramCode between", value1, value2, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotBetween(String value1, String value2) {
            addCriterion("paramCode not between", value1, value2, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNull() {
            addCriterion("paramName is null");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNotNull() {
            addCriterion("paramName is not null");
            return (Criteria) this;
        }

        public Criteria andParamnameEqualTo(String value) {
            addCriterion("paramName =", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotEqualTo(String value) {
            addCriterion("paramName <>", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThan(String value) {
            addCriterion("paramName >", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThanOrEqualTo(String value) {
            addCriterion("paramName >=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThan(String value) {
            addCriterion("paramName <", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThanOrEqualTo(String value) {
            addCriterion("paramName <=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLike(String value) {
            addCriterion("paramName like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotLike(String value) {
            addCriterion("paramName not like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameIn(List<String> values) {
            addCriterion("paramName in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotIn(List<String> values) {
            addCriterion("paramName not in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameBetween(String value1, String value2) {
            addCriterion("paramName between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotBetween(String value1, String value2) {
            addCriterion("paramName not between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamvalueIsNull() {
            addCriterion("paramValue is null");
            return (Criteria) this;
        }

        public Criteria andParamvalueIsNotNull() {
            addCriterion("paramValue is not null");
            return (Criteria) this;
        }

        public Criteria andParamvalueEqualTo(String value) {
            addCriterion("paramValue =", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotEqualTo(String value) {
            addCriterion("paramValue <>", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueGreaterThan(String value) {
            addCriterion("paramValue >", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueGreaterThanOrEqualTo(String value) {
            addCriterion("paramValue >=", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueLessThan(String value) {
            addCriterion("paramValue <", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueLessThanOrEqualTo(String value) {
            addCriterion("paramValue <=", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueLike(String value) {
            addCriterion("paramValue like", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotLike(String value) {
            addCriterion("paramValue not like", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueIn(List<String> values) {
            addCriterion("paramValue in", values, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotIn(List<String> values) {
            addCriterion("paramValue not in", values, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueBetween(String value1, String value2) {
            addCriterion("paramValue between", value1, value2, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotBetween(String value1, String value2) {
            addCriterion("paramValue not between", value1, value2, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterionForJDBCDate("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterionForJDBCDate("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNull() {
            addCriterion("isValid is null");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNotNull() {
            addCriterion("isValid is not null");
            return (Criteria) this;
        }

        public Criteria andIsvalidEqualTo(Boolean value) {
            addCriterion("isValid =", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotEqualTo(Boolean value) {
            addCriterion("isValid <>", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThan(Boolean value) {
            addCriterion("isValid >", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isValid >=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThan(Boolean value) {
            addCriterion("isValid <", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThanOrEqualTo(Boolean value) {
            addCriterion("isValid <=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidIn(List<Boolean> values) {
            addCriterion("isValid in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotIn(List<Boolean> values) {
            addCriterion("isValid not in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidBetween(Boolean value1, Boolean value2) {
            addCriterion("isValid between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isValid not between", value1, value2, "isvalid");
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