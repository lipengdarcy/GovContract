package com.witsafe.contracts.dao;

import com.witsafe.contracts.model.DfForm;
import com.witsafe.contracts.model.DfFormExample;
import com.witsafe.contracts.model.DfFormWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DfFormMapper {
    int countByExample(DfFormExample example);

    int deleteByExample(DfFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfFormWithBLOBs record);

    int insertSelective(DfFormWithBLOBs record);

    List<DfFormWithBLOBs> selectByExampleWithBLOBs(DfFormExample example);

    List<DfForm> selectByExample(DfFormExample example);

    DfFormWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DfFormWithBLOBs record, @Param("example") DfFormExample example);

    int updateByExampleWithBLOBs(@Param("record") DfFormWithBLOBs record, @Param("example") DfFormExample example);

    int updateByExample(@Param("record") DfForm record, @Param("example") DfFormExample example);

    int updateByPrimaryKeySelective(DfFormWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DfFormWithBLOBs record);

    int updateByPrimaryKey(DfForm record);
}