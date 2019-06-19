/** 
 * <pre>项目名称:ssm-area-yfz 
 * 文件名称:ConstantConf.java 
 * 包名:com.jk.yfz 
 * 创建日期:2019年3月8日下午3:10:40 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */
package com.jk.utlis;


/** 
 * <pre>项目名称：ssm-area-yfz    
 * 类名称：ConstantConf    
 * 类描述：    
 * 创建人：姚法祯
 * 创建时间：2019年3月8日 下午3:10:40    
 * 修改人：姚法祯
 * 修改时间：2019年3月8日 下午3:10:40    
 * 修改备注：       
 * @version </pre>    
 */
public class ConstantConf {
public static final String WEATHER_PATH="http://t.weather.sojson.com/api/weather/city";//天气路径
public static  String WEATHER_RESULT="今天是{0}，{1},天气{2},{3},{4},风力{5},风向{6},日出时间{7},日落时间{8},注意{9}";//今日天气
public static final String LOGISTICS_PATH="http://www.kuaidi100.com/query";//物流地址
public static String LOGISTICS_RESULT="{0},{1},{2},{3},{4}";
public static final String ROBOT_PAHT="http://api.qingyunke.com/api.php";//机器人路径
/*public static final String ACCOUNTSID = "eebdcd3384a44617908ce9bc09740466";//短信
public static final String AUTH_TOKEN = "cd598f21cf6140c0847a9d88bd3e0868";//短信
public static final String TEMPLATEID = "1460493373";//模板ID
public static final  String  SMS_URL="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//短信接口地址
public static final String SMS_SUCCESS="00000";*/
public  static  final  String  SMS_URL="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//短信接口地址
public static final String ACCOUNTSID = "0374867b2c1844dbbe0bf019bf0def28";
public static final String AUTH_TOKEN = "d05d06f418974fc6aceb9233e38b7539";
public static final String TEMPLATEID = "164547838";//模板
public static final String SMS_SUCCESS="00000";
public static final String SMS_LOGIN_CODE="dlyzm";//短信验证码缓存
public static final Integer SMS_LOGIN_CODE_TIME_OUT=60;//短信验证码有效时间
public static final Integer SMS_LOGIN_LOCK_TIME_OUT=1;//短信验证码锁一分钟
public static final String SMS_LOGIN_LOCK="lock";//短信验证码不到一分钟不能再次获取的锁
/*public static final String USERS_POWER_LIST="usersPowerList";//用户权限列表
public static final String USERS_NAV_LIST="usersNavList";//树列表
public static final Integer WEATHER_TIME_OUT=60;//天气缓存的时间
public static final Integer DEPT_TIME_OUT=30;//下拉树缓存保存时间
public static final String DEPT_KEY="daptList";//下拉树
public static final String AREA_CACHE_KEY="area";//省市
public static final Integer AREA_CACHE_TIME=1;//省市 缓存时间1天
public static CheckLoginBean checkLoginBean = null;//用于调用接口看用户是否在线*/


}
