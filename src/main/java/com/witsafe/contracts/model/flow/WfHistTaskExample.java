package com.witsafe.contracts.model.flow;

import java.util.ArrayList;
import java.util.List;

public class WfHistTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WfHistTaskExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_Id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_Id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_Id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_Id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_Id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_Id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_Id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_Id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_Id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_Id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_Id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_Id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_Id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_Name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_Name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_Name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_Name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_Name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_Name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_Name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_Name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_Name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_Name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_Name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_Name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_Name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_Name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_Name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_Name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_Name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_Name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_Name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_Name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_Name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_Name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_Name like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_Name not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_Name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_Name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_Name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_Name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_Type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_Type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Boolean value) {
            addCriterion("task_Type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Boolean value) {
            addCriterion("task_Type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Boolean value) {
            addCriterion("task_Type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("task_Type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Boolean value) {
            addCriterion("task_Type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("task_Type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Boolean> values) {
            addCriterion("task_Type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Boolean> values) {
            addCriterion("task_Type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("task_Type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("task_Type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeIsNull() {
            addCriterion("perform_Type is null");
            return (Criteria) this;
        }

        public Criteria andPerformTypeIsNotNull() {
            addCriterion("perform_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPerformTypeEqualTo(Boolean value) {
            addCriterion("perform_Type =", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeNotEqualTo(Boolean value) {
            addCriterion("perform_Type <>", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeGreaterThan(Boolean value) {
            addCriterion("perform_Type >", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("perform_Type >=", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeLessThan(Boolean value) {
            addCriterion("perform_Type <", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("perform_Type <=", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeIn(List<Boolean> values) {
            addCriterion("perform_Type in", values, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeNotIn(List<Boolean> values) {
            addCriterion("perform_Type not in", values, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("perform_Type between", value1, value2, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("perform_Type not between", value1, value2, "performType");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("task_State is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("task_State is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(Boolean value) {
            addCriterion("task_State =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(Boolean value) {
            addCriterion("task_State <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(Boolean value) {
            addCriterion("task_State >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("task_State >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(Boolean value) {
            addCriterion("task_State <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(Boolean value) {
            addCriterion("task_State <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<Boolean> values) {
            addCriterion("task_State in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<Boolean> values) {
            addCriterion("task_State not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(Boolean value1, Boolean value2) {
            addCriterion("task_State between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("task_State not between", value1, value2, "taskState");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_Time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_Time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_Time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_Time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_Time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_Time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_Time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_Time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_Time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_Time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_Time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_Time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_Time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_Time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(String value) {
            addCriterion("finish_Time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(String value) {
            addCriterion("finish_Time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(String value) {
            addCriterion("finish_Time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("finish_Time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(String value) {
            addCriterion("finish_Time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("finish_Time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLike(String value) {
            addCriterion("finish_Time like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotLike(String value) {
            addCriterion("finish_Time not like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<String> values) {
            addCriterion("finish_Time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<String> values) {
            addCriterion("finish_Time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(String value1, String value2) {
            addCriterion("finish_Time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(String value1, String value2) {
            addCriterion("finish_Time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_Time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_Time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(String value) {
            addCriterion("expire_Time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(String value) {
            addCriterion("expire_Time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(String value) {
            addCriterion("expire_Time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(String value) {
            addCriterion("expire_Time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(String value) {
            addCriterion("expire_Time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(String value) {
            addCriterion("expire_Time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLike(String value) {
            addCriterion("expire_Time like", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotLike(String value) {
            addCriterion("expire_Time not like", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<String> values) {
            addCriterion("expire_Time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<String> values) {
            addCriterion("expire_Time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(String value1, String value2) {
            addCriterion("expire_Time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(String value1, String value2) {
            addCriterion("expire_Time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNull() {
            addCriterion("action_Url is null");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNotNull() {
            addCriterion("action_Url is not null");
            return (Criteria) this;
        }

        public Criteria andActionUrlEqualTo(String value) {
            addCriterion("action_Url =", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotEqualTo(String value) {
            addCriterion("action_Url <>", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThan(String value) {
            addCriterion("action_Url >", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("action_Url >=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThan(String value) {
            addCriterion("action_Url <", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThanOrEqualTo(String value) {
            addCriterion("action_Url <=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLike(String value) {
            addCriterion("action_Url like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotLike(String value) {
            addCriterion("action_Url not like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlIn(List<String> values) {
            addCriterion("action_Url in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotIn(List<String> values) {
            addCriterion("action_Url not in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlBetween(String value1, String value2) {
            addCriterion("action_Url between", value1, value2, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotBetween(String value1, String value2) {
            addCriterion("action_Url not between", value1, value2, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNull() {
            addCriterion("parent_Task_Id is null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNotNull() {
            addCriterion("parent_Task_Id is not null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdEqualTo(String value) {
            addCriterion("parent_Task_Id =", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotEqualTo(String value) {
            addCriterion("parent_Task_Id <>", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThan(String value) {
            addCriterion("parent_Task_Id >", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_Task_Id >=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThan(String value) {
            addCriterion("parent_Task_Id <", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThanOrEqualTo(String value) {
            addCriterion("parent_Task_Id <=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLike(String value) {
            addCriterion("parent_Task_Id like", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotLike(String value) {
            addCriterion("parent_Task_Id not like", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIn(List<String> values) {
            addCriterion("parent_Task_Id in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotIn(List<String> values) {
            addCriterion("parent_Task_Id not in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdBetween(String value1, String value2) {
            addCriterion("parent_Task_Id between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotBetween(String value1, String value2) {
            addCriterion("parent_Task_Id not between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andVariableIsNull() {
            addCriterion("variable is null");
            return (Criteria) this;
        }

        public Criteria andVariableIsNotNull() {
            addCriterion("variable is not null");
            return (Criteria) this;
        }

        public Criteria andVariableEqualTo(String value) {
            addCriterion("variable =", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotEqualTo(String value) {
            addCriterion("variable <>", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableGreaterThan(String value) {
            addCriterion("variable >", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableGreaterThanOrEqualTo(String value) {
            addCriterion("variable >=", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLessThan(String value) {
            addCriterion("variable <", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLessThanOrEqualTo(String value) {
            addCriterion("variable <=", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLike(String value) {
            addCriterion("variable like", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotLike(String value) {
            addCriterion("variable not like", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableIn(List<String> values) {
            addCriterion("variable in", values, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotIn(List<String> values) {
            addCriterion("variable not in", values, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableBetween(String value1, String value2) {
            addCriterion("variable between", value1, value2, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotBetween(String value1, String value2) {
            addCriterion("variable not between", value1, value2, "variable");
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