package com.witsafe.dao.security;

import com.witsafe.model.security.SecRoleUser;
import com.witsafe.model.security.SecRoleUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecRoleUserMapper {
    int countByExample(SecRoleUserExample example);

    int deleteByExample(SecRoleUserExample example);

    int insert(SecRoleUser record);

    int insertSelective(SecRoleUser record);

    List<SecRoleUser> selectByExample(SecRoleUserExample example);

    int updateByExampleSelective(@Param("record") SecRoleUser record, @Param("example") SecRoleUserExample example);

    int updateByExample(@Param("record") SecRoleUser record, @Param("example") SecRoleUserExample example);
}