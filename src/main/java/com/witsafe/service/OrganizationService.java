package com.witsafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witsafe.dao.OrganizationMapper;
import com.witsafe.model.Organization;
import com.witsafe.model.OrganizationExample;

@Service
public class OrganizationService {


	
	@Autowired
	private OrganizationMapper organizationMapper;

	/**
	 * 查询用户
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户详情
	 */
	public Organization selectByPrimaryKey(int userId) {
		return organizationMapper.selectByPrimaryKey(userId);
	}
	
	/**
	 * 新增用户
	 * 
	 * @param record
	 *            用户详情Organization
	 * @return 
	 */
	public int insert(Organization record) {
		return organizationMapper.insertSelective(record);
	}
	
	/**
	 * 编辑用户
	 * 
	 * @param record
	 *            用户详情
	 * @return 
	 */
	public int update(Organization record) {
		return organizationMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除用户
	 * 
	 * @param record
	 *            用户详情
	 * @return 
	 */
	public int delete(int id) {
		return organizationMapper.deleteByPrimaryKey(id);
	}




	/**
	 * 查询所有组织
	 */
	public List<Organization> selectAll() {
		//PageHelper.startPage(1, 10);
		List<Organization> list = organizationMapper.selectByExample(new OrganizationExample());
		return list;
	}

}
