package com.witsafe.contracts.dao;

import com.witsafe.contracts.model.Nationstandard;
import com.witsafe.contracts.model.NationstandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationstandardMapper {
    int countByExample(NationstandardExample example);

    int deleteByExample(NationstandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nationstandard record);

    int insertSelective(Nationstandard record);

    List<Nationstandard> selectByExampleWithBLOBs(NationstandardExample example);

    List<Nationstandard> selectByExample(NationstandardExample example);

    Nationstandard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nationstandard record, @Param("example") NationstandardExample example);

    int updateByExampleWithBLOBs(@Param("record") Nationstandard record, @Param("example") NationstandardExample example);

    int updateByExample(@Param("record") Nationstandard record, @Param("example") NationstandardExample example);

    int updateByPrimaryKeySelective(Nationstandard record);

    int updateByPrimaryKeyWithBLOBs(Nationstandard record);

    int updateByPrimaryKey(Nationstandard record);
}