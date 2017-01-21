package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingVO;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingQueryVO;

public interface IAddressAreaMappingService {

	public Boolean addAddressAreaMappingVO(AddressAreaMappingVO addressAreaMappingVO);

	public List<AddressAreaMappingVO> queryAddressAreaMappingVOList(AddressAreaMappingQueryVO addressAreaMappingQueryVO);

	public AddressAreaMappingVO getAddressAreaMappingVOByID(Long id);

	public Boolean modifyAddressAreaMappingVO(AddressAreaMappingVO addressAreaMappingVO);

	public Boolean deleteAddressAreaMappingVOByID(Long id);

}