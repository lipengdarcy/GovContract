package com.witsafe.contracts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NationstandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NationstandardExample() {
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

        public Criteria andStandardnoIsNull() {
            addCriterion("standardNo is null");
            return (Criteria) this;
        }

        public Criteria andStandardnoIsNotNull() {
            addCriterion("standardNo is not null");
            return (Criteria) this;
        }

        public Criteria andStandardnoEqualTo(String value) {
            addCriterion("standardNo =", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoNotEqualTo(String value) {
            addCriterion("standardNo <>", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoGreaterThan(String value) {
            addCriterion("standardNo >", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoGreaterThanOrEqualTo(String value) {
            addCriterion("standardNo >=", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoLessThan(String value) {
            addCriterion("standardNo <", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoLessThanOrEqualTo(String value) {
            addCriterion("standardNo <=", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoLike(String value) {
            addCriterion("standardNo like", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoNotLike(String value) {
            addCriterion("standardNo not like", value, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoIn(List<String> values) {
            addCriterion("standardNo in", values, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoNotIn(List<String> values) {
            addCriterion("standardNo not in", values, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoBetween(String value1, String value2) {
            addCriterion("standardNo between", value1, value2, "standardno");
            return (Criteria) this;
        }

        public Criteria andStandardnoNotBetween(String value1, String value2) {
            addCriterion("standardNo not between", value1, value2, "standardno");
            return (Criteria) this;
        }

        public Criteria andNameChIsNull() {
            addCriterion("name_ch is null");
            return (Criteria) this;
        }

        public Criteria andNameChIsNotNull() {
            addCriterion("name_ch is not null");
            return (Criteria) this;
        }

        public Criteria andNameChEqualTo(String value) {
            addCriterion("name_ch =", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotEqualTo(String value) {
            addCriterion("name_ch <>", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChGreaterThan(String value) {
            addCriterion("name_ch >", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChGreaterThanOrEqualTo(String value) {
            addCriterion("name_ch >=", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLessThan(String value) {
            addCriterion("name_ch <", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLessThanOrEqualTo(String value) {
            addCriterion("name_ch <=", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLike(String value) {
            addCriterion("name_ch like", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotLike(String value) {
            addCriterion("name_ch not like", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChIn(List<String> values) {
            addCriterion("name_ch in", values, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotIn(List<String> values) {
            addCriterion("name_ch not in", values, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChBetween(String value1, String value2) {
            addCriterion("name_ch between", value1, value2, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotBetween(String value1, String value2) {
            addCriterion("name_ch not between", value1, value2, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
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

        public Criteria andEffectDateIsNull() {
            addCriterion("effect_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectDateIsNotNull() {
            addCriterion("effect_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterionForJDBCDate("effect_date =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("effect_date <>", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateGreaterThan(Date value) {
            addCriterionForJDBCDate("effect_date >", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effect_date >=", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateLessThan(Date value) {
            addCriterionForJDBCDate("effect_date <", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effect_date <=", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateIn(List<Date> values) {
            addCriterionForJDBCDate("effect_date in", values, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("effect_date not in", values, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effect_date between", value1, value2, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effect_date not between", value1, value2, "effectDate");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceIsNull() {
            addCriterion("standardNo_replace is null");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceIsNotNull() {
            addCriterion("standardNo_replace is not null");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceEqualTo(String value) {
            addCriterion("standardNo_replace =", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceNotEqualTo(String value) {
            addCriterion("standardNo_replace <>", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceGreaterThan(String value) {
            addCriterion("standardNo_replace >", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceGreaterThanOrEqualTo(String value) {
            addCriterion("standardNo_replace >=", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceLessThan(String value) {
            addCriterion("standardNo_replace <", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceLessThanOrEqualTo(String value) {
            addCriterion("standardNo_replace <=", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceLike(String value) {
            addCriterion("standardNo_replace like", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceNotLike(String value) {
            addCriterion("standardNo_replace not like", value, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceIn(List<String> values) {
            addCriterion("standardNo_replace in", values, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceNotIn(List<String> values) {
            addCriterion("standardNo_replace not in", values, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceBetween(String value1, String value2) {
            addCriterion("standardNo_replace between", value1, value2, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andStandardnoReplaceNotBetween(String value1, String value2) {
            addCriterion("standardNo_replace not between", value1, value2, "standardnoReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceIsNull() {
            addCriterion("name_replace is null");
            return (Criteria) this;
        }

        public Criteria andNameReplaceIsNotNull() {
            addCriterion("name_replace is not null");
            return (Criteria) this;
        }

        public Criteria andNameReplaceEqualTo(String value) {
            addCriterion("name_replace =", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceNotEqualTo(String value) {
            addCriterion("name_replace <>", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceGreaterThan(String value) {
            addCriterion("name_replace >", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceGreaterThanOrEqualTo(String value) {
            addCriterion("name_replace >=", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceLessThan(String value) {
            addCriterion("name_replace <", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceLessThanOrEqualTo(String value) {
            addCriterion("name_replace <=", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceLike(String value) {
            addCriterion("name_replace like", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceNotLike(String value) {
            addCriterion("name_replace not like", value, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceIn(List<String> values) {
            addCriterion("name_replace in", values, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceNotIn(List<String> values) {
            addCriterion("name_replace not in", values, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceBetween(String value1, String value2) {
            addCriterion("name_replace between", value1, value2, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andNameReplaceNotBetween(String value1, String value2) {
            addCriterion("name_replace not between", value1, value2, "nameReplace");
            return (Criteria) this;
        }

        public Criteria andTypeChIsNull() {
            addCriterion("type_ch is null");
            return (Criteria) this;
        }

        public Criteria andTypeChIsNotNull() {
            addCriterion("type_ch is not null");
            return (Criteria) this;
        }

        public Criteria andTypeChEqualTo(String value) {
            addCriterion("type_ch =", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChNotEqualTo(String value) {
            addCriterion("type_ch <>", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChGreaterThan(String value) {
            addCriterion("type_ch >", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChGreaterThanOrEqualTo(String value) {
            addCriterion("type_ch >=", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChLessThan(String value) {
            addCriterion("type_ch <", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChLessThanOrEqualTo(String value) {
            addCriterion("type_ch <=", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChLike(String value) {
            addCriterion("type_ch like", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChNotLike(String value) {
            addCriterion("type_ch not like", value, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChIn(List<String> values) {
            addCriterion("type_ch in", values, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChNotIn(List<String> values) {
            addCriterion("type_ch not in", values, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChBetween(String value1, String value2) {
            addCriterion("type_ch between", value1, value2, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeChNotBetween(String value1, String value2) {
            addCriterion("type_ch not between", value1, value2, "typeCh");
            return (Criteria) this;
        }

        public Criteria andTypeIsoIsNull() {
            addCriterion("type_iso is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsoIsNotNull() {
            addCriterion("type_iso is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIsoEqualTo(String value) {
            addCriterion("type_iso =", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoNotEqualTo(String value) {
            addCriterion("type_iso <>", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoGreaterThan(String value) {
            addCriterion("type_iso >", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoGreaterThanOrEqualTo(String value) {
            addCriterion("type_iso >=", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoLessThan(String value) {
            addCriterion("type_iso <", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoLessThanOrEqualTo(String value) {
            addCriterion("type_iso <=", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoLike(String value) {
            addCriterion("type_iso like", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoNotLike(String value) {
            addCriterion("type_iso not like", value, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoIn(List<String> values) {
            addCriterion("type_iso in", values, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoNotIn(List<String> values) {
            addCriterion("type_iso not in", values, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoBetween(String value1, String value2) {
            addCriterion("type_iso between", value1, value2, "typeIso");
            return (Criteria) this;
        }

        public Criteria andTypeIsoNotBetween(String value1, String value2) {
            addCriterion("type_iso not between", value1, value2, "typeIso");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNull() {
            addCriterion("publisher is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("publisher is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(String value) {
            addCriterion("publisher =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(String value) {
            addCriterion("publisher <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(String value) {
            addCriterion("publisher >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("publisher >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(String value) {
            addCriterion("publisher <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(String value) {
            addCriterion("publisher <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLike(String value) {
            addCriterion("publisher like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotLike(String value) {
            addCriterion("publisher not like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<String> values) {
            addCriterion("publisher in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<String> values) {
            addCriterion("publisher not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(String value1, String value2) {
            addCriterion("publisher between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(String value1, String value2) {
            addCriterion("publisher not between", value1, value2, "publisher");
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