
package com.nari.slsd.gglck.util;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nari.slsd.gglck.biz.cache.CargoCache;
import com.nari.slsd.gglck.biz.cache.DictionaryCache;
import com.nari.slsd.gglck.biz.cache.LockInfoCache;
import com.nari.slsd.gglck.biz.cache.StationCache;
import com.nari.slsd.gglck.biz.cache.SystemParamCache;
import com.nari.slsd.gglck.biz.cache.UserCache;
import com.nari.slsd.gglck.dao.DictionaryDao;



/**
 * 扩展spring的ContextLoaderListener
 */
public class ExtendContextLoaderListener extends ContextLoaderListener
{
	
	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		super.contextInitialized(event);
		ServletContext servletContext = event.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ContextUtil.setApplicationContext(applicationContext);
		//加载config.properties文件
		PropertiesConfig.getInstance();
		DictionaryCache.getInstance();
		CargoCache.getInstance();
		SystemParamCache.getInstance();
		UserCache.getInstance();
		LockInfoCache.getInstance();
		
//		DictionaryDao dictionaryDao = (DictionaryDao)ContextUtil.getBean("dictionaryDao");
//		List<Map<String, Object>> dictionaryList = dictionaryDao.getAllDictionaryForCache();
//		for(Map<String, Object> a : dictionaryList){
//			dictionaryDao.updateDictionary1(a.get("dictId").toString());
//		}
		
		StationCache.getInstance();
		
		//BillingHandler.getInstance();
		//启动定时任务
		//AutoUnregisterTimer.getInstance();
	}
}
