package com.witsafe.contracts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.witsafe.contracts.dao.AccountMapper;
import com.witsafe.contracts.model.Account;
import com.witsafe.contracts.model.AccountExample;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 查询用户
	 * @param userId 用户id
	 * @return 用户详情
	 */
	public Account selectByPrimaryKey(int userId) {
		return accountMapper.selectByPrimaryKey(userId);
	}
	
	/**
	 * 查询用户
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户详情
	 */
	public Account selectByNamePassword(String name, String password) {
		AccountExample e = new AccountExample();
		List<Account> list =  accountMapper.selectByExample(e);
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	
}
