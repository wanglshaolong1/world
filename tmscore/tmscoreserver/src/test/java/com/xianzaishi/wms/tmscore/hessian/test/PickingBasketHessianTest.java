package com.xianzaishi.wms.tmscore.hessian.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.wms.base.test.BaseTest;
import com.xianzaishi.wms.tmscore.domain.client.itf.IPickingBasketDomainClient;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

@ContextConfiguration(locations = "classpath:spring/ac-hessian-tmscore.xml")
public class PickingBasketHessianTest extends BaseTest {

	@Autowired
	private IPickingBasketDomainClient pickingBasketDomainClient = null;

	@Test
	public void initPickingBasketTest() {
		for (int i = 1; i <= 100; i++) {
			PickingBasketVO pickingBasketVO =new PickingBasketVO();
			pickingBasketVO.setAgencyId(1l);
			pickingBasketVO.setCode(String.format("JH%03d", i));
			pickingBasketDomainClient.addPickingBasketVO(pickingBasketVO);
		}
	}

	public IPickingBasketDomainClient getPickingBasketDomainClient() {
		return pickingBasketDomainClient;
	}

	public void setPickingBasketDomainClient(
			IPickingBasketDomainClient pickingBasketDomainClient) {
		this.pickingBasketDomainClient = pickingBasketDomainClient;
	}

}
