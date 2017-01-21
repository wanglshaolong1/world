package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IWavePoolDetailDao;
import com.xianzaishi.wms.tmscore.manage.itf.IWavePoolDetailManage;
import com.xianzaishi.wms.tmscore.vo.WavePoolDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolDetailVO;

public class WavePoolDetailManageImpl implements IWavePoolDetailManage {
	@Autowired
	private IWavePoolDetailDao wavePoolDetailDao = null;

	private void validate(WavePoolDetailVO wavePoolDetailVO) {
		if (wavePoolDetailVO.getDistributionId() == null
				|| wavePoolDetailVO.getDistributionId() <= 0) {
			throw new BizException("distributionID error："
					+ wavePoolDetailVO.getDistributionId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IWavePoolDetailDao getWavePoolDetailDao() {
		return wavePoolDetailDao;
	}

	public void setWavePoolDetailDao(IWavePoolDetailDao wavePoolDetailDao) {
		this.wavePoolDetailDao = wavePoolDetailDao;
	}

	public Boolean addWavePoolDetailVO(WavePoolDetailVO wavePoolDetailVO) {
		validate(wavePoolDetailVO);
		wavePoolDetailDao.addDO(wavePoolDetailVO);
		return true;
	}

	public List<WavePoolDetailVO> queryWavePoolDetailVOList(
			WavePoolDetailQueryVO wavePoolDetailQueryVO) {
		return wavePoolDetailDao.queryDO(wavePoolDetailQueryVO);
	}

	public WavePoolDetailVO getWavePoolDetailVOByID(Long id) {
		return (WavePoolDetailVO) wavePoolDetailDao.getDOByID(id);
	}

	public Boolean modifyWavePoolDetailVO(WavePoolDetailVO wavePoolDetailVO) {
		return wavePoolDetailDao.updateDO(wavePoolDetailVO);
	}

	public Boolean deleteWavePoolDetailVOByID(Long id) {
		return wavePoolDetailDao.deleteDO(id);
	}

	public List<WavePoolDetailVO> getWavePoolDetailVOByOutgoingID(Long id) {
		WavePoolDetailQueryVO queryVO = new WavePoolDetailQueryVO();
		queryVO.setPoolId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return wavePoolDetailDao.queryDO(queryVO);
	}

	public Boolean batchAddWavePoolDetailVO(
			List<WavePoolDetailVO> wavePoolDetailVOs) {
		return wavePoolDetailDao.batchAddDO(wavePoolDetailVOs);
	}

	public Boolean batchModifyWavePoolDetailVO(
			List<WavePoolDetailVO> wavePoolDetailVOs) {
		return wavePoolDetailDao.batchModifyDO(wavePoolDetailVOs);
	}

	public Boolean batchDeleteWavePoolDetailVO(
			List<WavePoolDetailVO> wavePoolDetailVOs) {
		return wavePoolDetailDao.batchDeleteDOPhysics(wavePoolDetailVOs);
	}

	public Boolean batchDeleteWavePoolDetailVOByID(List<Long> wavePoolDetailIDs) {
		return wavePoolDetailDao.batchDeleteDOByIDPhysics(wavePoolDetailIDs);
	}
}
