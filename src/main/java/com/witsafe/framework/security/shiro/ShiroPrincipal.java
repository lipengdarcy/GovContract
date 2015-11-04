package com.witsafe.framework.security.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.witsafe.contracts.model.security.SecUser;

/**
 * 自定义认证主体
 */
public class ShiroPrincipal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1428196040744555722L;
	//用户对象
	private SecUser user;
	//用户权限列表
	private List<String> authorities = new ArrayList<String>();
	//用户角色列表
	private List<String> roles = new ArrayList<String>();
	//是否已授权。如果已授权，则不需要再从数据库中获取权限信息，减少数据库访问
	//这里会导致修改权限时，需要重新登录方可有效
	private boolean isAuthorized = false;
	
	/**
	 * 构造函数，参数为User对象
	 * 根据User对象属性，赋值给Principal相应的属性上
	 * @param user
	 */
	public ShiroPrincipal(SecUser user) {
		this.user = user;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public boolean isAuthorized() {
		return isAuthorized;
	}
	public void setAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	public SecUser getUser() {
		return user;
	}
	public void setUser(SecUser user) {
		this.user = user;
	}
	public String getUsername() {
		return this.user.getUsername();
	}
	public Integer getId() {
		return this.user.getId();
	}
	/**
	 * <shiro:principal/>标签显示中文名称
	 */
	@Override
	public String toString() {
	    return this.user.getFullname();
	}
}