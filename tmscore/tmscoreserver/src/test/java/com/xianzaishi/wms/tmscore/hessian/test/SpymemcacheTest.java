package com.xianzaishi.wms.tmscore.hessian.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.wms.base.test.BaseTest;
import com.xianzaishi.wms.common.memcache.ICacheOperator;

@ContextConfiguration(locations = "classpath:spring/ac-tmscore-Memcache.xml")
public class SpymemcacheTest extends BaseTest {

	@Autowired
	private ICacheOperator cacheOperator = null;

	@Test
	public void addTest() {
		Boolean flag = cacheOperator.add("1", "asfjjf", 50);
		System.out.println(flag);
		flag = cacheOperator.add("1", "jsajf", 50);
		System.out.println(false);
		System.out.println(cacheOperator
				.get("00000001000000000001010000000000"));
		cacheOperator.delete("00000001000000000001010000000000");
		System.out.println(cacheOperator
				.get("00000001000000000001010000000000"));
	}

	public ICacheOperator getCacheOperator() {
		return cacheOperator;
	}

	public void setCacheOperator(ICacheOperator cacheOperator) {
		this.cacheOperator = cacheOperator;
	}

}
