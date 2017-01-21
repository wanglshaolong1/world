package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingVO;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingDO;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingQueryVO;

public interface IAddressAreaMappingManage {

	public Boolean addAddressAreaMappingVO(AddressAreaMappingVO addressAreaMappingVO);

	public List<AddressAreaMappingVO> queryAddressAreaMappingVOList(AddressAreaMappingQueryVO addressAreaMappingQueryVO);

	public AddressAreaMappingVO getAddressAreaMappingVOByID(Long id);

	public Boolean modifyAddressAreaMappingVO(AddressAreaMappingVO addressAreaMappingVO);

	public Boolean deleteAddressAreaMappingVOByID(Long id);

}