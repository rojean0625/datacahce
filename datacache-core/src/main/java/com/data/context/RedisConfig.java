package com.data.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
@PropertySource("classpath:/redis.properties")
public class RedisConfig {
	@Value("${redis.host}")
	private String hostName;
	@Value("${redis.port}")
	private String port;
	@Value("${redis.master.name}")
	private String masterName;
	@Value("${redis.password}")
	private String password;
	@Value("${redis.dbIndex}")
	private int dbIndex;
	@Value("${redis.connection.timeout}")
	private int connTimeout;
	@Value("${redis.pool.maxTotal}")
	private int maxTotal;
	@Value("${redis.pool.minIdle}")
	private int minIdle;
	@Value("${redis.pool.maxIdle}")
	private int maxIdle;
	@Value("${redis.pool.maxWaitMillis}")
	private long maxWaitMillis;
	@Value("${redis.pool.blockWhenExhausted}")
	private boolean blockWhenExhausted;
	@Value("${redis.pool.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${redis.pool.testOnReturn}")
	private boolean testOnReturn;
	@Value("${redis.pool.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${redis.pool.minEvictableIdleTimeMillis}")
	private long minEvictableIdleTimeMillis;
	@Value("${redis.pool.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;
	@Value("${redis.pool.numTestsPerEvictionRun}")
	private int numTestsPerEvictionRun;
	@Value("${redis.pool.softMinEvictableIdleTimeMillis}")
	private long softMinEvictableIdleTimeMillis;
	@Value("${redis.pool.lifo}")
	private boolean lifo;

	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(10);
		return jedisPoolConfig;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory fac = new JedisConnectionFactory();
		fac.setHostName("127.0.0.1");
		fac.setPassword("12345");
		fac.setPort(6379);
		fac.setPoolConfig(jedisPoolConfig());
		return fac;
	}
//
//	@Bean
//	public RedisTemplate redisTemplate(){
//		RedisTemplate temp = new RedisTemplate();
//		temp.setConnectionFactory(jedisConnectionFactory());
//		return temp;
//	}
}
