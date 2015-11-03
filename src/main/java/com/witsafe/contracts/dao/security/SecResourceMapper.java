package com.witsafe.contracts.dao.security;

import com.witsafe.contracts.model.security.SecResource;
import com.witsafe.contracts.model.security.SecResourceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SecResourceMapper {
    int countByExample(SecResourceExample example);

    int deleteByExample(SecResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecResource record);

    int insertSelective(SecResource record);

    List<SecResource> selectByExample(SecResourceExample example);

    SecResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecResource record, @Param("example") SecResourceExample example);

    int updateByExample(@Param("record") SecResource record, @Param("example") SecResourceExample example);

    int updateByPrimaryKeySelective(SecResource record);

    int updateByPrimaryKey(SecResource record);
}