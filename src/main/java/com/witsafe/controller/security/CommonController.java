package com.witsafe.controller.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 公用页面Controller，如404找不到页面等
 */
@Controller
public class CommonController {
	private static Log log = LogFactory.getLog(CommonController.class);

	

	// 无权限页面
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String unAuthorized403() {
		log.error("你没有权限登录，请登录或获取相应权限");
		return "commons/403";
	}

	// 找不到页面
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String unFound404() {
		log.error("找不到页面，请检查");
		return "commons/404";
	}

	
}
