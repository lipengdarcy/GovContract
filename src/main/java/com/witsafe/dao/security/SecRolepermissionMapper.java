package com.witsafe.dao.security;

import com.witsafe.model.security.SecRolepermission;
import com.witsafe.model.security.SecRolepermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecRolepermissionMapper {
    int countByExample(SecRolepermissionExample example);

    int deleteByExample(SecRolepermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecRolepermission record);

    int insertSelective(SecRolepermission record);

    List<SecRolepermission> selectByExample(SecRolepermissionExample example);

    SecRolepermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecRolepermission record, @Param("example") SecRolepermissionExample example);

    int updateByExample(@Param("record") SecRolepermission record, @Param("example") SecRolepermissionExample example);

    int updateByPrimaryKeySelective(SecRolepermission record);

    int updateByPrimaryKey(SecRolepermission record);
}