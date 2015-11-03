package com.witsafe.contracts.dao.security;

import com.witsafe.contracts.model.security.SecRoleAuthority;
import com.witsafe.contracts.model.security.SecRoleAuthorityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecRoleAuthorityMapper {
    int countByExample(SecRoleAuthorityExample example);

    int deleteByExample(SecRoleAuthorityExample example);

    int insert(SecRoleAuthority record);

    int insertSelective(SecRoleAuthority record);

    List<SecRoleAuthority> selectByExample(SecRoleAuthorityExample example);

    int updateByExampleSelective(@Param("record") SecRoleAuthority record, @Param("example") SecRoleAuthorityExample example);

    int updateByExample(@Param("record") SecRoleAuthority record, @Param("example") SecRoleAuthorityExample example);
}