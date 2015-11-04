package com.witsafe.dao;

import com.witsafe.model.FlowBorrow;
import com.witsafe.model.FlowBorrowExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FlowBorrowMapper {
    int countByExample(FlowBorrowExample example);

    int deleteByExample(FlowBorrowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowBorrow record);

    int insertSelective(FlowBorrow record);

    List<FlowBorrow> selectByExample(FlowBorrowExample example);

    FlowBorrow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowBorrow record, @Param("example") FlowBorrowExample example);

    int updateByExample(@Param("record") FlowBorrow record, @Param("example") FlowBorrowExample example);

    int updateByPrimaryKeySelective(FlowBorrow record);

    int updateByPrimaryKey(FlowBorrow record);
}