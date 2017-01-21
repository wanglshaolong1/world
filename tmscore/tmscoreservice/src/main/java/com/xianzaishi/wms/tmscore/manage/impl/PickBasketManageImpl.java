package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickBasketDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickBasketManage;
import com.xianzaishi.wms.tmscore.vo.PickBasketQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickBasketVO;

public class PickBasketManageImpl implements IPickBasketManage {
	@Autowired
	private IPickBasketDao pickBasketDao = null;

	private void validate(PickBasketVO pickBasketVO) {
		if (pickBasketVO.getBasketId() == null
				|| pickBasketVO.getBasketId() <= 0) {
			throw new BizException("basketID error："
					+ pickBasketVO.getBasketId());
		}
		if (pickBasketVO.getPickId() == null || pickBasketVO.getPickId() <= 0) {
			throw new BizException("pickID error：" + pickBasketVO.getPickId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickBasketDao getPickBasketDao() {
		return pickBasketDao;
	}

	public void setPickBasketDao(IPickBasketDao pickBasketDao) {
		this.pickBasketDao = pickBasketDao;
	}

	public Boolean addPickBasketVO(PickBasketVO pickBasketVO) {
		validate(pickBasketVO);
		pickBasketDao.addDO(pickBasketVO);
		return true;
	}

	public List<PickBasketVO> queryPickBasketVOList(
			PickBasketQueryVO pickBasketQueryVO) {
		return pickBasketDao.queryDO(pickBasketQueryVO);
	}

	public PickBasketVO getPickBasketVOByID(Long id) {
		return (PickBasketVO) pickBasketDao.getDOByID(id);
	}

	public Boolean modifyPickBasketVO(PickBasketVO pickBasketVO) {
		return pickBasketDao.updateDO(pickBasketVO);
	}

	public Boolean deletePickBasketVOByID(Long id) {
		return pickBasketDao.delDO(id);
	}
}
