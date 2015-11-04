package com.witsafe.dao.flow;

import com.witsafe.model.flow.WfHistTaskActor;
import com.witsafe.model.flow.WfHistTaskActorExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WfHistTaskActorMapper {
    int countByExample(WfHistTaskActorExample example);

    int deleteByExample(WfHistTaskActorExample example);

    int insert(WfHistTaskActor record);

    int insertSelective(WfHistTaskActor record);

    List<WfHistTaskActor> selectByExample(WfHistTaskActorExample example);

    int updateByExampleSelective(@Param("record") WfHistTaskActor record, @Param("example") WfHistTaskActorExample example);

    int updateByExample(@Param("record") WfHistTaskActor record, @Param("example") WfHistTaskActorExample example);
}