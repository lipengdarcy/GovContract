package com.witsafe.framework.common;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Constant {
	
	public static final String ACCOUNT_SESSION_UID = "account_session_uid"; //登陆用户id
	
	public static final String ACCOUNT_SESSION_VCODE = "account_session_vcode"; //登录验证码
	
	
	
	public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	
	
	//错误信息提示
	public static final ResourceBundle bundle = ResourceBundle.getBundle("Message",
			Locale.getDefault());
	

	public static final String username_cannotbe_null = "username_cannotbe_null"; 
	public static final String get_user_failed = "get_user_failed"; 
	public static final String user_not_exist = "user_not_exist"; 
	public static final String user_password_error = "user_password_error"; 
	public static final String user_forbidden = "user_forbidden"; 
	public static final String user_login_success = "user_login_success"; 
	public static final String user_logout_success = "user_logout_success"; 
	
	
	


}
