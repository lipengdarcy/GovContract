package com.witsafe.contracts.dao;

import com.witsafe.contracts.model.FlowApproval;
import com.witsafe.contracts.model.FlowApprovalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowApprovalMapper {
    int countByExample(FlowApprovalExample example);

    int deleteByExample(FlowApprovalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowApproval record);

    int insertSelective(FlowApproval record);

    List<FlowApproval> selectByExample(FlowApprovalExample example);

    FlowApproval selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowApproval record, @Param("example") FlowApprovalExample example);

    int updateByExample(@Param("record") FlowApproval record, @Param("example") FlowApprovalExample example);

    int updateByPrimaryKeySelective(FlowApproval record);

    int updateByPrimaryKey(FlowApproval record);
}