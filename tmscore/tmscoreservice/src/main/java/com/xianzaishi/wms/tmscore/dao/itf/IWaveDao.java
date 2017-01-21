package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public interface IWaveDao extends IBaseDao {
	public WaveVO assign(WaveVO waveVO);

	public Boolean releaseWaveTask(Long waveID);
}