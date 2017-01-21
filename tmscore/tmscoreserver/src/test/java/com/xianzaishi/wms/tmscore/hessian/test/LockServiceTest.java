package com.xianzaishi.wms.tmscore.hessian.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.wms.base.test.BaseTest;
import com.xianzaishi.wms.common.lock.ILockService;
import com.xianzaishi.wms.common.memcache.ICacheOperator;

@ContextConfiguration(locations = "classpath:spring/ac-tmscore-Memcache.xml")
public class LockServiceTest extends BaseTest {

	@Autowired
	private ILockService lockService = null;
	@Autowired
	private ICacheOperator cacheOperator = null;

	@Test
	public void addTest() {
		Boolean flag = lockService.lock("1", "abc");
		System.out.println(flag);
		System.out.println(cacheOperator.get("1"));
		flag = lockService.release("2", "abc");
		System.out.println(flag);
		System.out.println(cacheOperator.get("1"));
		flag = lockService.release("1", "bcd");
		System.out.println(flag);
		System.out.println(cacheOperator.get("1"));
		flag = lockService.release("1", "abc");
		System.out.println(flag);
		System.out.println(cacheOperator.get("1"));
	}

	@Test
	public void lockTimeTest() {
		Boolean flag = lockService.lock("1", "abc");
		while (!lockService.lock("1", "abc")) {
			System.out.println("wait");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public ILockService getLockService() {
		return lockService;
	}

	public void setLockService(ILockService lockService) {
		this.lockService = lockService;
	}

	public ICacheOperator getCacheOperator() {
		return cacheOperator;
	}

	public void setCacheOperator(ICacheOperator cacheOperator) {
		this.cacheOperator = cacheOperator;
	}

}
