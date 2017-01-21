package com.xianzaishi.wms.tmscore.manage.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDeliverDetailDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDeliverDetailManage;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;

public class DeliverDetailManageImpl implements IDeliverDetailManage {
	@Autowired
	private IDeliverDetailDao deliverDetailDao = null;

	private void validate(DeliverDetailVO deliverDetailVO) {
		if (deliverDetailVO.getBoxId() == null
				|| deliverDetailVO.getBoxId() <= 0) {
			throw new BizException("boxID error：" + deliverDetailVO.getBoxId());
		}
		if (deliverDetailVO.getDelivId() == null
				|| deliverDetailVO.getDelivId() <= 0) {
			throw new BizException("deliveryID error："
					+ deliverDetailVO.getDelivId());
		}

		if (deliverDetailVO.getOrderNoReal() == null
				&& deliverDetailVO.getOrderNo() != null
				&& !deliverDetailVO.getOrderNo().isEmpty()) {
			deliverDetailVO.setOrderNoReal(new BigDecimal(deliverDetailVO
					.getOrderNo()).multiply(new BigDecimal(1000)).intValue());
		}

		if (deliverDetailVO.getDelivNoReal() == null
				&& deliverDetailVO.getDelivNo() != null
				&& !deliverDetailVO.getDelivNo().isEmpty()) {
			deliverDetailVO.setDelivNoReal(new BigDecimal(deliverDetailVO
					.getDelivNo()).multiply(new BigDecimal(1000)).intValue());
		}

		if (deliverDetailVO.getRemainNoReal() == null
				&& deliverDetailVO.getRemainNo() != null
				&& !deliverDetailVO.getRemainNo().isEmpty()) {
			deliverDetailVO.setRemainNoReal(new BigDecimal(deliverDetailVO
					.getRemainNo()).multiply(new BigDecimal(1000)).intValue());
		}

		if (deliverDetailVO.getDistributionNoReal() == null
				&& deliverDetailVO.getDistributionNo() != null
				&& !deliverDetailVO.getDistributionNo().isEmpty()) {
			deliverDetailVO.setDistributionNoReal(new BigDecimal(
					deliverDetailVO.getDistributionNo()).multiply(
					new BigDecimal(1000)).intValue());
		}

		if (deliverDetailVO.getDelivNoReal() == null
				|| deliverDetailVO.getDelivNoReal() <= 0) {
			throw new BizException("delivery number error："
					+ deliverDetailVO.getDelivNoReal());
		}

		if (deliverDetailVO.getSkuId() == null
				|| deliverDetailVO.getSkuId() <= 0) {
			throw new BizException("skuID error：" + deliverDetailVO.getSkuId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDeliverDetailDao getDeliverDetailDao() {
		return deliverDetailDao;
	}

	public void setDeliverDetailDao(IDeliverDetailDao deliverDetailDao) {
		this.deliverDetailDao = deliverDetailDao;
	}

	public Boolean addDeliverDetailVO(DeliverDetailVO deliverDetailVO) {
		validate(deliverDetailVO);
		deliverDetailDao.addDO(deliverDetailVO);
		return true;
	}

	public List<DeliverDetailVO> queryDeliverDetailVOList(
			DeliverDetailQueryVO deliverDetailQueryVO) {
		return deliverDetailDao.queryDO(deliverDetailQueryVO);
	}

	public DeliverDetailVO getDeliverDetailVOByID(Long id) {
		return (DeliverDetailVO) deliverDetailDao.getDOByID(id);
	}

	public Boolean modifyDeliverDetailVO(DeliverDetailVO deliverDetailVO) {
		return deliverDetailDao.updateDO(deliverDetailVO);
	}

	public Boolean deleteDeliverDetailVOByID(Long id) {
		return deliverDetailDao.delDO(id);
	}

	public List<DeliverDetailVO> getDeliverDetailVOByOutgoingID(Long id) {
		DeliverDetailQueryVO queryVO = new DeliverDetailQueryVO();
		queryVO.setDelivId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return deliverDetailDao.queryDO(queryVO);
	}

	public Boolean batchAddDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return deliverDetailDao.batchAddDO(deliverDetailVOs);
	}

	public Boolean batchModifyDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return deliverDetailDao.batchModifyDO(deliverDetailVOs);
	}

	public Boolean batchDeleteDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return deliverDetailDao.batchDeleteDO(deliverDetailVOs);
	}

	public Boolean batchDeleteDeliverDetailVOByID(List<Long> deliverDetailIDs) {
		return deliverDetailDao.batchDeleteDOByID(deliverDetailIDs);
	}
}
