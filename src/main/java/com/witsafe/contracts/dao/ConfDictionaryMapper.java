package com.witsafe.contracts.dao;

import com.witsafe.contracts.model.ConfDictionary;
import com.witsafe.contracts.model.ConfDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfDictionaryMapper {
    int countByExample(ConfDictionaryExample example);

    int deleteByExample(ConfDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfDictionary record);

    int insertSelective(ConfDictionary record);

    List<ConfDictionary> selectByExample(ConfDictionaryExample example);

    ConfDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfDictionary record, @Param("example") ConfDictionaryExample example);

    int updateByExample(@Param("record") ConfDictionary record, @Param("example") ConfDictionaryExample example);

    int updateByPrimaryKeySelective(ConfDictionary record);

    int updateByPrimaryKey(ConfDictionary record);
}