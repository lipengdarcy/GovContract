package com.witsafe.dao.security;

import com.witsafe.model.security.SecAuthorityResource;
import com.witsafe.model.security.SecAuthorityResourceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecAuthorityResourceMapper {
    int countByExample(SecAuthorityResourceExample example);

    int deleteByExample(SecAuthorityResourceExample example);

    int insert(SecAuthorityResource record);

    int insertSelective(SecAuthorityResource record);

    List<SecAuthorityResource> selectByExample(SecAuthorityResourceExample example);

    int updateByExampleSelective(@Param("record") SecAuthorityResource record, @Param("example") SecAuthorityResourceExample example);

    int updateByExample(@Param("record") SecAuthorityResource record, @Param("example") SecAuthorityResourceExample example);
}