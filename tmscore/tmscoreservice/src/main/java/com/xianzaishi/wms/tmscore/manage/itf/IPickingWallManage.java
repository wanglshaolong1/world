package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingWallVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallDO;
import com.xianzaishi.wms.tmscore.vo.PickingWallQueryVO;

public interface IPickingWallManage {

	public Boolean addPickingWallVO(PickingWallVO pickingWallVO);

	public List<PickingWallVO> queryPickingWallVOList(PickingWallQueryVO pickingWallQueryVO);

	public PickingWallVO getPickingWallVOByID(Long id);

	public Boolean modifyPickingWallVO(PickingWallVO pickingWallVO);

	public Boolean deletePickingWallVOByID(Long id);

}