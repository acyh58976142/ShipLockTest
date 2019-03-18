package com.nari.slsd.gglck.util;

/**
 * 
 * @类名:Constants
 * @类功能说明:系统常量类
 */
public class Constants {

	/**
	 * 微信注册随机码短信内容
	 */
	public final static String RANDOMVALIDATECONTENT = "[vesselName]正在进行微信船舶绑定，本次操作验证码为：[random]，请勿将此验证码告诉他人。【高港船闸】";
	/**
	 * 缴费超时系统自动注销
	 */
	public final static String FEE_TIMEOUT = "缴费超时系统自动注销";
	
	/**
	 * 微信登记人UUID
	 */
	public final static String WECHAT_UUID = "00000000000000000000000000000000";
	
	/**
	 * 船舶图片
	 */
	public final static String VESSELPICTURE = "vesselPicture";
	
	
	/**
	 * 超载计算系数  
	 */
	public final static double basic = 1.0;
	/**
	 * 普单超载50%计算系数  
	 */
	public final static double general_over50 = 1.5;
	/**
	 * 普单超载100%计算系数  
	 */
	public final static double general_over100 = 1.8;
	/**
	 * 危单超载50%计算系数  
	 */
	public final static double danager_over50 = 1.6;
	/**
	 *  危单超载100%计算系数  
	 */
	public final static double danager_over100 = 2.2;
	/**
	 * 普队超载50%计算系数   
	 */
	public final static double general_fleet_over50 = 1.6;
	/**
	 * 普队超载100%计算系数   
	 */
	public final static double general_fleet_over100 = 2.2;
	/**
	 *危队超载50%计算系数   
	 */
	public final static double danager_fleet_over50 = 1.8;
	/**
	 * 危队超载100%计算系数  
	 */
	public final static double danager_fleet_over100 = 2.2;
	
}
