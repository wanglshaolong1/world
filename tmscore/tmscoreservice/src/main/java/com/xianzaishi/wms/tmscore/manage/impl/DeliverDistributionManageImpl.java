package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDeliverDistributionDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDeliverDistributionManage;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionDO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;

public class DeliverDistributionManageImpl implements
		IDeliverDistributionManage {
	@Autowired
	private IDeliverDistributionDao deliverDistributionDao = null;

	private void validate(DeliverDistributionVO deliverDistributionVO) {
		if (deliverDistributionVO.getDeliverId() == null
				|| deliverDistributionVO.getDeliverId() <= 0) {
			throw new BizException("deliveryID error："
					+ deliverDistributionVO.getDeliverId());
		}
		if (deliverDistributionVO.getDistributionId() == null
				|| deliverDistributionVO.getDistributionId() <= 0) {
			throw new BizException("distributionID error："
					+ deliverDistributionVO.getDistributionId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDeliverDistributionDao getDeliverDistributionDao() {
		return deliverDistributionDao;
	}

	public void setDeliverDistributionDao(
			IDeliverDistributionDao deliverDistributionDao) {
		this.deliverDistributionDao = deliverDistributionDao;
	}

	public Boolean addDeliverDistributionVO(
			DeliverDistributionVO deliverDistributionVO) {
		validate(deliverDistributionVO);
		deliverDistributionDao.addDO(deliverDistributionVO);
		return true;
	}

	public List<DeliverDistributionVO> queryDeliverDistributionVOList(
			DeliverDistributionQueryVO deliverDistributionQueryVO) {
		return deliverDistributionDao.queryDO(deliverDistributionQueryVO);
	}

	public DeliverDistributionVO getDeliverDistributionVOByID(Long id) {
		return (DeliverDistributionVO) deliverDistributionDao.getDOByID(id);
	}

	public Boolean modifyDeliverDistributionVO(
			DeliverDistributionVO deliverDistributionVO) {
		return deliverDistributionDao.updateDO(deliverDistributionVO);
	}

	public Boolean deleteDeliverDistributionVOByID(Long id) {
		return deliverDistributionDao.delDO(id);
	}

	public List<DeliverDistributionVO> getDeliverDistributionVOByOutgoingID(
			Long id) {
		DeliverDistributionQueryVO queryVO = new DeliverDistributionQueryVO();
		queryVO.setDeliverId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return deliverDistributionDao.queryDO(queryVO);
	}

	public Boolean batchAddDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs) {
		return deliverDistributionDao.batchAddDO(deliverDistributionVOs);
	}

	public Boolean batchModifyDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs) {
		return deliverDistributionDao.batchModifyDO(deliverDistributionVOs);
	}

	public Boolean batchDeleteDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs) {
		return deliverDistributionDao.batchDeleteDO(deliverDistributionVOs);
	}

	public Boolean batchDeleteDeliverDistributionVOByID(
			List<Long> deliverDistributionIDs) {
		return deliverDistributionDao.batchDeleteDOByID(deliverDistributionIDs);
	}
}
