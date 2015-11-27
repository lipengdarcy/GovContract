package com.witsafe.controller.security;

import java.text.MessageFormat;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.witsafe.framework.common.Constant;
import com.witsafe.model.common.ResponseData;
import com.witsafe.model.security.SecUser;

/**
 * 系统登录Controller
 */
@Controller
public class LoginController {
	private static Log log = LogFactory.getLog(LoginController.class);

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseData<String> login(SecUser user, Model model,
			HttpServletRequest request) {
		log.info("Login user=====" + user.getUsername());

		ResponseData<String> r = new ResponseData<String>();

		Subject subject = SecurityUtils.getSubject();
		// 1、收集实体/凭据信息
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		String remember = WebUtils.getCleanParam(request, "remember");
		log.info("remember=" + remember);

		try {
			if (remember != null && remember.equalsIgnoreCase("1")) {
				token.setRememberMe(true);
			}
			// 2、提交实体/凭据信息
			subject.login(token);
			String message = MessageFormat.format(
					Constant.bundle.getString(Constant.user_login_success),
					user.getUsername());
			r.setContent(message);
			return r;
		} catch (UnknownAccountException ue) {
			token.clear();
			r.setCode(-1);
			r.setContent(ue.getMessage());
			return r;
		} catch (IncorrectCredentialsException ie) {
			token.clear();
			r.setCode(-2);
			String message = Constant.bundle
					.getString(Constant.user_password_error);
			r.setContent(message);
			return r;
		} catch (RuntimeException re) {
			token.clear();
			r.setCode(-3);
			r.setContent(re.getMessage());
			return r;
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
			String message = MessageFormat.format(
					Constant.bundle.getString(Constant.user_login_success),
					userName);			
			log.info(message);
		}
		return "redirect:/login";
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
