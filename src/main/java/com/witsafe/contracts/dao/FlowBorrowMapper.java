package com.witsafe.contracts.dao;

import com.witsafe.contracts.model.FlowBorrow;
import com.witsafe.contracts.model.FlowBorrowExample;
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