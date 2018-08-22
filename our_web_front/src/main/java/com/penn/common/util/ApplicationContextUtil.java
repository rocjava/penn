package com.penn.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 获取spring 应用上下文工具类，用于某些类需要直接通过代码获取spring bean提供方便的工具类。
 * 
 * @author YangKui
 * 
 */
public class ApplicationContextUtil implements ApplicationContextAware {
	private static Logger logger = LoggerFactory.getLogger(ApplicationContextUtil.class);
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		if (this.applicationContext != null) {
			logger.error("初始化ApplicationContextUtil异常！");
			throw new IllegalStateException("applicationContext已存在，无法再次初始化！");
		}
		this.applicationContext = context;
	}

	/**
	 * 根据bean名称获取Bean实例
	 * @param beanName spring bean名称
	 * @return
	 */
	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	public static ApplicationContext getApplicationContext() {
		if(applicationContext==null){
			throw new IllegalStateException("applicationContext为空");
		}
		return applicationContext;
	}
	
	public static <T> Map<String,T> getBeansOfType(Class<T> clazz){
		return getApplicationContext().getBeansOfType(clazz);
	}
	
	public static Object getCglibProxyTargetObject(Object proxy) throws Exception {  
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");  
        h.setAccessible(true);  
        Object dynamicAdvisedInterceptor = h.get(proxy);  
          
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");  
        advised.setAccessible(true);  
          
        Object target = ((AdvisedSupport)advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();  
        return target;  
	}
	
	public static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {  
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");  
        h.setAccessible(true);  
        AopProxy aopProxy = (AopProxy) h.get(proxy);  
          
        Field advised = aopProxy.getClass().getDeclaredField("advised");  
        advised.setAccessible(true);  
          
        Object target = ((AdvisedSupport)advised.get(aopProxy)).getTargetSource().getTarget();  
          
        return target;  
    }
}
