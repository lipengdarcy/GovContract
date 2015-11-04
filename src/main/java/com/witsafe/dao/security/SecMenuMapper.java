package com.witsafe.dao.security;

import com.witsafe.model.security.SecMenu;
import com.witsafe.model.security.SecMenuExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecMenuMapper {
    int countByExample(SecMenuExample example);

    int deleteByExample(SecMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecMenu record);

    int insertSelective(SecMenu record);

    List<SecMenu> selectByExample(SecMenuExample example);

    SecMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecMenu record, @Param("example") SecMenuExample example);

    int updateByExample(@Param("record") SecMenu record, @Param("example") SecMenuExample example);

    int updateByPrimaryKeySelective(SecMenu record);

    int updateByPrimaryKey(SecMenu record);
    
    List<SecMenu> getAllowedAccessMenu(Integer id);
}