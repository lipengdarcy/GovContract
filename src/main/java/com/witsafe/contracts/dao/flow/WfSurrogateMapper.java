package com.witsafe.contracts.dao.flow;

import com.witsafe.contracts.model.flow.WfSurrogate;
import com.witsafe.contracts.model.flow.WfSurrogateExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfSurrogateMapper {
    int countByExample(WfSurrogateExample example);

    int deleteByExample(WfSurrogateExample example);

    int deleteByPrimaryKey(String id);

    int insert(WfSurrogate record);

    int insertSelective(WfSurrogate record);

    List<WfSurrogate> selectByExample(WfSurrogateExample example);

    WfSurrogate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WfSurrogate record, @Param("example") WfSurrogateExample example);

    int updateByExample(@Param("record") WfSurrogate record, @Param("example") WfSurrogateExample example);

    int updateByPrimaryKeySelective(WfSurrogate record);

    int updateByPrimaryKey(WfSurrogate record);
}