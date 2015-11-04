package com.witsafe.dao.flow;

import com.witsafe.model.flow.WfTask;
import com.witsafe.model.flow.WfTaskExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfTaskMapper {
    int countByExample(WfTaskExample example);

    int deleteByExample(WfTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(WfTask record);

    int insertSelective(WfTask record);

    List<WfTask> selectByExample(WfTaskExample example);

    WfTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WfTask record, @Param("example") WfTaskExample example);

    int updateByExample(@Param("record") WfTask record, @Param("example") WfTaskExample example);

    int updateByPrimaryKeySelective(WfTask record);

    int updateByPrimaryKey(WfTask record);
}