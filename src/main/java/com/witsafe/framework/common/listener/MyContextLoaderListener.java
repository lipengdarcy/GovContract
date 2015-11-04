package com.witsafe.framework.common.listener;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import com.witsafe.framework.common.cache.CacheOperater;


@Component
public class MyContextLoaderListener extends ContextLoaderListener {

	private Logger loggerinfo = Logger.getLogger("InfoLogger");

	/**
	 * @description 重写ContextLoaderListener的contextInitialized方法
	 */
	public void contextInitialized(ServletContextEvent event) {
		loggerinfo.info("==========[ContextLoaderListener] Start...");
		super.contextInitialized(event);

		CacheOperater.getInstance().initCacheDate();
		System.out
				.println("------MyContextLoaderListener.getCurrentWebApplicationContext()---------"
						+ MyContextLoaderListener
								.getCurrentWebApplicationContext());
		loggerinfo.info("==========[ContextLoaderListener] End...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		closeWebApplicationContext(event.getServletContext());
		CacheOperater.getInstance().initCacheDate();

	}

}
