/**
 * 
 */
package com.penn.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author penn
 * 
 */
public class ApaMemcachedClient {
	private static Logger logger = Logger.getLogger(ApaMemcachedClient.class);

	private static int EXPIRE = 24 * 60 * 60;// 24小时,xmemcached对应的是秒
	public static int EXPIRE_5M = 5 * 60;// 5分钟,xmemcached对应的是秒
	public static int EXPIRE_1M = 1 * 60; // 1分钟,xmemcached对应的是秒
	private MemcachedClient mc;

	/** 获取原始client */
	public MemcachedClient getClient() {
		return mc;
	}
	
	public ApaMemcachedClient() {
	}

	public ApaMemcachedClient(MemcachedClient client) {
		mc = client;
	}

	public <T> T get(final String key) {
		try {
			return mc.get(key);
		} catch (Exception e) {
			logger.error("memcached get error:key=" + key, e);
		}
		return null;
	}

	public boolean replace(final String key, final Object value, int timeout) {
		try {
			return mc.replace(key, timeout, value);
		} catch (Exception e) {
			logger.error("memcached replace error:key=" + key, e);
		}
		return false;
	}

	public boolean replace(final String key, final Object value) {
		return replace(key, value, EXPIRE);
	}

	public boolean add(final String key, final Object value, int timeout) {
		try {
			return mc.add(key, timeout, value);
		} catch (Exception e) {
			logger.error("memcached add error:key=" + key, e);
		}
		return false;
	}

	public boolean add(final String key, final Object value) {
		return add(key, value, EXPIRE);
	}
	
	public boolean set(final String key, final Object value, int timeout) {
		try {
			return mc.set(key, timeout, value);
		} catch (Exception e) {
			logger.error("memcached set error:key=" + key, e);
		}
		return false;
	}

	public boolean set(final String key, final Object value) {
		return set(key, value, EXPIRE);
	}

	public boolean delete(final String key) {
		try {
			return mc.delete(key);
		} catch (Exception e) {
			logger.error("memcached delete error:key=" + key, e);
		}
		return false;
	}

	public void shutdown() throws IOException {
		mc.shutdown();
	}
	
	public void flushAll() throws IOException{
		try {
			mc.flushAll();
		} catch (TimeoutException e) {
			logger.error("memcached flushAll error:", e);
		} catch (InterruptedException e) {
			logger.error("memcached flushAll error:", e);
		} catch (MemcachedException e) {
			logger.error("memcached flushAll error:", e);
		}
	}
}
