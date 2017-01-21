package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public interface IPickDomainService {

	// domain
	public Boolean createPickDomain(PickVO pickVO);

	public PickVO getPickDomainByID(Long pickID);

	public Boolean deletePickDomain(Long id);

	public Boolean submitPickedDetail(List<PickDetailVO> pickDetailVOs);

	public Boolean recievePickingBasket(String pickingBasketBarcode);

	public Boolean cancelPickTask(Long pickID);

	// head
	public Boolean addPickVO(PickVO pickVO);

	public List<PickVO> queryPickVOList(PickQueryVO pickQueryVO);

	public PickVO getPickVOByID(Long id);

	public List<PickingBasketVO> getPickingBasketVOsByPickID(Long pickID);

	public Boolean modifyPickVO(PickVO pickVO);

	public Boolean deletePickVO(Long pickID);

	public PickVO assignPickVO(Long agencyID, Long operator);

	// body
	public Boolean createPickDetailVO(PickDetailVO pickDetailVO);

	public Boolean batchCreatePickDetailVO(List<PickDetailVO> pickDetailVOs);

	public List<PickDetailVO> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO);

	public List<PickDetailVO> getPickDetailVOListByPickID(Long pickID);

	public PickDetailVO getPickDetailVOByID(Long id);

	public Boolean modifyPickDetailVO(PickDetailVO pickDetailVO);

	public Boolean batchModifyPickDetailVOs(List<PickDetailVO> pickDetailVOs);

	public Boolean deletePickDetailVO(Long id);

	public Boolean deletePickDetailVOByPickID(Long pickID);

	public Boolean batchDeletePickDetailVOByPickID(List<Long> pickDetailIDs);

	public Boolean outOfStock(PickDetailVO pickDetailVO);

}
