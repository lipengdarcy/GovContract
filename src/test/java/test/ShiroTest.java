package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;


public class ShiroTest {
	
	public static void main(String[] args) {

	    //log.info("My First Apache Shiro Application");

	    //1.
	    Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

	    //2.
	    SecurityManager securityManager = (SecurityManager) factory.getInstance();

	    //3.
	    SecurityUtils.setSecurityManager((org.apache.shiro.mgt.SecurityManager) securityManager);

	    System.exit(0);
	}

}
