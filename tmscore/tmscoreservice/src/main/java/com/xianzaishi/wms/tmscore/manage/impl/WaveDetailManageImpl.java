package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IWaveDetailDao;
import com.xianzaishi.wms.tmscore.manage.itf.IWaveDetailManage;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;

public class WaveDetailManageImpl implements IWaveDetailManage {
	@Autowired
	private IWaveDetailDao waveDetailDao = null;

	private void validate(WaveDetailVO waveDetailVO) {
		if (waveDetailVO.getWaveId() == null || waveDetailVO.getWaveId() <= 0) {
			throw new BizException("waveID error：" + waveDetailVO.getWaveId());
		}
		if (waveDetailVO.getDistributionId() == null
				|| waveDetailVO.getDistributionId() <= 0) {
			throw new BizException("distributionID error："
					+ waveDetailVO.getDistributionId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IWaveDetailDao getWaveDetailDao() {
		return waveDetailDao;
	}

	public void setWaveDetailDao(IWaveDetailDao waveDetailDao) {
		this.waveDetailDao = waveDetailDao;
	}

	public Boolean addWaveDetailVO(WaveDetailVO waveDetailVO) {
		validate(waveDetailVO);
		waveDetailDao.addDO(waveDetailVO);
		return true;
	}

	public List<WaveDetailVO> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO) {
		return waveDetailDao.queryDO(waveDetailQueryVO);
	}

	public WaveDetailVO getWaveDetailVOByID(Long id) {
		return (WaveDetailVO) waveDetailDao.getDOByID(id);
	}

	public Boolean modifyWaveDetailVO(WaveDetailVO waveDetailVO) {
		return waveDetailDao.updateDO(waveDetailVO);
	}

	public Boolean deleteWaveDetailVOByID(Long id) {
		return waveDetailDao.delDO(id);
	}

	public List<WaveDetailVO> getWaveDetailVOByOutgoingID(Long id) {
		WaveDetailQueryVO queryVO = new WaveDetailQueryVO();
		queryVO.setWaveId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return waveDetailDao.queryDO(queryVO);
	}

	public Boolean batchAddWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailDao.batchAddDO(waveDetailVOs);
	}

	public Boolean batchModifyWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailDao.batchModifyDO(waveDetailVOs);
	}

	public Boolean batchDeleteWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailDao.batchDeleteDO(waveDetailVOs);
	}

	public Boolean batchDeleteWaveDetailVOByID(List<Long> waveDetailIDs) {
		return waveDetailDao.batchDeleteDOByID(waveDetailIDs);
	}
}
