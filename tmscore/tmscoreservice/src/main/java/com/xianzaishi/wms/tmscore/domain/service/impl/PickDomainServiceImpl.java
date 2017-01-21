package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.hive.domain.client.itf.IInventoryDomainClient;
import com.xianzaishi.wms.hive.vo.InventoryVO;
import com.xianzaishi.wms.job.domain.client.itf.IJobDomainClient;
import com.xianzaishi.wms.job.vo.JobVO;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDistributionDomainService;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IPickDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IPickService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketStatuService;
import com.xianzaishi.wms.tmscore.service.itf.IWaveDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IWaveService;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public class PickDomainServiceImpl implements IPickDomainService {
	@Autowired
	private IPickService pickService = null;
	@Autowired
	private IPickDetailService pickDetailService = null;
	@Autowired
	private IPickingBasketStatuService pickingBasketStatuService = null;
	@Autowired
	private IPickingBasketService pickingBasketService = null;
	@Autowired
	private IWaveService waveService = null;
	@Autowired
	private IWaveDetailService waveDetailService = null;
	@Autowired
	private IInventoryDomainClient inventoryDomainClient = null;
	@Autowired
	private IDistributionDomainService distributionDomainService = null;
	@Autowired
	private IJobDomainClient jobDomainClient = null;

	public Boolean createPickDomain(PickVO pickVO) {
		if (pickVO.getDetails() == null || pickVO.getDetails().isEmpty()) {
			throw new BizException("请填充入库明细！");
		}

		Long pickID = pickService.addPickVO(pickVO);

		initDetails(pickID, pickVO.getDetails());

		pickDetailService.batchAddPickDetailVO(pickVO.getDetails());

		return true;
	}

	public PickVO getPickDomainByID(Long pickID) {
		if (pickID == null || pickID <= 0) {
			throw new BizException("id error");
		}

		PickVO pickVO = pickService.getPickVOByID(pickID);

		pickVO.setDetails(pickDetailService.getPickDetailVOByPickID(pickID));

		return pickVO;
	}

	public Boolean deletePickDomain(Long pickID) {
		if (pickID == null || pickID <= 0) {
			throw new BizException("id error");
		}

		List<PickDetailVO> pickDetailVOs = pickDetailService
				.getPickDetailVOByPickID(pickID);

		pickDetailService.batchDeletePickDetailVO(pickDetailVOs);

		pickService.deletePickVOByID(pickID);

		return true;
	}

	public Boolean addPickVO(PickVO pickVO) {
		pickService.addPickVO(pickVO);
		return true;
	}

	public List<PickVO> queryPickVOList(PickQueryVO pickQueryVO) {
		return pickService.queryPickVOList(pickQueryVO);
	}

	public PickVO getPickVOByID(Long id) {
		return pickService.getPickVOByID(id);
	}

	public Boolean modifyPickVO(PickVO pickVO) {
		return pickService.modifyPickVO(pickVO);
	}

	public Boolean deletePickVO(Long id) {
		return pickService.deletePickVOByID(id);
	}

	public Boolean createPickDetailVO(PickDetailVO pickDetailVO) {
		pickDetailVO.init();
		return pickDetailService.addPickDetailVO(pickDetailVO);
	}

	public Boolean batchCreatePickDetailVO(List<PickDetailVO> pickDetailVOs) {
		for (PickDetailVO pickDetailVO : pickDetailVOs) {
			pickDetailVO.init();
		}
		return pickDetailService.batchAddPickDetailVO(pickDetailVOs);
	}

	public List<PickDetailVO> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO) {
		return pickDetailService.queryPickDetailVOList(pickDetailQueryVO);
	}

	public List<PickDetailVO> getPickDetailVOListByPickID(Long pickID) {
		return pickDetailService.getPickDetailVOByPickID(pickID);
	}

	public PickDetailVO getPickDetailVOByID(Long id) {
		return pickDetailService.getPickDetailVOByID(id);
	}

	public Boolean modifyPickDetailVO(PickDetailVO pickDetailVO) {
		pickDetailVO.init();
		return pickDetailService.modifyPickDetailVO(pickDetailVO);
	}

	public Boolean batchModifyPickDetailVOs(List<PickDetailVO> pickDetailVOs) {
		for (PickDetailVO pickDetailVO : pickDetailVOs) {
			pickDetailVO.init();
		}
		return pickDetailService.batchModifyPickDetailVO(pickDetailVOs);
	}

	public Boolean deletePickDetailVO(Long id) {
		return pickDetailService.deletePickDetailVOByID(id);
	}

	public Boolean deletePickDetailVOByPickID(Long pickID) {
		if (pickID == null || pickID <= 0) {
			throw new BizException("id error");
		}

		List<PickDetailVO> pickDetailVOs = pickDetailService
				.getPickDetailVOByPickID(pickID);

		pickDetailService.batchDeletePickDetailVO(pickDetailVOs);
		return true;
	}

	public Boolean batchDeletePickDetailVOByPickID(List<Long> storyDetailIDs) {
		return pickDetailService.batchDeletePickDetailVOByID(storyDetailIDs);
	}

	private void initDetails(Long id, List<PickDetailVO> pickDetailVOs) {
		for (int i = 0; i < pickDetailVOs.size(); i++) {
			pickDetailVOs.get(i).setPickId(id);
			pickDetailVOs.get(i).init();
		}
	}

	public IPickService getPickService() {
		return pickService;
	}

	public void setPickService(IPickService pickService) {
		this.pickService = pickService;
	}

	public IPickDetailService getPickDetailService() {
		return pickDetailService;
	}

	public void setPickDetailService(IPickDetailService pickDetailService) {
		this.pickDetailService = pickDetailService;
	}

	public PickVO assignPickVO(Long agencyID, Long operator) {
		PickQueryVO queryVO = new PickQueryVO();
		queryVO.setAgencyId(agencyID);
		queryVO.setStatu(Short.parseShort("0"));
		List<PickVO> pickVOs = pickService.queryPickVOList(queryVO);
		for (int i = 0; i < pickVOs.size(); i++) {
			pickVOs.get(i).setOperator(operator);
			pickVOs.get(i).setStatu(Short.parseShort("1"));
			PickVO pickVO = pickService.assign(pickVOs.get(i));
			if (pickVO != null) {
				return pickVO;
			}
		}
		return null;
	}

	public Boolean submitPickedDetail(List<PickDetailVO> pickDetailVOs) {
		for (PickDetailVO pickDetailVO : pickDetailVOs) {
			pickDetailVO.init();
		}
		batchModifyPickDetailVOs(pickDetailVOs);
		List basketIDs = new LinkedList();
		boolean pickedItem = false;
		for (int i = 0; i < pickDetailVOs.size(); i++) {
			basketIDs.add(pickDetailVOs.get(i).getBasketId());
			if (pickDetailVOs.get(i).getPickedNoReal() != 0) {
				pickedItem = true;
			}
		}
		if (!pickedItem) {
			cancelPickTask(pickDetailVOs.get(0).getPickId());
		} else {
			PickVO pickVO = new PickVO();
			pickVO.setStatu(Short.parseShort("2"));
			pickVO.setId(pickDetailVOs.get(0).getPickId());
			modifyPickVO(pickVO);
		}
		pickingBasketStatuService.assign(pickDetailVOs.get(0).getPickId(),
				basketIDs);
		return true;
	}

	public IPickingBasketStatuService getPickingBasketStatuService() {
		return pickingBasketStatuService;
	}

	public void setPickingBasketStatuService(
			IPickingBasketStatuService pickingBasketStatuService) {
		this.pickingBasketStatuService = pickingBasketStatuService;
	}

	public Boolean recievePickingBasket(String pickingBasketBarcode) {
		PickingBasketQueryVO queryVO = new PickingBasketQueryVO();
		queryVO.setBarcode(pickingBasketBarcode);
		PickingBasketVO pickingBasketVO = pickingBasketService
				.queryPickingBasketVOList(queryVO).get(0);
		PickingBasketStatuQueryVO pickingBasketStatuQueryVO = new PickingBasketStatuQueryVO();
		pickingBasketStatuQueryVO.setBasketId(pickingBasketVO.getId());

		List<PickingBasketStatuVO> pickingBasketStatuResults = pickingBasketStatuService
				.queryPickingBasketStatuVOList(pickingBasketStatuQueryVO);

		if (pickingBasketStatuResults == null
				|| pickingBasketStatuResults.isEmpty()) {
			throw new BizException("请检查拣货筐状态");
		}

		PickingBasketStatuVO pickingBasketStatuVO = pickingBasketStatuResults
				.get(0);
		pickingBasketStatuVO.setStatu(1);
		pickingBasketStatuService
				.modifyPickingBasketStatuVO(pickingBasketStatuVO);
		pickingBasketStatuQueryVO = new PickingBasketStatuQueryVO();
		pickingBasketStatuQueryVO.setAssignmentId(pickingBasketStatuVO
				.getAssignmentId());
		pickingBasketStatuQueryVO.setStatu(0);
		List pickingBasketStatuVOs = pickingBasketStatuService
				.queryPickingBasketStatuVOList(pickingBasketStatuQueryVO);
		if (pickingBasketStatuVOs == null || pickingBasketStatuVOs.isEmpty()) {
			PickVO pickVO = new PickVO();
			pickVO.setId(pickingBasketStatuVO.getAssignmentId());
			pickVO.setStatu(Short.parseShort("3"));
			pickService.modifyPickVO(pickVO);
		}
		return true;
	}

	public IPickingBasketService getPickingBasketService() {
		return pickingBasketService;
	}

	public void setPickingBasketService(
			IPickingBasketService pickingBasketService) {
		this.pickingBasketService = pickingBasketService;
	}

	public Boolean cancelPickTask(Long pickID) {
		pickService.cancelPickTask(pickID);
		PickQueryVO pickQueryVO = new PickQueryVO();
		Long waveID = pickService.getPickVOByID(pickID).getWaveId();
		pickQueryVO.setWaveId(waveID);
		List<PickVO> pickVOs = pickService.queryPickVOList(pickQueryVO);
		boolean finished = true;
		for (int i = 0; i < pickVOs.size(); i++) {
			if (pickVOs.get(i).getStatu() != 3) {
				finished = false;
				break;
			}
		}
		if (finished) {
			waveService.waveFinished(waveID);
		}
		return true;
	}

	public IWaveService getWaveService() {
		return waveService;
	}

	public void setWaveService(IWaveService waveService) {
		this.waveService = waveService;
	}

	public List<PickingBasketVO> getPickingBasketVOsByPickID(Long pickID) {
		List<PickingBasketVO> pickingBasketVOs = new LinkedList<PickingBasketVO>();
		PickingBasketStatuQueryVO pickingBasketStatuQueryVO = new PickingBasketStatuQueryVO();
		pickingBasketStatuQueryVO.setAssignmentId(pickID);
		List<PickingBasketStatuVO> pickingBasketStatuVOs = pickingBasketStatuService
				.queryPickingBasketStatuVOList(pickingBasketStatuQueryVO);
		for (int i = 0; i < pickingBasketStatuVOs.size(); i++) {
			pickingBasketVOs.add(pickingBasketService
					.getPickingBasketVOByID(pickingBasketStatuVOs.get(i)
							.getBasketId()));
		}
		return pickingBasketVOs;
	}

	public Boolean outOfStock(PickDetailVO pickDetailVO) {
		pickDetailVO.init();
		Long agencyID = pickDetailVO.getAgencyId();
		List<InventoryVO> inventories = inventoryDomainClient
				.getInventoryBySKUID(agencyID, pickDetailVO.getSkuId())
				.getTarget();
		PickVO pickvo = getPickDomainByID(pickDetailVO.getPickId());
		WaveVO waveVO = waveService.getWaveVOByID(pickvo.getWaveId());
		Integer remain = pickDetailVO.getOrderNoReal()
				- pickDetailVO.getPickedNoReal();
		Integer pick = 0;
		List<PickDetailVO> needs = new LinkedList<PickDetailVO>();
		List<WaveDetailVO> needRemove = new LinkedList<WaveDetailVO>();
		for (int i = 0; i < inventories.size(); i++) {
			if (inventories.get(i).getPositionId()
					.equals(pickDetailVO.getPositionId())
					|| inventories.get(i).getNumberReal() <= 0) {
				continue;
			} else {
				PickDetailVO tempPickDetailVO = new PickDetailVO();
				tempPickDetailVO.setPositionId(inventories.get(i)
						.getPositionId());
				tempPickDetailVO.setAreaId(inventories.get(i).getAreaId());
				tempPickDetailVO.setAgencyId(agencyID);
				tempPickDetailVO.setSkuId(inventories.get(i).getSkuId());
				if (inventories.get(i).getNumberReal() > remain - pick) {
					tempPickDetailVO.setOrderNoReal(remain - pick);
					pick = remain;
					needs.add(tempPickDetailVO);
					break;
				} else {
					tempPickDetailVO.setOrderNoReal(inventories.get(i)
							.getNumberReal());
					pick = pick + inventories.get(i).getNumberReal();
					needs.add(tempPickDetailVO);
				}
			}
		}
		if (!pick.equals(remain)) {

			waveVO.setDetails(waveDetailService.getWaveDetailVOByWaveID(pickvo
					.getWaveId()));

			Integer remove = 0;
			Integer out = 0;
			Boolean full = false;
			for (int i = 1; i <= waveVO.getDetails().size(); i++) {
				DistributionVO tempDistributionVO = distributionDomainService
						.getDistributionDomainByID(waveVO.getDetails()
								.get(waveVO.getDetails().size() - i)
								.getDistributionId());
				for (int j = 0; j < tempDistributionVO.getDetails().size(); j++) {
					if (tempDistributionVO.getDetails().get(j).getSkuId()
							.equals(pickDetailVO.getSkuId())) {
						if (!needRemove.contains(waveVO.getDetails().get(
								waveVO.getDetails().size() - i))) {
							needRemove.add(waveVO.getDetails().get(
									waveVO.getDetails().size() - i));
						}
						if ((out = tempDistributionVO.getDetails().get(j)
								.getDelivNoReal()
								- (remain - pick - remove)) >= 0) {
							full = true;
							break;
						} else {
							remove += tempDistributionVO.getDetails().get(j)
									.getDelivNoReal();
						}
					}
				}
				if (full) {
					break;
				}
			}
			Integer outRemove = 0;
			if (out > 0) {
				while (needs.size() > 0) {
					if (needs.get(needs.size() - 1).getOrderNoReal() > out
							- outRemove) {
						needs.get(needs.size() - 1).setOrderNoReal(
								needs.get(needs.size() - 1).getOrderNoReal()
										- (out - outRemove));
						break;
					} else {
						outRemove += needs.get(needs.size() - 1)
								.getOrderNoReal();
						needs.remove(needs.size() - 1);
					}
				}
			}
		}
		for (WaveDetailVO waveDetailVO : needRemove) {
			waveDetailService.deleteWaveDetailVOByID(waveDetailVO.getId());
			DistributionVO temp = new DistributionVO();
			distributionDomainService.suspendDistribution(waveDetailVO
					.getDistributionId());
			JobVO jobVO = new JobVO();
			jobVO.setType(1);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", waveDetailVO.getDistributionId());
			jsonObject.put("skuId", pickDetailVO.getSkuId());
			jobVO.setParameter(jsonObject.toString());
			jobVO.setStatu(0);
			jobDomainClient.addJob(jobVO);
		}
		Map<Long, PickVO> areaMaps = new HashMap<Long, PickVO>();
		for (PickDetailVO item : needs) {
			if (!areaMaps.containsKey(item.getAreaId())) {
				PickVO pickVO = new PickVO();
				areaMaps.put(item.getAreaId(), pickVO);

				pickVO.setAreaId(item.getAreaId());
				pickVO.setAgencyId(agencyID);
				pickVO.setStatu(Short.parseShort("0"));
				pickVO.setWaveId(waveVO.getId());

				addPickDetail(pickVO, item);
			} else {
				addPickDetail(areaMaps.get(pickDetailVO.getAreaId()), item);
			}
		}
		for (PickVO pickVO : areaMaps.values()) {
			createPickDomain(pickVO);
		}
		if (areaMaps.size() > 0) {
			if (waveVO.getSingle() == 1) {
				waveVO.setSingle(0);
				waveVO.setAreaId(0l);
				waveService.modifyWaveVO(waveVO);
			}
		}
		return true;
	}

	private void addPickDetail(PickVO pickVO, PickDetailVO pickDetailVO) {
		if (pickVO.getDetails() == null) {
			pickVO.setDetails(new LinkedList<PickDetailVO>());
		}
		pickVO.getDetails().add(pickDetailVO);
	}

	public IInventoryDomainClient getInventoryDomainClient() {
		return inventoryDomainClient;
	}

	public void setInventoryDomainClient(
			IInventoryDomainClient inventoryDomainClient) {
		this.inventoryDomainClient = inventoryDomainClient;
	}

	public IWaveDetailService getWaveDetailService() {
		return waveDetailService;
	}

	public void setWaveDetailService(IWaveDetailService waveDetailService) {
		this.waveDetailService = waveDetailService;
	}

	public IDistributionDomainService getDistributionDomainService() {
		return distributionDomainService;
	}

	public void setDistributionDomainService(
			IDistributionDomainService distributionDomainService) {
		this.distributionDomainService = distributionDomainService;
	}

	public IJobDomainClient getJobDomainClient() {
		return jobDomainClient;
	}

	public void setJobDomainClient(IJobDomainClient jobDomainClient) {
		this.jobDomainClient = jobDomainClient;
	}

}
