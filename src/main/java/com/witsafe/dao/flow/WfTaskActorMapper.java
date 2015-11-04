package com.witsafe.dao.flow;

import com.witsafe.model.flow.WfTaskActor;
import com.witsafe.model.flow.WfTaskActorExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfTaskActorMapper {
    int countByExample(WfTaskActorExample example);

    int deleteByExample(WfTaskActorExample example);

    int insert(WfTaskActor record);

    int insertSelective(WfTaskActor record);

    List<WfTaskActor> selectByExample(WfTaskActorExample example);

    int updateByExampleSelective(@Param("record") WfTaskActor record, @Param("example") WfTaskActorExample example);

    int updateByExample(@Param("record") WfTaskActor record, @Param("example") WfTaskActorExample example);
}