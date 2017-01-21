package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;

public interface IPickManage {

	public Long addPickVO(PickVO pickVO);

	public List<PickVO> queryPickVOList(PickQueryVO pickQueryVO);

	public PickVO getPickVOByID(Long id);

	public Boolean modifyPickVO(PickVO pickVO);

	public Boolean deletePickVOByID(Long id);

	public PickVO assign(PickVO pickVO);

}