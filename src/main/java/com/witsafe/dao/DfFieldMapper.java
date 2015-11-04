package com.witsafe.dao;

import com.witsafe.model.DfField;
import com.witsafe.model.DfFieldExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DfFieldMapper {
    int countByExample(DfFieldExample example);

    int deleteByExample(DfFieldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfField record);

    int insertSelective(DfField record);

    List<DfField> selectByExample(DfFieldExample example);

    DfField selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DfField record, @Param("example") DfFieldExample example);

    int updateByExample(@Param("record") DfField record, @Param("example") DfFieldExample example);

    int updateByPrimaryKeySelective(DfField record);

    int updateByPrimaryKey(DfField record);
}