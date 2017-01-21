package com.xianzaishi.wms.tmscore.manage.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickDetailDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickDetailManage;
import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;

public class PickDetailManageImpl implements IPickDetailManage {
	@Autowired
	private IPickDetailDao pickDetailDao = null;

	private void validate(PickDetailVO pickDetailVO) {
		if (pickDetailVO.getPickId() == null || pickDetailVO.getPickId() <= 0) {
			throw new BizException("pickID error：" + pickDetailVO.getPickId());
		}
		if (pickDetailVO.getAreaId() == null || pickDetailVO.getAreaId() <= 0) {
			throw new BizException("areaID error：" + pickDetailVO.getAreaId());
		}
		if (pickDetailVO.getSkuId() == null || pickDetailVO.getSkuId() <= 0) {
			throw new BizException("skuID error：" + pickDetailVO.getSkuId());
		}
		if (pickDetailVO.getPositionId() == null
				|| pickDetailVO.getPositionId() <= 0) {
			throw new BizException("positionID error："
					+ pickDetailVO.getPositionId());
		}

		if (pickDetailVO.getOrderNoReal() == null
				&& pickDetailVO.getOrderNo() != null
				&& !pickDetailVO.getOrderNo().isEmpty()) {
			pickDetailVO.setOrderNoReal(new BigDecimal(pickDetailVO
					.getOrderNo()).multiply(new BigDecimal(1000)).intValue());
		}

		if (pickDetailVO.getPickedNoReal() == null
				&& pickDetailVO.getPickedNo() != null
				&& !pickDetailVO.getPickedNo().isEmpty()) {
			pickDetailVO.setPickedNoReal(new BigDecimal(pickDetailVO
					.getPickedNo()).multiply(new BigDecimal(1000)).intValue());
		}

		if (pickDetailVO.getOrderNoReal() == null
				|| pickDetailVO.getOrderNoReal() <= 0) {
			throw new BizException("order number error："
					+ pickDetailVO.getOrderNoReal());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickDetailDao getPickDetailDao() {
		return pickDetailDao;
	}

	public void setPickDetailDao(IPickDetailDao pickDetailDao) {
		this.pickDetailDao = pickDetailDao;
	}

	public Boolean addPickDetailVO(PickDetailVO pickDetailVO) {
		validate(pickDetailVO);
		pickDetailDao.addDO(pickDetailVO);
		return true;
	}

	public List<PickDetailVO> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO) {
		return pickDetailDao.queryDO(pickDetailQueryVO);
	}

	public PickDetailVO getPickDetailVOByID(Long id) {
		return (PickDetailVO) pickDetailDao.getDOByID(id);
	}

	public Boolean modifyPickDetailVO(PickDetailVO pickDetailVO) {
		return pickDetailDao.updateDO(pickDetailVO);
	}

	public Boolean deletePickDetailVOByID(Long id) {
		return pickDetailDao.delDO(id);
	}

	public List<PickDetailVO> getPickDetailVOByOutgoingID(Long id) {
		PickDetailQueryVO queryVO = new PickDetailQueryVO();
		queryVO.setPickId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return pickDetailDao.queryDO(queryVO);
	}

	public Boolean batchAddPickDetailVO(List<PickDetailVO> pickDetailVOs) {
		return pickDetailDao.batchAddDO(pickDetailVOs);
	}

	public Boolean batchModifyPickDetailVO(List<PickDetailVO> pickDetailVOs) {
		return pickDetailDao.batchModifyDO(pickDetailVOs);
	}

	public Boolean batchDeletePickDetailVO(List<PickDetailVO> pickDetailVOs) {
		return pickDetailDao.batchDeleteDO(pickDetailVOs);
	}

	public Boolean batchDeletePickDetailVOByID(List<Long> pickDetailIDs) {
		return pickDetailDao.batchDeleteDOByID(pickDetailIDs);
	}
}
