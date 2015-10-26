package com.witsafe.contracts.common.executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.witsafe.contracts.common.util.ehcache.EHCacheUtil;



public class InstantiationTracingBeanPostProcessor implements
		ApplicationListener<ContextRefreshedEvent> {
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
		initMenuLink();

		// 初始化：价格更新任务到缓存
		initPriceUpdateJobList();

		// 初始化：加载银联支付的属性文件
		//SDKConfig.getConfig().loadPropertiesFromSrc();// 从classpath加载acp_sdk.properties文件

		// 初始化：加载支付回调的属性文件
		initUnionPayProperties(event);
	}

	public void initPriceUpdateJobList() {
		List<Object> jobList = null;
		if (jobList == null)
			return;
		EHCacheUtil.initCacheManager();
		EHCacheUtil.put("jobList", jobList);
	}

	public void initMenuLink() {
		List<Object> menuLink = null;
		List<Object> brandList = null;
		List<Object> factoryList = null;

		try {
			//menuLink = bspProductsService.generateProductLink(0, "");
			// factoryList = bspProductsService.getFactoryListByAreaId(id);
		} catch (Exception e) {

		}
		if (menuLink == null)
			return;

		// 初始化--必须
		EHCacheUtil.initCacheManager();
		EHCacheUtil.put("menuLink", menuLink);
		// 区域品牌关联信息
		EHCacheUtil.put("brandList", brandList);
		// 区域品牌产地关联信息
		EHCacheUtil.put("factoryList", factoryList);
	}



	public void initUnionPayProperties(ContextRefreshedEvent event) {
		String path = "";
		try {
			path = event
					.getApplicationContext()
					.getResource(
							"/WEB-INF/classes/unionpay/unionpay.properties")
					.getFile().getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 装载配置文件的通知地址
		Properties prop = new Properties();
		String merId = "", frontUrl = "", backUrl = "";
		try {
			prop.load(new FileInputStream(path));
			frontUrl = prop.getProperty("frontReceiveUrl");
			backUrl = prop.getProperty("backReceiveUrl");
			merId = prop.getProperty("merId");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}