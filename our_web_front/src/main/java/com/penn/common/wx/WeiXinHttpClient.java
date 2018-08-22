/**
 * Project Name:大地保险微信互动平台
 * File Name:WeiXinHttpClient.java
 * Package Name:cn.newtouch.weichat.transaction.util
 * Date:2014年4月23日上午8:50:37
 * Copyright (c) 2014, NEWTOUCH Co., Ltd.  All Rights Reserved.
 *
*/

package com.penn.common.wx;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;


/**
 * ClassName:WeiXinHttpClient <br/>
 * Date:     2014年4月23日 上午9:10:37 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class WeiXinHttpClient {
	
	public static String METHOD_POST = "POST";
	public static String METHOD_GET = "GET";
	
	private static String proxySign;

	
	/**
	 * 
	 * send:(调用微信接口公共方法). <br/>
	 *
	 * @param requestUrl	请求地址
	 * @param requestMethod	请求方式（GET、POST）
	 * @param jsonString	提交的数据
	 * @return
	 * @since JDK 1.6
	 */
	public static String send(String requestUrl,String requestMethod,String jsonString){
		String json = null;
		StringBuffer buffer = new StringBuffer();
		
		HttpURLConnection httpUrlConn=null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(requestUrl);
//            if("0".equals(proxySign)){// 不使用代理
            	httpUrlConn = (HttpURLConnection) url.openConnection();
//            }else{// 使用代理
//            	Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP,
//    					new InetSocketAddress("10.1.31.171", 8080));
//    			httpUrlConn = (HttpURLConnection) url.openConnection(proxy);
//
//            }
            //设置超时
            httpUrlConn.setConnectTimeout(30000);//连接主机的超时时间（单位：毫秒）
            httpUrlConn.setReadTimeout(30000);//从主机读取数据的超时时间（单位：毫秒）
            
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != jsonString) {
                outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(jsonString.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            json = buffer.toString();

        } catch (ConnectException ce) {

            json=null;
        } catch (Exception e) {

            json=null;
        }finally{
        	try {
        		if(bufferedReader!=null){
        			bufferedReader.close();
        		}
        	} catch (IOException e) {

        	}
        	
        	try {
	            if(inputStreamReader!=null){
	            	inputStreamReader.close();
	            }
        	} catch (IOException e) {

        	}
        	
        	try {
	            if(inputStream!=null){
	            	inputStream.close();
	            }
        	} catch (IOException e) {

        	}
        	
        	try {
	            if(outputStream!=null){
	            	outputStream.close();
	            }
        	} catch (IOException e) {

        	}
        	
            if(httpUrlConn!=null){
            	httpUrlConn.disconnect();
            }
        }

		return json;
	}

	public static void main(String[] q){
		String url="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=6_vHfTcWjy201ThV6bYcKYDQIHaYPu-lAcbznvLE1l8rVGf-G0zIWTzNCkvThdEHn0nbH8TFDxktik9mnNxPSSzk6oTZ8sQ-uBgA6n33aBGj9htCkpSUUXr4n6vY1G0BBfDe-gnnW8TvPpnnFfDEJdAJAQRW";
		String src = "{\"button\":[{\"name\":\"微门店\",\"sub_button\":[{\"name\":\"测试2\",\"type\":\"view\",\"url\":\"www.baidu.com\"}]},{\"name\":\"我\",\"type\":\"view\",\"url\":\"about:blank\"},{\"name\":\"热门服务\",\"sub_button\":[{\"name\":\"优惠活动\",\"type\":\"view\",\"url\":\"about:blank\"},{\"name\":\"页面原型\",\"type\":\"click\",\"key\":\"http://211.144.206.30:7081/eb-mobile/mobile/resource/ui/home/weiwebsite-home.html\"}]}]}";
		String content = "{\n" +
				"     \"kf_account\" : \"windystory1076\",\n" +
				"     \"nickname\" : \"客服1\",\n" +
				"     \"password\" : \"tryagain121\",\n" +
				"}";
		String json = WeiXinHttpClient.send(url, WeiXinHttpClient.METHOD_POST, content);
		System.out.println(json);
	}
	
	public static String getProxySign() {
		return proxySign;
	}

	public void setProxySign(String proxySign) {
		this.proxySign = proxySign;
	}
	
}

