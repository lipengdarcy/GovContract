package com.witsafe.contracts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.witsafe.contracts.dao.AccountMapper;
import com.witsafe.contracts.model.Account;
import com.witsafe.contracts.model.AccountExample;

@Service
public class AccountService {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 查询用户
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户详情
	 */
	public Account selectByPrimaryKey(int userId) {
		return accountMapper.selectByPrimaryKey(userId);
	}
	
	/**
	 * 新增用户
	 * 
	 * @param record
	 *            用户详情
	 * @return 
	 */
	public int insert(Account record) {
		return accountMapper.insertSelective(record);
	}

	/**
	 * 查询用户
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户详情
	 */
	public Account selectByNamePassword(String name, String password) {
		AccountExample e = new AccountExample();
		List<Account> list = accountMapper.selectByExample(e);
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	/**
	 * 查询组织的所有用户
	 * 
	 * @param orgid
	 *            组织id
	 * @return 用户详情列表
	 */
	public List<Account> getOrgMembers(Integer orgid) {
		PageHelper.startPage(1, 10);
		AccountExample e = new AccountExample();
		e.or().andOrgidEqualTo(orgid);
		List<Account> list = accountMapper.selectByExample(e);
		return list;
	}

}
