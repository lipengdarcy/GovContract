package com.witsafe.dao.security;

import com.witsafe.model.security.SecAuthority;
import com.witsafe.model.security.SecAuthorityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecAuthorityMapper {
    int countByExample(SecAuthorityExample example);

    int deleteByExample(SecAuthorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecAuthority record);

    int insertSelective(SecAuthority record);

    List<SecAuthority> selectByExample(SecAuthorityExample example);

    SecAuthority selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecAuthority record, @Param("example") SecAuthorityExample example);

    int updateByExample(@Param("record") SecAuthority record, @Param("example") SecAuthorityExample example);

    int updateByPrimaryKeySelective(SecAuthority record);

    int updateByPrimaryKey(SecAuthority record);
}