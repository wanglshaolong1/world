package com.xianzaishi.tms.tmscore.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xianzaishi.tms.tmscore.base.test.TmscoreBaseDaoTest;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionAreaService;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;

@ContextConfiguration(locations = "classpath:spring/ac-tmscore-DistributionArea.xml")
public class DistributionAreaServiceTest extends TmscoreBaseDaoTest {

	@Autowired
	private IDistributionAreaService distributionAreaService = null;

	@Test
	public void getAreaTest() {
		DistributionAreaQueryVO queryVO = new DistributionAreaQueryVO();
		queryVO.setLat(100);
		queryVO.setLng(100);
		distributionAreaService.getArea(queryVO);
	}

	public IDistributionAreaService getDistributionAreaService() {
		return distributionAreaService;
	}

	public void setDistributionAreaService(
			IDistributionAreaService distributionAreaService) {
		this.distributionAreaService = distributionAreaService;
	}

}
