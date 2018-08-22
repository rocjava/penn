package com.penn.common.filter;

import com.penn.common.util.ApplicationContextUtil;
import com.penn.common.wx.WeixinAccreditAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 实现请求路径拦截器，用于校验当前用户是否允许访问
 * 
 * @author YangKui
 * 
 */
public class AccessSecurityFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(AccessSecurityFilter.class);
	/**
	 * ant风格路径匹配器
	 */
	private AntPathMatcher matcher = new AntPathMatcher();

	/**
	 * 需要用户身份才能访问的url列表
	 */
	private List<String> accessUrls;

	/**
	 * 交易请求地址，对于该地址的请求会判断交易号是否在给定的交易号列表当中，如果不在其中则不允许访。
	 */
	private String transactionUrl;
	/**
	 * 需要用户登录后才能访问的交易接口号
	 */
	private List<String> transCodes;

	/**
	 * 默认的登录页面地址，当用户访问了不允许访问的地址后会自动重定向到该地址
	 */
	private String loginURL;
	/**
	 * 
	标识当前类当中的属性是否已经初始化，由于无法直接通过spring注解的方式获取定义的bean,
	所以通过在第一次访问的时候来主动加载
	 */
	private boolean status;
	
	/**
	 * 用于跳转微信授权页面的url--首页
	 * */
	private String accreditUrl;

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
		if(!status){
			this.initProperties();
		}
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		String uri = servletRequest.getRequestURI();
		String page=servletRequest.getParameter("mark");

		logger.info("--wx uri:{"+uri+"}");
		//对从微信授权页面来的URL进行拦截，获取code
		if (matcher.match(accreditUrl, uri)) {
			WeixinAccreditAccess.accredit(servletRequest, servletResponse);
			return;
		}

		//微信回调
		if (matcher.match("/**/callback.do**", uri)) {
			String openId= WeixinAccreditAccess.requestOpenId(servletRequest);
			/**
			 * 或者openid可以实现自动登录，不过系统暂时不需要 //TODO
			 */
			if(StringUtils.isEmpty(page)){
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.do");
			}else if("lawyer".equals(page)){
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/lawyer/list.do");
			}else if("cop".equals(page)){
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/lawyer/cop.do");
			}else{
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.do");
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
	
	private void initProperties(){
		AccessSecurityFilter filter = (AccessSecurityFilter) ApplicationContextUtil.getBean("accessSecurityFilter");
		this.accessUrls = filter.getAccessUrls();
		this.loginURL = filter.getLoginURL();
		this.transactionUrl = filter.getTransactionUrl();
		this.transCodes = filter.getTransCodes();
		this.accreditUrl = filter.getAccreditUrl();
	}
	
	public List<String> getAccessUrls() {
		return accessUrls;
	}

	public String getTransactionUrl() {
		return transactionUrl;
	}

	public List<String> getTransCodes() {
		return transCodes;
	}

	public String getLoginURL() {
		return loginURL;
	}

	public void setAccessUrls(List<String> accessUrls) {
		this.accessUrls = accessUrls;
	}

	public void setTransactionUrl(String transactionUrl) {
		this.transactionUrl = transactionUrl;
	}

	public void setTransCodes(List<String> transCodes) {
		this.transCodes = transCodes;
	}

	public void setLoginURL(String loginURL) {
		this.loginURL = loginURL;
	}

	public String getAccreditUrl() {
		return accreditUrl;
	}

	public void setAccreditUrl(String accreditUrl) {
		this.accreditUrl = accreditUrl;
	}
	
}
