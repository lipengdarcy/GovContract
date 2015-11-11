package com.witsafe.controller.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witsafe.model.security.SecUser;

/**
 * 系统登录Controller
 */
@Controller
public class LoginController {
	private static Log log = LogFactory.getLog(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(SecUser user, Model model, HttpServletRequest request) {
		log.info("Login user=====" + user.getUsername());
		Subject subject = SecurityUtils.getSubject();
		//1、收集实体/凭据信息 
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		String remember = WebUtils.getCleanParam(request, "remember");
		log.info("remember=" + remember);

		try {
			if (remember != null && remember.equalsIgnoreCase("on")) {
				token.setRememberMe(true);
			}
			//2、提交实体/凭据信息 
			subject.login(token);
			return "redirect:/home";
		} catch (UnknownAccountException ue) {
			token.clear();
			model.addAttribute("error", ue.getMessage());
			return "security/login/login";
		} catch (IncorrectCredentialsException ie) {
			token.clear();
			model.addAttribute("username", user.getUsername());
			model.addAttribute("error", ie.getMessage());
			return "security/login/login";
		} catch (RuntimeException re) {
			token.clear();
			model.addAttribute("username", user.getUsername());
			model.addAttribute("error", "登录失败");
			return "security/login/login";
		}
	}

	// 登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "security/login/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		String userName = subject.getPrincipal().toString();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
			log.info("用户" + userName + "退出登录");
		}
		return "security/login/login";
	}

	// 注册页面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage() {
		return "security/login/register";
	}

	// 找回密码1页面
	@RequestMapping(value = "/findpwd1", method = RequestMethod.GET)
	public String findPassWord1Page() {
		return "security/login/findpwd1";
	}

	// 找回密码2页面
	@RequestMapping(value = "/findpwd2", method = RequestMethod.GET)
	public String findPassWord2Page() {
		return "security/login/findpwd2";
	}

	// 找回密码3页面
	@RequestMapping(value = "/findpwd3", method = RequestMethod.GET)
	public String findPassWord3Page() {
		return "security/login/findpwd3";
	}

	// 找回密码4页面
	@RequestMapping(value = "/findpwd4", method = RequestMethod.GET)
	public String findPassWord4Page() {
		return "security/login/findpwd4";
	}
}
