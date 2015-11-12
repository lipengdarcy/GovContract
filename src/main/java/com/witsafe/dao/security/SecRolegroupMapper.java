package com.witsafe.dao.security;

import com.witsafe.model.security.SecRolegroup;
import com.witsafe.model.security.SecRolegroupExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecRolegroupMapper {
    int countByExample(SecRolegroupExample example);

    int deleteByExample(SecRolegroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecRolegroup record);

    int insertSelective(SecRolegroup record);

    List<SecRolegroup> selectByExample(SecRolegroupExample example);

    SecRolegroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecRolegroup record, @Param("example") SecRolegroupExample example);

    int updateByExample(@Param("record") SecRolegroup record, @Param("example") SecRolegroupExample example);

    int updateByPrimaryKeySelective(SecRolegroup record);

    int updateByPrimaryKey(SecRolegroup record);
}