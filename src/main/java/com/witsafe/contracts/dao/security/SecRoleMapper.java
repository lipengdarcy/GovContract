package com.witsafe.contracts.dao.security;

import com.witsafe.contracts.model.security.SecRole;
import com.witsafe.contracts.model.security.SecRoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecRoleMapper {
    int countByExample(SecRoleExample example);

    int deleteByExample(SecRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecRole record);

    int insertSelective(SecRole record);

    List<SecRole> selectByExample(SecRoleExample example);

    SecRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecRole record, @Param("example") SecRoleExample example);

    int updateByExample(@Param("record") SecRole record, @Param("example") SecRoleExample example);

    int updateByPrimaryKeySelective(SecRole record);

    int updateByPrimaryKey(SecRole record);
}