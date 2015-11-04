package com.witsafe.dao;

import com.witsafe.model.Nationstandard;
import com.witsafe.model.NationstandardExample;
import com.witsafe.model.NationstandardWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NationstandardMapper {
    int countByExample(NationstandardExample example);

    int deleteByExample(NationstandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NationstandardWithBLOBs record);

    int insertSelective(NationstandardWithBLOBs record);

    List<NationstandardWithBLOBs> selectByExampleWithBLOBs(NationstandardExample example);

    List<Nationstandard> selectByExample(NationstandardExample example);

    NationstandardWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NationstandardWithBLOBs record, @Param("example") NationstandardExample example);

    int updateByExampleWithBLOBs(@Param("record") NationstandardWithBLOBs record, @Param("example") NationstandardExample example);

    int updateByExample(@Param("record") Nationstandard record, @Param("example") NationstandardExample example);

    int updateByPrimaryKeySelective(NationstandardWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NationstandardWithBLOBs record);

    int updateByPrimaryKey(Nationstandard record);
}