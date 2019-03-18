package com.nari.slsd.gglck.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获得HttpSession对象
 */
public class HttpSessionFilter implements Filter
{
	private static final ThreadLocal<HttpSession> threadSession = new ThreadLocal<HttpSession>();
	@Override
	public void destroy()
	{
		threadSession.remove();
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		threadSession.set (((HttpServletRequest)request).getSession());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}

	/**
	 * 获得HttpSession中的对象
	 * @param key
	 * @return
	 */
	public static Object getSessionValue(String key)
	{
		return getSession().getAttribute(key);
	}
	/**
	 * 放置对象到HttpSession中
	 * @param key
	 * @param value
	 */
	public static void putSessionValue(String key,Object value)
	{
		getSession().setAttribute(key, value);
	}

	
	/**
	 * 获得HttpSession对象
	 * @param key
	 * @param value
	 */
	public static HttpSession getSession()
	{
		return threadSession.get();
	}
	
}
