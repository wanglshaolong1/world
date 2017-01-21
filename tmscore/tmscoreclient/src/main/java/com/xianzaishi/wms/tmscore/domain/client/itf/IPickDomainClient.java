package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public interface IPickDomainClient {

	// domain
	public SimpleResultVO<Boolean> createPickDomain(PickVO pickVO);

	public SimpleResultVO<PickVO> getPickDomainByID(Long pickID);

	public SimpleResultVO<Boolean> deletePickDomain(Long id);

	public SimpleResultVO<Boolean> submitPickedDetail(
			List<PickDetailVO> pickDetailVOs);

	public SimpleResultVO<Boolean> recievePickingBasket(
			String pickingBasketBarcode);

	public SimpleResultVO<Boolean> cancelPickTask(Long pickID);

	// head
	public SimpleResultVO<Boolean> addPickVO(PickVO pickVO);

	public SimpleResultVO<List<PickVO>> queryPickVOList(PickQueryVO pickQueryVO);

	public SimpleResultVO<PickVO> getPickVOByID(Long id);

	public SimpleResultVO<List<PickingBasketVO>> getPickingBasketVOsByPickID(
			Long pickID);

	/**
	 * details为null时，不对details做操作，为空list时batchDelete detail，非空时自动汇聚成所需操作。
	 * 
	 * @param pickVO
	 * @return
	 */
	public SimpleResultVO<Boolean> modifyPickVO(PickVO pickVO);

	public SimpleResultVO<Boolean> deletePickVO(Long pickID);

	public SimpleResultVO<PickVO> assignPickVO(Long agencyID, Long operator);

	// body

	public SimpleResultVO<Boolean> createPickDetailVO(PickDetailVO pickDetailVO);

	public SimpleResultVO<Boolean> batchCreatePickDetailVO(
			List<PickDetailVO> pickDetailVOs);

	public SimpleResultVO<List<PickDetailVO>> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO);

	public SimpleResultVO<List<PickDetailVO>> getPickDetailVOListByPickID(
			Long pickID);

	public SimpleResultVO<PickDetailQueryVO> getPickDetailVOByID(Long id);

	public SimpleResultVO<Boolean> modifyPickDetailVO(PickDetailVO pickDetailVO);

	public SimpleResultVO<Boolean> batchModifyPickDetailVOs(
			List<PickDetailVO> pickDetailVOs);

	public SimpleResultVO<Boolean> deletePickDetailVO(Long id);

	public SimpleResultVO<Boolean> deletePickDetailVOByPickID(Long pickID);

	public SimpleResultVO<Boolean> batchDeletePickDetailVOByPickID(
			List<Long> storyDetailIDs);

	public SimpleResultVO<Boolean> outOfStock(PickDetailVO pickDetailVO);

}
