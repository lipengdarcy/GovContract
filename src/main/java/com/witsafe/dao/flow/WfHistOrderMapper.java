package com.witsafe.dao.flow;

import com.witsafe.model.flow.WfHistOrder;
import com.witsafe.model.flow.WfHistOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfHistOrderMapper {
    int countByExample(WfHistOrderExample example);

    int deleteByExample(WfHistOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(WfHistOrder record);

    int insertSelective(WfHistOrder record);

    List<WfHistOrder> selectByExample(WfHistOrderExample example);

    WfHistOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WfHistOrder record, @Param("example") WfHistOrderExample example);

    int updateByExample(@Param("record") WfHistOrder record, @Param("example") WfHistOrderExample example);

    int updateByPrimaryKeySelective(WfHistOrder record);

    int updateByPrimaryKey(WfHistOrder record);
}