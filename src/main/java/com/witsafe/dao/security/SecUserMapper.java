package com.witsafe.dao.security;

import com.witsafe.model.security.SecUser;
import com.witsafe.model.security.SecUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface SecUserMapper {
    int countByExample(SecUserExample example);

    int deleteByExample(SecUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecUser record);

    int insertSelective(SecUser record);

    List<SecUser> selectByExample(SecUserExample example);

    SecUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecUser record, @Param("example") SecUserExample example);

    int updateByExample(@Param("record") SecUser record, @Param("example") SecUserExample example);

    int updateByPrimaryKeySelective(SecUser record);

    int updateByPrimaryKey(SecUser record);
    
    /**
	 * 根据用户ID查询该用户所拥有的权限列表
	 * @param userId
	 * @return
	 */
	public List<String> getAuthoritiesName(Integer userId);
	
	/**
	 * 根据用户ID查询该用户所拥有的角色列表
	 * @param userId
	 * @return
	 */
	public List<String> getRolesName(Integer userId) ;
	
}