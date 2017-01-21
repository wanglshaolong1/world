package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IAddressAreaMappingDao;
import com.xianzaishi.wms.tmscore.manage.itf.IAddressAreaMappingManage;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingQueryVO;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingVO;

public class AddressAreaMappingManageImpl implements IAddressAreaMappingManage {
	@Autowired
	private IAddressAreaMappingDao addressAreaMappingDao = null;

	private void validate(AddressAreaMappingVO addressAreaMappingVO) {
		if (addressAreaMappingVO.getAddressId() == null
				|| addressAreaMappingVO.getAddressId() <= 0) {
			throw new BizException("addressID error："
					+ addressAreaMappingVO.getAddressId());
		}
		if (addressAreaMappingVO.getAreaId() == null
				|| addressAreaMappingVO.getAreaId() <= 0) {
			throw new BizException("addressID error："
					+ addressAreaMappingVO.getAreaId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IAddressAreaMappingDao getAddressAreaMappingDao() {
		return addressAreaMappingDao;
	}

	public void setAddressAreaMappingDao(
			IAddressAreaMappingDao addressAreaMappingDao) {
		this.addressAreaMappingDao = addressAreaMappingDao;
	}

	public Boolean addAddressAreaMappingVO(
			AddressAreaMappingVO addressAreaMappingVO) {
		validate(addressAreaMappingVO);
		addressAreaMappingDao.addDO(addressAreaMappingVO);
		return true;
	}

	public List<AddressAreaMappingVO> queryAddressAreaMappingVOList(
			AddressAreaMappingQueryVO addressAreaMappingQueryVO) {
		return addressAreaMappingDao.queryDO(addressAreaMappingQueryVO);
	}

	public AddressAreaMappingVO getAddressAreaMappingVOByID(Long id) {
		return (AddressAreaMappingVO) addressAreaMappingDao.getDOByID(id);
	}

	public Boolean modifyAddressAreaMappingVO(
			AddressAreaMappingVO addressAreaMappingVO) {
		return addressAreaMappingDao.updateDO(addressAreaMappingVO);
	}

	public Boolean deleteAddressAreaMappingVOByID(Long id) {
		return addressAreaMappingDao.delDO(id);
	}
}
