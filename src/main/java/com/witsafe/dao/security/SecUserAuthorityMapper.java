package com.witsafe.dao.security;

import com.witsafe.model.security.SecUserAuthority;
import com.witsafe.model.security.SecUserAuthorityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecUserAuthorityMapper {
    int countByExample(SecUserAuthorityExample example);

    int deleteByExample(SecUserAuthorityExample example);

    int insert(SecUserAuthority record);

    int insertSelective(SecUserAuthority record);

    List<SecUserAuthority> selectByExample(SecUserAuthorityExample example);

    int updateByExampleSelective(@Param("record") SecUserAuthority record, @Param("example") SecUserAuthorityExample example);

    int updateByExample(@Param("record") SecUserAuthority record, @Param("example") SecUserAuthorityExample example);
}