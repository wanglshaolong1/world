package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;

public interface IPickingWallPositionDomainClient {

	public SimpleResultVO<Boolean> addPickingWallPositionVO(
			PickingWallPositionVO pickingWallPositionVO);

	public SimpleResultVO<PickingWallPositionVO> getPickingWallPositionVOByBarcode(
			String barcode);

	public SimpleResultVO<PickingWallPositionVO> getPickingWallPositionVOByID(
			Long id);

	public SimpleResultVO<List<PickingWallPositionVO>> batchGetPickingWallPositionVOByBarcode(
			List<String> barcodes);

	public SimpleResultVO<List<PickingWallPositionVO>> batchGetPickingWallPositionVOByID(
			List<Long> ids);

	public SimpleResultVO<List<PickingWallPositionVO>> getPickingWallPositionByWaveID(
			Long waveID);
}
