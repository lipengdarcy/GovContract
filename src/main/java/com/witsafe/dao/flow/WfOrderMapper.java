package com.witsafe.dao.flow;

import com.witsafe.model.flow.WfOrder;
import com.witsafe.model.flow.WfOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfOrderMapper {
    int countByExample(WfOrderExample example);

    int deleteByExample(WfOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(WfOrder record);

    int insertSelective(WfOrder record);

    List<WfOrder> selectByExample(WfOrderExample example);

    WfOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WfOrder record, @Param("example") WfOrderExample example);

    int updateByExample(@Param("record") WfOrder record, @Param("example") WfOrderExample example);

    int updateByPrimaryKeySelective(WfOrder record);

    int updateByPrimaryKey(WfOrder record);
}