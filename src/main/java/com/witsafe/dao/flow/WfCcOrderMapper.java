package com.witsafe.dao.flow;

import com.witsafe.model.flow.WfCcOrder;
import com.witsafe.model.flow.WfCcOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfCcOrderMapper {
    int countByExample(WfCcOrderExample example);

    int deleteByExample(WfCcOrderExample example);

    int insert(WfCcOrder record);

    int insertSelective(WfCcOrder record);

    List<WfCcOrder> selectByExample(WfCcOrderExample example);

    int updateByExampleSelective(@Param("record") WfCcOrder record, @Param("example") WfCcOrderExample example);

    int updateByExample(@Param("record") WfCcOrder record, @Param("example") WfCcOrderExample example);
}