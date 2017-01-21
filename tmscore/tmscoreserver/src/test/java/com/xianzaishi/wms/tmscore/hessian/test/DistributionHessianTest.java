package com.xianzaishi.wms.tmscore.hessian.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.wms.base.test.BaseTest;
import com.xianzaishi.wms.tmscore.domain.client.itf.IDistributionDomainClient;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

@ContextConfiguration(locations = "classpath:spring/ac-hessian-tmscore.xml")
public class DistributionHessianTest extends BaseTest {

	@Autowired
	private IDistributionDomainClient distributionDomainClient = null;

	@Test
	public void addDistributionVOTest() {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setAgencyId(1l);
		distributionVO.setAreaId(1l);
		distributionVO.setDeliveryAging(Short.parseShort("0"));
		distributionVO.setOrderId(1l);
		distributionVO.setOrderTime(new Date());
		distributionVO.setStatu(0);
		distributionVO.setPickup(0);

		List<DistributionDetailVO> details = new LinkedList<DistributionDetailVO>();

		DistributionDetailVO detail = new DistributionDetailVO();
		detail.setSkuId(1l);
		detail.setAllNoReal(1);
		detail.setDelivedNoReal(0);
		detail.setDelivNoReal(1);
		details.add(detail);

		distributionVO.setDetails(details);
		distributionDomainClient.createDistributionDomain(distributionVO);
	}

	@Test
	public void resetTest() {
		distributionDomainClient.reset(56l);
	}

	@Test
	public void resetDistributionAreaTest() {
		distributionDomainClient.setDistributionArea(54l, 1l);
	}

	public IDistributionDomainClient getDistributionDomainClient() {
		return distributionDomainClient;
	}

	public void setDistributionDomainClient(
			IDistributionDomainClient distributionDomainClient) {
		this.distributionDomainClient = distributionDomainClient;
	}

}
