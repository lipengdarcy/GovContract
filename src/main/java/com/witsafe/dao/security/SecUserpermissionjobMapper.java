package com.witsafe.dao.security;

import com.witsafe.model.security.SecUserpermissionjob;
import com.witsafe.model.security.SecUserpermissionjobExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecUserpermissionjobMapper {
    int countByExample(SecUserpermissionjobExample example);

    int deleteByExample(SecUserpermissionjobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecUserpermissionjob record);

    int insertSelective(SecUserpermissionjob record);

    List<SecUserpermissionjob> selectByExample(SecUserpermissionjobExample example);

    SecUserpermissionjob selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecUserpermissionjob record, @Param("example") SecUserpermissionjobExample example);

    int updateByExample(@Param("record") SecUserpermissionjob record, @Param("example") SecUserpermissionjobExample example);

    int updateByPrimaryKeySelective(SecUserpermissionjob record);

    int updateByPrimaryKey(SecUserpermissionjob record);
}