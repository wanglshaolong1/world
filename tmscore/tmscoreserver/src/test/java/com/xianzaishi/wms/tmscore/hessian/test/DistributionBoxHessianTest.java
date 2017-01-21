package com.xianzaishi.wms.tmscore.hessian.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.wms.base.test.BaseTest;
import com.xianzaishi.wms.tmscore.domain.client.itf.IDistributionBoxDomainClient;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

@ContextConfiguration(locations = "classpath:spring/ac-hessian-tmscore.xml")
public class DistributionBoxHessianTest extends BaseTest {

	@Autowired
	private IDistributionBoxDomainClient distributionBoxDomainClient = null;

	@Test
	public void initDistributionBoxTest() {
		for (int i = 1; i <= 100; i++) {
			DistributionBoxVO distributionBoxVO = new DistributionBoxVO();
			distributionBoxVO.setAgencyId(1l);
			distributionBoxVO.setCode(String.format("PS%03d", i));
			distributionBoxDomainClient.addDistributionBoxVO(distributionBoxVO);
		}
	}

	public IDistributionBoxDomainClient getDistributionBoxDomainClient() {
		return distributionBoxDomainClient;
	}

	public void setDistributionBoxDomainClient(
			IDistributionBoxDomainClient distributionBoxDomainClient) {
		this.distributionBoxDomainClient = distributionBoxDomainClient;
	}

}
