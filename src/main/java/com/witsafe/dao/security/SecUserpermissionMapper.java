package com.witsafe.dao.security;

import com.witsafe.model.security.SecUserpermission;
import com.witsafe.model.security.SecUserpermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecUserpermissionMapper {
    int countByExample(SecUserpermissionExample example);

    int deleteByExample(SecUserpermissionExample example);

    int insert(SecUserpermission record);

    int insertSelective(SecUserpermission record);

    List<SecUserpermission> selectByExample(SecUserpermissionExample example);

    int updateByExampleSelective(@Param("record") SecUserpermission record, @Param("example") SecUserpermissionExample example);

    int updateByExample(@Param("record") SecUserpermission record, @Param("example") SecUserpermissionExample example);
}