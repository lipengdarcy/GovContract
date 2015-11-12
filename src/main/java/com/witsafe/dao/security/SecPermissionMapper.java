package com.witsafe.dao.security;

import com.witsafe.model.security.SecPermission;
import com.witsafe.model.security.SecPermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecPermissionMapper {
    int countByExample(SecPermissionExample example);

    int deleteByExample(SecPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecPermission record);

    int insertSelective(SecPermission record);

    List<SecPermission> selectByExampleWithBLOBs(SecPermissionExample example);

    List<SecPermission> selectByExample(SecPermissionExample example);

    SecPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecPermission record, @Param("example") SecPermissionExample example);

    int updateByExampleWithBLOBs(@Param("record") SecPermission record, @Param("example") SecPermissionExample example);

    int updateByExample(@Param("record") SecPermission record, @Param("example") SecPermissionExample example);

    int updateByPrimaryKeySelective(SecPermission record);

    int updateByPrimaryKeyWithBLOBs(SecPermission record);

    int updateByPrimaryKey(SecPermission record);
}