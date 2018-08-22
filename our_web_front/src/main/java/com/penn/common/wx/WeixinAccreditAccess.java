package com.penn.common.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.penn.common.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


/**
 *@author zhengyy
 *@date 2016年1月26日下午6:56:18
 * 微信请求接口处理
 */

public class WeixinAccreditAccess {
	
	private static Logger logger = LoggerFactory.getLogger(WeixinAccreditAccess.class);
	
	private static String appId;//公众号的唯一标识
	
	private static String appSecret;//公众号的appsecret

	private static String codeUrl;//获取用户code的第三方请求地址
	
	private static String callBackUrl;//本机服务器地址
	
	private static String openIdUrl;//获取用户openId的第三方请求地址

	public static void accredit(ServletRequest request, ServletResponse response) throws IOException{
		HttpServletResponse sRes = (HttpServletResponse) response;
		//进行编码，防止乱码
		logger.info("-- callBackUrl:{"+callBackUrl+"}");
		logger.info("-- mark:{"+request.getParameter("mark")+"}");
		logger.info("-- redirectUrl:{"+callBackUrl+"?mark="+request.getParameter("mark")+"}");
		String redirectUrl = URLEncoder.encode(callBackUrl+"?mark="+request.getParameter("mark"),"utf-8");
		//拼接获取code地址
		String cUrl = codeUrl.replace("CORPID", appId).replace("redirect_url", redirectUrl);
		logger.info("-- codeUrl:{"+cUrl+"}");
		//发送请求
		sRes.sendRedirect(cUrl);
	}
	
	public static String requestOpenId(ServletRequest request){
		HttpServletRequest sReq = (HttpServletRequest) request;
		String openid ;
		String code = sReq.getParameter("code");
		logger.info("GET code:{"+code+"}");
		if(StringUtils.isBlank(code)){
			return null;
		}
		String url = openIdUrl.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		String result = WeiXinHttpClient.send(url, WeiXinHttpClient.METHOD_GET, null);
		if(StringUtils.isBlank(result)){
			return null;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		if(!jsonObject.containsKey(Constants.SESSION_KEY_OPEN_ID)){
			return null;
		}
		openid = jsonObject.getString(Constants.SESSION_KEY_OPEN_ID);
		logger.info("GET openid:{"+openid+"}");
		return openid;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}

	public void setOpenIdUrl(String openIdUrl) {
		this.openIdUrl = openIdUrl;
	}


	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	
}
