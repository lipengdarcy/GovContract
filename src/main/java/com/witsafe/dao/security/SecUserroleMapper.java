package com.witsafe.dao.security;

import com.witsafe.model.security.SecUserrole;
import com.witsafe.model.security.SecUserroleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecUserroleMapper {
    int countByExample(SecUserroleExample example);

    int deleteByExample(SecUserroleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecUserrole record);

    int insertSelective(SecUserrole record);

    List<SecUserrole> selectByExample(SecUserroleExample example);

    SecUserrole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecUserrole record, @Param("example") SecUserroleExample example);

    int updateByExample(@Param("record") SecUserrole record, @Param("example") SecUserroleExample example);

    int updateByPrimaryKeySelective(SecUserrole record);

    int updateByPrimaryKey(SecUserrole record);
}