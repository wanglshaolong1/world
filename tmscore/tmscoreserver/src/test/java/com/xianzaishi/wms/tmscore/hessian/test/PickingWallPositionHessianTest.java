package com.xianzaishi.wms.tmscore.hessian.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.wms.base.test.BaseTest;
import com.xianzaishi.wms.tmscore.domain.client.itf.IPickingWallPositionDomainClient;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;

@ContextConfiguration(locations = "classpath:spring/ac-hessian-tmscore.xml")
public class PickingWallPositionHessianTest extends BaseTest {

	@Autowired
	private IPickingWallPositionDomainClient pickingWallPositionDomainClient = null;

	@Test
	public void initPickingWallPositionTest() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 8; j++) {
				PickingWallPositionVO pickingWallPositionVO = new PickingWallPositionVO();
				pickingWallPositionVO.setAgencyId(1l);
				pickingWallPositionVO
						.setCode(String.format("FJ%02d%02d", i, j));
				pickingWallPositionDomainClient
						.addPickingWallPositionVO(pickingWallPositionVO);
			}
		}
	}

	public IPickingWallPositionDomainClient getPickingWallPositionDomainClient() {
		return pickingWallPositionDomainClient;
	}

	public void setPickingWallPositionDomainClient(
			IPickingWallPositionDomainClient pickingWallPositionDomainClient) {
		this.pickingWallPositionDomainClient = pickingWallPositionDomainClient;
	}

}
