package com.witsafe.contracts.dao.security;

import com.witsafe.contracts.model.security.SecOrg;
import com.witsafe.contracts.model.security.SecOrgExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecOrgMapper {
    int countByExample(SecOrgExample example);

    int deleteByExample(SecOrgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecOrg record);

    int insertSelective(SecOrg record);

    List<SecOrg> selectByExample(SecOrgExample example);

    SecOrg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecOrg record, @Param("example") SecOrgExample example);

    int updateByExample(@Param("record") SecOrg record, @Param("example") SecOrgExample example);

    int updateByPrimaryKeySelective(SecOrg record);

    int updateByPrimaryKey(SecOrg record);
}