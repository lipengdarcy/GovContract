package com.witsafe.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.dao.security.SecUserMapper;
import com.witsafe.framework.utils.Digests;
import com.witsafe.framework.utils.EncodeUtils;
import com.witsafe.model.security.SecUser;
import com.witsafe.model.security.SecUserExample;

/**
 * 用户管理类
 * 
 * @author lipeng
 */
@Component
public class UserManager {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	@Autowired
	private SecUserMapper secUserMapper;

	/**
	 * 根据用户id，获取用户实体
	 * 
	 * @param id
	 * @return SecUser
	 */
	public SecUser get(Integer id) {
		return secUserMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据用户id，删除用户实体
	 * 
	 * @param id
	 */
	public int delete(Integer id) {
		return secUserMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 保存、更新用户实体
	 * 
	 * @param entity
	 */
	public void save(SecUser entity) {
		secUserMapper.updateByPrimaryKey(entity);
	}

	/**
	 * 根据用户名称，获取用户实体
	 * 
	 * @param username
	 * @return
	 */
	public SecUser findUserByName(String username) {

		SecUserExample e = new SecUserExample();
		e.or().andUsernameEqualTo(username);
		List<SecUser> list = secUserMapper.selectByExample(e);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	/**
	 * 根据用户ID查询该用户所拥有的权限列表
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAuthoritiesName(Integer userId) {
		return secUserMapper.getAuthoritiesName(userId);
	}

	/**
	 * 根据用户ID查询该用户所拥有的角色列表
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getRolesName(Integer userId) {

		return secUserMapper.getRolesName(userId);
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(SecUser user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(EncodeUtils.hexEncode(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainpassword().getBytes(),
				salt, HASH_INTERATIONS);
		user.setPassword(EncodeUtils.hexEncode(hashPassword));
	}

}
