package com.witsafe.contracts.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witsafe.contracts.entity.common.ResponseData;
import com.witsafe.contracts.model.Account;
import com.witsafe.framework.common.Constant;
import com.witsafe.service.AccountService;


/**
 * @Description 用户登录
 * @author lipeng

 */
@Controller
@RequestMapping("/account")
public class AccountController {
	private static Logger loggerinfo = Logger.getLogger("InfoLogger");
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 用户登录页
	 */
	@RequestMapping()
	public String load(ModelMap m) {		
		return "account/login";
	}

	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseData login(HttpSession session, Account userAccount, String verifyCode, ModelMap m) {
		ResponseData data = new ResponseData();
		//检查验证码是否正确
		String sessionVCode = (String) session.getAttribute(Constant.ACCOUNT_SESSION_VCODE); 		
		if (StringUtils.isEmpty(verifyCode)
				|| !verifyCode.equalsIgnoreCase(sessionVCode)) {
			data.setState("failed");
			data.setContent("验证码错误");
			return data;
		}

		//检查用户名密码是否正确		
		Account account = accountService.selectByNamePassword(userAccount.getName(), userAccount.getPassword());
		if (account != null) {
			String loginTime = Constant.format.format(new Date());
			loggerinfo.info("登录名:" + userAccount.getName() + ", 登录时间:" + loginTime);
			
			session.setAttribute("account", account);
			data.setState("success");
			data.setContent("登录成功");
			return data;
		} else {
			data.setState("failed");
			data.setContent("登录名或密码错误");
			return data;
		}

	}

	/**
	 * 退出登录
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.removeAttribute("account");
		return "redirect:/account.do";
	}
}
