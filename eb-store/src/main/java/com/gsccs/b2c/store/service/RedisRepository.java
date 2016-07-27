package com.gsccs.b2c.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Repository for key/value pairs of type String/Object.
 * 
 * @author x.d zhang
 */
public class RedisRepository<T> {

	@Autowired
	private RedisTemplate<String, T> template;

	public void add(String key, T t) {
		template.opsForValue().set(key, t);
	}

	
	public T get(String key) {
		return template.opsForValue().get(key);
	}

}
