package com.witsafe.model.security;

import java.util.ArrayList;
import java.util.List;

public class SecResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecResourceExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andResourcecodeIsNull() {
            addCriterion("resourceCode is null");
            return (Criteria) this;
        }

        public Criteria andResourcecodeIsNotNull() {
            addCriterion("resourceCode is not null");
            return (Criteria) this;
        }

        public Criteria andResourcecodeEqualTo(String value) {
            addCriterion("resourceCode =", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeNotEqualTo(String value) {
            addCriterion("resourceCode <>", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeGreaterThan(String value) {
            addCriterion("resourceCode >", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeGreaterThanOrEqualTo(String value) {
            addCriterion("resourceCode >=", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeLessThan(String value) {
            addCriterion("resourceCode <", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeLessThanOrEqualTo(String value) {
            addCriterion("resourceCode <=", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeLike(String value) {
            addCriterion("resourceCode like", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeNotLike(String value) {
            addCriterion("resourceCode not like", value, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeIn(List<String> values) {
            addCriterion("resourceCode in", values, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeNotIn(List<String> values) {
            addCriterion("resourceCode not in", values, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeBetween(String value1, String value2) {
            addCriterion("resourceCode between", value1, value2, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcecodeNotBetween(String value1, String value2) {
            addCriterion("resourceCode not between", value1, value2, "resourcecode");
            return (Criteria) this;
        }

        public Criteria andResourcenameIsNull() {
            addCriterion("resourceName is null");
            return (Criteria) this;
        }

        public Criteria andResourcenameIsNotNull() {
            addCriterion("resourceName is not null");
            return (Criteria) this;
        }

        public Criteria andResourcenameEqualTo(String value) {
            addCriterion("resourceName =", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotEqualTo(String value) {
            addCriterion("resourceName <>", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameGreaterThan(String value) {
            addCriterion("resourceName >", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameGreaterThanOrEqualTo(String value) {
            addCriterion("resourceName >=", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameLessThan(String value) {
            addCriterion("resourceName <", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameLessThanOrEqualTo(String value) {
            addCriterion("resourceName <=", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameLike(String value) {
            addCriterion("resourceName like", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotLike(String value) {
            addCriterion("resourceName not like", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameIn(List<String> values) {
            addCriterion("resourceName in", values, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotIn(List<String> values) {
            addCriterion("resourceName not in", values, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameBetween(String value1, String value2) {
            addCriterion("resourceName between", value1, value2, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotBetween(String value1, String value2) {
            addCriterion("resourceName not between", value1, value2, "resourcename");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(Integer value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("order not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andIsmenuIsNull() {
            addCriterion("isMenu is null");
            return (Criteria) this;
        }

        public Criteria andIsmenuIsNotNull() {
            addCriterion("isMenu is not null");
            return (Criteria) this;
        }

        public Criteria andIsmenuEqualTo(Byte value) {
            addCriterion("isMenu =", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotEqualTo(Byte value) {
            addCriterion("isMenu <>", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuGreaterThan(Byte value) {
            addCriterion("isMenu >", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuGreaterThanOrEqualTo(Byte value) {
            addCriterion("isMenu >=", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuLessThan(Byte value) {
            addCriterion("isMenu <", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuLessThanOrEqualTo(Byte value) {
            addCriterion("isMenu <=", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuIn(List<Byte> values) {
            addCriterion("isMenu in", values, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotIn(List<Byte> values) {
            addCriterion("isMenu not in", values, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuBetween(Byte value1, Byte value2) {
            addCriterion("isMenu between", value1, value2, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotBetween(Byte value1, Byte value2) {
            addCriterion("isMenu not between", value1, value2, "ismenu");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNull() {
            addCriterion("menuName is null");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNotNull() {
            addCriterion("menuName is not null");
            return (Criteria) this;
        }

        public Criteria andMenunameEqualTo(String value) {
            addCriterion("menuName =", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotEqualTo(String value) {
            addCriterion("menuName <>", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThan(String value) {
            addCriterion("menuName >", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThanOrEqualTo(String value) {
            addCriterion("menuName >=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThan(String value) {
            addCriterion("menuName <", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThanOrEqualTo(String value) {
            addCriterion("menuName <=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLike(String value) {
            addCriterion("menuName like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotLike(String value) {
            addCriterion("menuName not like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameIn(List<String> values) {
            addCriterion("menuName in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotIn(List<String> values) {
            addCriterion("menuName not in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameBetween(String value1, String value2) {
            addCriterion("menuName between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotBetween(String value1, String value2) {
            addCriterion("menuName not between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNull() {
            addCriterion("isActive is null");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNotNull() {
            addCriterion("isActive is not null");
            return (Criteria) this;
        }

        public Criteria andIsactiveEqualTo(Byte value) {
            addCriterion("isActive =", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotEqualTo(Byte value) {
            addCriterion("isActive <>", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThan(Byte value) {
            addCriterion("isActive >", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("isActive >=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThan(Byte value) {
            addCriterion("isActive <", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThanOrEqualTo(Byte value) {
            addCriterion("isActive <=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveIn(List<Byte> values) {
            addCriterion("isActive in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotIn(List<Byte> values) {
            addCriterion("isActive not in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveBetween(Byte value1, Byte value2) {
            addCriterion("isActive between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotBetween(Byte value1, Byte value2) {
            addCriterion("isActive not between", value1, value2, "isactive");
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