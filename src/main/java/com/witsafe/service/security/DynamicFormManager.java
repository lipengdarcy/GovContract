package com.witsafe.service.security;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.witsafe.dao.DfFieldMapper;
import com.witsafe.dao.DfFormMapper;
import com.witsafe.framework.common.util.ShiroUtils;
import com.witsafe.framework.utils.DateUtils;
import com.witsafe.model.DfField;
import com.witsafe.model.DfForm;
import com.witsafe.service.SnakerEngineFacets;

/**
 * 动态表单管理类
 * @author yuqs
 * @since 0.1
 */
@Component
public class DynamicFormManager {
    private static final String TABLE_PREFIX = "TBL_";
    @Autowired
    private SnakerEngineFacets facets;
    @Autowired
    private DfFormMapper dfFormMapper;
    @Autowired
    private DfFieldMapper dfFieldMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

   

    public Map<String, String> process(DfForm entity, Map<String, Object> datas) {
        Map<String, String> nameMap = new HashMap<String, String>();
        if(datas == null) {
            throw new NullPointerException();
        }
        String tableName = getTableName(entity);
        List<DfField> fields = new ArrayList<DfField>();
        for(Map.Entry<String, Object> entry : datas.entrySet()) {
            Map<String, String> fieldInfo = (Map<String, String>)entry.getValue();
            DfField field = new DfField();
            field.setName(fieldInfo.get("fieldname"));
            field.setTitle(fieldInfo.get("title"));
            field.setPlugins(fieldInfo.get("plugins"));
            field.setFlow(fieldInfo.get("fieldflow"));
            field.setTableName(tableName);
            field.setFormId(entity.getId());
            field.setType(fieldInfo.get("orgtype"));
            fields.add(field);
            nameMap.put(entry.getKey(), fieldInfo.get("fieldname"));
        }
        entity.setFieldNum(entity.getFieldNum() + fields.size());
        String check = "select count(1) from " + tableName + " where id = 1";
        boolean isExists = true;
        try {
            jdbcTemplate.queryForInt(check);
        } catch(Exception e) {
            isExists = false;
        }
        StringBuilder sql = new StringBuilder();
        try {
            List<String> fieldNames = jdbcTemplate.queryForList("select name from df_field where table_name=?", String.class, tableName);
            if(!isExists) {
                sql.append("CREATE TABLE ").append(tableName).append(" (");
                sql.append("ID INT NOT NULL AUTO_INCREMENT,");
                for(DfField field : fields) {
                    sql.append(field.getName());
                    sql.append(" ").append(fieldSQL(field)).append(",");
                }

                sql.append("FORMID INT NOT NULL,");
                sql.append("UPDATETIME VARCHAR(20),");
                sql.append("ORDERID VARCHAR(50),");
                sql.append("TASKID  VARCHAR(50),");
                sql.append("PRIMARY KEY (ID)");
                sql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
                jdbcTemplate.execute(sql.toString());
            } else {
                if(fields.size() > 0) {
                    for(DfField field : fields) {
                        if(StringUtils.isNotEmpty(field.getName()) &&
                                !fieldNames.contains(field.getName())) {
                            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN " + field.getName() + fieldSQL(field));
                        }
                    }
                }
            }

            for(DfField field : fields) {
                if(!fieldNames.contains(field.getName())) {
                    //fieldDao.save(field);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return nameMap;
    }

    public void submit(Integer formId, List<DfField> fields, Map<String, Object> params,
                       HttpServletRequest request, String processId, String orderId, String taskId) {
        if(StringUtils.isNotEmpty(processId)) {
            if (StringUtils.isEmpty(orderId) && StringUtils.isEmpty(taskId)) {
                orderId = facets.startAndExecute(processId, ShiroUtils.getUsername(), params).getId();
            } else {
                int method = 0;
                String methodStr = request.getParameter("method");
                if(StringUtils.isNotEmpty(methodStr)) {
                    method = Integer.parseInt(methodStr);
                }
                String nextOperator = request.getParameter("nextOperator");
                switch(method) {
                    case 0://任务执行
                        facets.execute(taskId, ShiroUtils.getUsername(), params);
                        break;
                    case -1://驳回、任意跳转
                        facets.executeAndJump(taskId, ShiroUtils.getUsername(), params, request.getParameter("nodeName"));
                        break;
                    case 1://转办
                        if(StringUtils.isNotEmpty(nextOperator)) {
                            facets.transferMajor(taskId, ShiroUtils.getUsername(), nextOperator.split(","));
                        }
                        break;
                    case 2://协办
                        if(StringUtils.isNotEmpty(nextOperator)) {
                            facets.transferAidant(taskId, ShiroUtils.getUsername(), nextOperator.split(","));
                        }
                        break;
                    default:
                        facets.execute(taskId, ShiroUtils.getUsername(), params);
                        break;
                }
            }
        }
        DfForm entity = dfFormMapper.selectByPrimaryKey(formId) ;
        String tableName = getTableName(entity);
        StringBuilder beforeSql = new StringBuilder();
        StringBuilder afterSql = new StringBuilder();
        beforeSql.append("INSERT INTO ").append(tableName);
        beforeSql.append(" (FORMID, UPDATETIME, ORDERID, TASKID ");
        afterSql.append(") values (?,?,?,?");
        List<Object> datas = new ArrayList<Object>();
        datas.add(entity.getId());
        datas.add(DateUtils.getCurrentTime());
        datas.add(orderId);
        datas.add(taskId);
        if(fields != null) {
            StringBuilder fieldSql = new StringBuilder();
            StringBuilder valueSql = new StringBuilder();
            Map<String, String[]> paraMap = request.getParameterMap();
            for(DfField field : fields) {
                String[] data = paraMap.get(field.getName());
                if(data == null) {
                    continue;
                }
                fieldSql.append(",").append(field.getName());
                valueSql.append(",?");
                if(data.length == 1) {
                    datas.add(data[0]);
                } else {
                    String dataArr = ArrayUtils.toString(data);
                    if(dataArr.length() > 1) {
                        datas.add(dataArr.substring(1, dataArr.length() - 1));
                    }
                }
            }
            if(fieldSql.length() > 0) {
                beforeSql.append(fieldSql.toString());
                afterSql.append(valueSql.toString());
            }
        }
        afterSql.append(")");
        beforeSql.append(afterSql.toString());
        String sql = beforeSql.toString();
        jdbcTemplate.update(sql, datas.toArray());
    }



    private String getTableName(DfForm entity) {
        return TABLE_PREFIX + entity.getName();
    }

    private String fieldSQL(DfField field) {
        String plugins = field.getPlugins();
        if(plugins.equalsIgnoreCase("textarea")
                || plugins.equalsIgnoreCase("listctrl")) {
            return " TEXT";
        } else if(plugins.equalsIgnoreCase("text")) {
            String type = field.getType();
            if("text".equals(type)) {
                return " VARCHAR(255) NOT NULL DEFAULT ''";
            } else if("int".equals(type)) {
                return " INT NOT NULL DEFAULT 0";
            } else if("float".equals(type)) {
                return " FLOAT ";
            } else {
                return " VARCHAR(255) NOT NULL DEFAULT ''";
            }
        } else if(plugins.equalsIgnoreCase("radios")) {
            return " VARCHAR(255) NOT NULL DEFAULT ''";
        } else {
            return " VARCHAR(255) NOT NULL DEFAULT ''";
        }
    }
}
