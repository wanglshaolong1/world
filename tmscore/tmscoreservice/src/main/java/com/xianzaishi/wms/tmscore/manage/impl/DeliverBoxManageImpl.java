package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDeliverBoxDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDeliverBoxManage;
import com.xianzaishi.wms.tmscore.vo.DeliverBoxQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverBoxVO;

public class DeliverBoxManageImpl implements IDeliverBoxManage {
	@Autowired
	private IDeliverBoxDao deliverBoxDao = null;

	private void validate(DeliverBoxVO deliverBoxVO) {
		if (deliverBoxVO.getDeliverId() == null
				|| deliverBoxVO.getDeliverId() <= 0) {
			throw new BizException("deliveryID error："
					+ deliverBoxVO.getDeliverId());
		}
		if (deliverBoxVO.getBoxId() == null || deliverBoxVO.getBoxId() <= 0) {
			throw new BizException("boxID error：" + deliverBoxVO.getBoxId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDeliverBoxDao getDeliverBoxDao() {
		return deliverBoxDao;
	}

	public void setDeliverBoxDao(IDeliverBoxDao deliverBoxDao) {
		this.deliverBoxDao = deliverBoxDao;
	}

	public Boolean addDeliverBoxVO(DeliverBoxVO deliverBoxVO) {
		validate(deliverBoxVO);
		deliverBoxDao.addDO(deliverBoxVO);
		return true;
	}

	public List<DeliverBoxVO> queryDeliverBoxVOList(
			DeliverBoxQueryVO deliverBoxQueryVO) {
		return deliverBoxDao.queryDO(deliverBoxQueryVO);
	}

	public DeliverBoxVO getDeliverBoxVOByID(Long id) {
		return (DeliverBoxVO) deliverBoxDao.getDOByID(id);
	}

	public Boolean modifyDeliverBoxVO(DeliverBoxVO deliverBoxVO) {
		return deliverBoxDao.updateDO(deliverBoxVO);
	}

	public Boolean deleteDeliverBoxVOByID(Long id) {
		return deliverBoxDao.delDO(id);
	}

	public List<DeliverBoxVO> getDeliverBoxVOByOutgoingID(Long id) {
		DeliverBoxQueryVO queryVO = new DeliverBoxQueryVO();
		queryVO.setDeliverId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return deliverBoxDao.queryDO(queryVO);
	}

	public Boolean batchAddDeliverBoxVO(List<DeliverBoxVO> deliverBoxVOs) {
		return deliverBoxDao.batchAddDO(deliverBoxVOs);
	}

	public Boolean batchModifyDeliverBoxVO(List<DeliverBoxVO> deliverBoxVOs) {
		return deliverBoxDao.batchModifyDO(deliverBoxVOs);
	}

	public Boolean batchDeleteDeliverBoxVO(List<DeliverBoxVO> deliverBoxVOs) {
		return deliverBoxDao.batchDeleteDO(deliverBoxVOs);
	}

	public Boolean batchDeleteDeliverBoxVOByID(List<Long> deliverBoxIDs) {
		return deliverBoxDao.batchDeleteDOByID(deliverBoxIDs);
	}
}
