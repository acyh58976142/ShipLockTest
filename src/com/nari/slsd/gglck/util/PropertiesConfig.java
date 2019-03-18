package com.nari.slsd.gglck.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * config.properties文件配置项读取
 */
public class PropertiesConfig
{
	private static Logger LOG = Logger.getLogger(PropertiesConfig.class);

	private static PropertiesConfig propertiesConfig;
	private Properties properties;

	private PropertiesConfig()
	{
		properties = new Properties();
		try
		{
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ggConfig.properties");
			properties.load(inputStream);
		}
		catch(Exception e)
		{
			LOG.error(e);
			throw new RuntimeException(e);
		}
	}
	public static PropertiesConfig getInstance()
	{
		if(propertiesConfig == null)
		{
			propertiesConfig = new PropertiesConfig();
		}
		return propertiesConfig;
	}
	/**
	 * 读取配置值
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
}
