package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;

public interface IPickDetailManage {

	public Boolean addPickDetailVO(PickDetailVO pickDetailVO);

	public List<PickDetailVO> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO);

	public PickDetailVO getPickDetailVOByID(Long id);

	public Boolean modifyPickDetailVO(PickDetailVO pickDetailVO);

	public Boolean deletePickDetailVOByID(Long id);

	public List<PickDetailVO> getPickDetailVOByOutgoingID(Long id);

	public Boolean batchAddPickDetailVO(List<PickDetailVO> pickDetailVOs);

	public Boolean batchModifyPickDetailVO(List<PickDetailVO> pickDetailVOs);

	public Boolean batchDeletePickDetailVO(List<PickDetailVO> pickDetailVOs);

	public Boolean batchDeletePickDetailVOByID(List<Long> deliverDetailIDs);

}