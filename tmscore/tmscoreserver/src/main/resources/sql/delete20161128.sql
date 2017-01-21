-- wmscore

-- 库存
delete from wmscore.t_wms_inventory; 

-- 库存管理
delete from wmscore.t_wms_manage; 

-- 库存管理明细
delete from wmscore.t_wms_manage_detail; 

-- tmscore

-- 波次
delete from tmscore.t_tms_wave; 

-- 波次明细
delete from tmscore.t_tms_wave_detail; 

-- 拣货
delete from tmscore.t_tms_pick; 

-- 拣货明细
delete from tmscore.t_tms_pick_detail;

-- 送货单
delete from tmscore.t_tms_deliver;

-- 送货单明细
delete from tmscore.t_tms_deliver_detail;

-- 送货单配送单
delete from tmscore.t_tms_deliver_distribution;

-- wmsext

-- 出库
delete from wmsext.t_wms_ext_outgoing; 

-- 出库明细
delete from wmsext.t_wms_ext_outgoing_detail; 

-- 入库
delete from wmsext.t_wms_ext_storage; 

-- 入库明细
delete from wmsext.t_wms_ext_storage_detail; 

-- 报损
delete from wmsext.t_wms_ext_spoilage; 

-- 报损明细
delete from wmsext.t_wms_ext_spoilage_detail; 

-- 移库
delete from wmsext.t_wms_ext_transfer; 

-- 移库明细
delete from wmsext.t_wms_ext_transfer_detail; 

-- 盘点
delete from wmsext.t_wms_ext_stocktaking; 

-- 盘点明细
delete from wmsext.t_wms_ext_stocktaking_detail; 

-- 工单
delete from wmsext.t_wms_ext_job; 

-- 销售出库
delete from wmsext.t_wms_ext_outgoing_sale; 

-- 销售出库明细
delete from wmsext.t_wms_ext_outgoing_sale_detail; 