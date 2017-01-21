package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingVO;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IAddressAreaMappingService;
import com.xianzaishi.wms.tmscore.manage.itf.IAddressAreaMappingManage;

public class AddressAreaMappingServiceImpl implements IAddressAreaMappingService {
	@Autowired
	private IAddressAreaMappingManage addressAreaMappingManage = null;

	public IAddressAreaMappingManage getAddressAreaMappingManage() {
		return addressAreaMappingManage;
	}

	public void setAddressAreaMappingManage(IAddressAreaMappingManage addressAreaMappingManage) {
		this.addressAreaMappingManage = addressAreaMappingManage;
	}
	
	public Boolean addAddressAreaMappingVO(AddressAreaMappingVO addressAreaMappingVO) {
		addressAreaMappingManage.addAddressAreaMappingVO(addressAreaMappingVO);
		return true;
	}

	public List<AddressAreaMappingVO> queryAddressAreaMappingVOList(AddressAreaMappingQueryVO addressAreaMappingQueryVO) {
		return addressAreaMappingManage.queryAddressAreaMappingVOList(addressAreaMappingQueryVO);
	}

	public AddressAreaMappingVO getAddressAreaMappingVOByID(Long id) {
		return (AddressAreaMappingVO) addressAreaMappingManage.getAddressAreaMappingVOByID(id);
	}

	public Boolean modifyAddressAreaMappingVO(AddressAreaMappingVO addressAreaMappingVO) {
		return addressAreaMappingManage.modifyAddressAreaMappingVO(addressAreaMappingVO);
	}

	public Boolean deleteAddressAreaMappingVOByID(Long id) {
		return addressAreaMappingManage.deleteAddressAreaMappingVOByID(id);
	}
}
