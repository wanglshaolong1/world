package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IWaveDao;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public class WaveDaoImpl extends BaseDaoAdapter implements IWaveDao {
	public String getVOClassName() {
		return "WaveDO";
	}

	public WaveVO assign(WaveVO waveVO) {
		WaveVO flag = null;
		try {
			if (waveVO.getId() != null && waveVO.getId() > 0) {
				int no = simpleSqlMapClientTemplate.update(getVOClassName()
						+ ".assign", waveVO);
				if (no == 1) {
					flag = (WaveVO) getDOByID(waveVO.getId());
				} else if (no > 1) {
					throw new BizException("影响的数据大于1条。");
				}
			} else {
				throw new BizException("更新数据失败，ID错误：ID = " + waveVO.getId());
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}

	public Boolean releaseWaveTask(Long waveID) {
		Boolean flag = null;
		try {
			if (waveID != null && waveID > 0) {
				int no = simpleSqlMapClientTemplate.update(getVOClassName()
						+ ".releaseWaveTask", waveID);
				if (no == 1) {
					flag = true;
				} else if (no > 1) {
					throw new BizException("影响的数据大于1条。");
				}
			} else {
				throw new BizException("更新数据失败，ID错误：ID = " + waveID);
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}
}
