package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuVO;

public interface IPickingWallPositionStatuManage {

	public Boolean addPickingWallPositionStatuVO(
			PickingWallPositionStatuVO pickingWallPositionStatuVO);

	public List<PickingWallPositionStatuVO> queryPickingWallPositionStatuVOList(
			PickingWallPositionStatuQueryVO pickingWallPositionStatuQueryVO);

	public PickingWallPositionStatuVO getPickingWallPositionStatuVOByID(Long id);

	public Boolean modifyPickingWallPositionStatuVO(
			PickingWallPositionStatuVO pickingWallPositionStatuVO);

	public Boolean deletePickingWallPositionStatuVOByID(Long id);

	public void assign(Long waveID, Long positionID);

}