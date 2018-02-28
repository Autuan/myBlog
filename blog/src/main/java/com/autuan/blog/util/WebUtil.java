package com.autuan.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName:  WebUtil   
 * @Description:TODO 工具类 取当前时间 取ip地址    
 * @author: 于先知(AutuanYu) 
 * @date:   2017年12月1日 下午9:39:13   
 *     
 * @Copyright: 2017 github.com/Autuan Inc. All rights reserved. 
 * 注意：本内容仅限于学习使用
 */
public class WebUtil {
	/**
	 * 
	 * @Title: getCurrentTime   
	 * @Description: TODO 时间戳    
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getCurrentTime() {
		 Date date = new Date();
		 String str = null;
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 str = df.format(date);
		 return str;
	}
	
	/**
	 * 
	 * @Title: getCurrentTime   
	 * @Description: TODO 时间戳    
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getCurrentTimeNoMark() {
		Date date = new Date();
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		str = df.format(date);
		return str;
	}
	
	/**
	 * 
	 * @Title: getCurrentIp   
	 * @Description: TODO  ip 地址  
	 * @param: @param request
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getCurrentIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
	}
	
	/**
	 * 
	 * @Title: encipherTel   
	 * @Description: TODO 加密方法
	 *  1:a005 2:e56f 3:eds5 4:qwe9 5:pwo0
	 *  6:zz99 7:qw86 8:98sl 9:bd8g 0:t33z   
	 * @param: @param tel
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String encipherTel(String tel) {
		String head = tel.substring(0,3);
		String body = tel.substring(3,7);
		String foot = tel.substring(7);
		body = "-" + encipherBody(body) + "-";
		
		return head+body+foot;
	}
	
	public static String brokeTel(String tel) {
		Integer endIndex = tel.lastIndexOf("-");
		String head = tel.substring(0,3);
		String foot = tel.substring(endIndex+1);
		String body = tel.substring(4,endIndex);
		body = brokeBody(body);
		return head+body+foot;
	}
	
	private static String encipherBody(String body) {
		String afterEncipher = "";
		for (int i=0;i<body.length();i++) {
			String tempChar = body.substring(i,i+1);
			switch (tempChar) {
				case "1":afterEncipher+="a005"+"i";break;
				case "2":afterEncipher+="e56f"+"i";break;
				case "3":afterEncipher+="eds5"+"i";break;
				case "4":afterEncipher+="qwe9"+"i";break;
				case "5":afterEncipher+="pwo0"+"i";break;
				case "6":afterEncipher+="zz99"+"i";break;
				case "7":afterEncipher+="qw86"+"i";break;
				case "8":afterEncipher+="98sl"+"i";break;
				case "9":afterEncipher+="bd8g"+"i";break;
				case "0":afterEncipher+="t33z"+"i";break;
			}
		}
		return afterEncipher;
	}
	
	private static String brokeBody(String body) {
		String[] eachs = body.split("i");
		String returnString = "";
		for (String each : eachs) {
			if (each.equals("a005")) { returnString += "1"; }
			else if (each.equals("e56f")) { returnString += "2"; }
			else if (each.equals("eds5")) { returnString += "3"; }
			else if (each.equals("qwe9")) { returnString += "4"; }
			else if (each.equals("pwo0")) { returnString += "5"; }
			else if (each.equals("zz99")) { returnString += "6"; }
			else if (each.equals("qw86")) { returnString += "7"; }
			else if (each.equals("98sl")) { returnString += "8"; }
			else if (each.equals("bd8g")) { returnString += "9"; }
			else if (each.equals("t33z")) { returnString += "0"; }
			
		}
		return returnString;
	}
}
