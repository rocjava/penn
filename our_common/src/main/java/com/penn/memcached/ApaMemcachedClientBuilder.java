/**
 * 
 */
package com.penn.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * MemcachedClient 构造器
 */
public class ApaMemcachedClientBuilder {

	private static Logger logger = Logger.getLogger(ApaMemcachedClientBuilder.class);

	private String servers;

	private boolean failover = true;

	public ApaMemcachedClient build() {

		ApaMemcachedClient tntClient = null;

		if ( StringUtils.isNotBlank(servers) ) {
			try {
				MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddressMap(servers));
				// builder.setConnectionPoolSize(5);
				builder.setFailureMode(failover);// 启用主备,必须设置该属性
				// repcached-2.3.1-1.4.13.patch.gz不支持该模式同步
				// builder.setCommandFactory(new BinaryCommandFactory());
				builder.setSessionLocator(new KetamaMemcachedSessionLocator());//一致性hash
				MemcachedClient mc = builder.build();
				tntClient = new ApaMemcachedClient(mc);
			} catch (Exception e) {
				logger.error("init MemcachedClient error", e);
			}
		} else {
			logger.warn("please set memcache servers!");
		}
		return tntClient;
	}

	public void setServers(String servers) {

		this.servers = servers;
	}

	public void setFailover(boolean failover) {

		this.failover = failover;
	}
}
