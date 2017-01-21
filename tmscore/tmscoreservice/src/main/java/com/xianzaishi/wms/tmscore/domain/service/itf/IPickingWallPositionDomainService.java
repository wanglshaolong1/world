package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;

public interface IPickingWallPositionDomainService {

	public Boolean addPickingWallPositionVO(
			PickingWallPositionVO PickingWallPositionVO);

	public PickingWallPositionVO getPickingWallPositionVOByBarcode(
			String barcode);

	public PickingWallPositionVO getPickingWallPositionVOByID(Long id);

	public List<PickingWallPositionVO> batchGetPickingWallPositionVOByBarcode(
			List<String> barcodes) throws Exception;

	public List<PickingWallPositionVO> batchGetPickingWallPositionVOByID(
			List<Long> ids) throws Exception;

	public List<PickingWallPositionVO> getPickingWallPositionByWaveID(
			Long waveID);
}
