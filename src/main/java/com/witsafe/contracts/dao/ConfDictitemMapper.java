package com.witsafe.contracts.dao;

import com.witsafe.contracts.model.ConfDictitem;
import com.witsafe.contracts.model.ConfDictitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfDictitemMapper {
    int countByExample(ConfDictitemExample example);

    int deleteByExample(ConfDictitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfDictitem record);

    int insertSelective(ConfDictitem record);

    List<ConfDictitem> selectByExample(ConfDictitemExample example);

    ConfDictitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfDictitem record, @Param("example") ConfDictitemExample example);

    int updateByExample(@Param("record") ConfDictitem record, @Param("example") ConfDictitemExample example);

    int updateByPrimaryKeySelective(ConfDictitem record);

    int updateByPrimaryKey(ConfDictitem record);
}