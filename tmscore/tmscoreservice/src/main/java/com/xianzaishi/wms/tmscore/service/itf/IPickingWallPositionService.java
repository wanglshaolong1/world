package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionQueryVO;

public interface IPickingWallPositionService {

	public Boolean addPickingWallPositionVO(PickingWallPositionVO pickingWallPositionVO);

	public List<PickingWallPositionVO> queryPickingWallPositionVOList(PickingWallPositionQueryVO pickingWallPositionQueryVO);

	public PickingWallPositionVO getPickingWallPositionVOByID(Long id);

	public Boolean modifyPickingWallPositionVO(PickingWallPositionVO pickingWallPositionVO);

	public Boolean deletePickingWallPositionVOByID(Long id);

}