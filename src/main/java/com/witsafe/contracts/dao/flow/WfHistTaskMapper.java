package com.witsafe.contracts.dao.flow;

import com.witsafe.contracts.model.flow.WfHistTask;
import com.witsafe.contracts.model.flow.WfHistTaskExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfHistTaskMapper {
    int countByExample(WfHistTaskExample example);

    int deleteByExample(WfHistTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(WfHistTask record);

    int insertSelective(WfHistTask record);

    List<WfHistTask> selectByExample(WfHistTaskExample example);

    WfHistTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WfHistTask record, @Param("example") WfHistTaskExample example);

    int updateByExample(@Param("record") WfHistTask record, @Param("example") WfHistTaskExample example);

    int updateByPrimaryKeySelective(WfHistTask record);

    int updateByPrimaryKey(WfHistTask record);
}