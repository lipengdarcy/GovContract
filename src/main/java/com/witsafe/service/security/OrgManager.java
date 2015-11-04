package com.witsafe.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.contracts.dao.security.SecOrgMapper;
import com.witsafe.contracts.model.security.SecOrg;
import com.witsafe.contracts.model.security.SecOrgExample;

/**
 * 部门管理类
 */
@Component
public class OrgManager {
	//注入部门持久化对象
	@Autowired
	private SecOrgMapper secOrgMapper;
	
	
	/**
	 * 获取所有部门记录
	 * @return
	 */
	public List<SecOrg> getAll() {
		return secOrgMapper.selectByExample(new SecOrgExample());

	}
	
	
}
