package com.witsafe.contracts.dao.flow;

import com.witsafe.contracts.model.flow.WfProcess;
import com.witsafe.contracts.model.flow.WfProcessExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfProcessMapper {
    int countByExample(WfProcessExample example);

    int deleteByExample(WfProcessExample example);

    int deleteByPrimaryKey(String id);

    int insert(WfProcess record);

    int insertSelective(WfProcess record);

    List<WfProcess> selectByExampleWithBLOBs(WfProcessExample example);

    List<WfProcess> selectByExample(WfProcessExample example);

    WfProcess selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WfProcess record, @Param("example") WfProcessExample example);

    int updateByExampleWithBLOBs(@Param("record") WfProcess record, @Param("example") WfProcessExample example);

    int updateByExample(@Param("record") WfProcess record, @Param("example") WfProcessExample example);

    int updateByPrimaryKeySelective(WfProcess record);

    int updateByPrimaryKeyWithBLOBs(WfProcess record);

    int updateByPrimaryKey(WfProcess record);
}