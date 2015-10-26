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

import com.witsafe.contracts.common.Constant;
import com.witsafe.contracts.entity.common.ResponseData;
import com.witsafe.contracts.model.Account;
import com.witsafe.contracts.service.AccountService;


/**
 * @Description 主页操作，包括查看，编辑，删除通讯录，维护组织机构等
 * @author lipeng

 */
@Controller
@RequestMapping("/home")
public class HomeController {
	private static Logger loggerinfo = Logger.getLogger("InfoLogger");
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 主页面
	 */
	@RequestMapping()
	public String load(ModelMap m) {		
		return "home/index";
	}
	
}
