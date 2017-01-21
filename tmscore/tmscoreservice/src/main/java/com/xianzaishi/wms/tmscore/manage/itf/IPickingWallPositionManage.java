package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionDO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionQueryVO;

public interface IPickingWallPositionManage {

	public Boolean addPickingWallPositionVO(PickingWallPositionVO pickingWallPositionVO);

	public List<PickingWallPositionVO> queryPickingWallPositionVOList(PickingWallPositionQueryVO pickingWallPositionQueryVO);

	public PickingWallPositionVO getPickingWallPositionVOByID(Long id);

	public Boolean modifyPickingWallPositionVO(PickingWallPositionVO pickingWallPositionVO);

	public Boolean deletePickingWallPositionVOByID(Long id);

}