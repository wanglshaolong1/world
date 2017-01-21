-- ----------------------------
-- Table structure for `t_tms_distribution_close_reason`
-- ----------------------------
DROP TABLE IF EXISTS tmscore.`t_tms_distribution_close_reason`;
CREATE TABLE `t_tms_distribution_close_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT NULL,
  `dr` smallint(6) DEFAULT NULL,
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tms_distribution_close_reason
-- ----------------------------
INSERT INTO tmscore.`t_tms_distribution_close_reason` VALUES ('1', '缺货', '0', '2016-11-14 14:21:02');
INSERT INTO tmscore.`t_tms_distribution_close_reason` VALUES ('2', '订单关闭', '0', '2016-11-14 14:21:21');
INSERT INTO tmscore.`t_tms_distribution_close_reason` VALUES ('3', '其他', '0', '2016-11-14 14:22:02');

ALTER TABLE tmscore.`t_tms_distribution`
ADD COLUMN `close_reason`  bigint NULL AFTER `appoint_time`,
ADD COLUMN `biz_statu`  smallint NULL AFTER `close_reason`;

ALTER TABLE tmscore.`t_tms_distribution_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`;

ALTER TABLE tmscore.`t_tms_pick_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`;

ALTER TABLE tmscore.`t_tms_deliver_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`;

ALTER TABLE tmscore.`t_tms_distribution_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_pick_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_deliver_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_distribution_detail`
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec`;

ALTER TABLE tmscore.`t_tms_distribution`
ADD COLUMN `pay_amount`  integer NULL AFTER `ts`,
ADD COLUMN `user_name`  varchar(24) NULL AFTER `pay_amount`,
ADD COLUMN `user_address_id`  bigint NULL AFTER `user_name`,
ADD COLUMN `user_address`  varchar(128) NULL AFTER `user_address_id`,
ADD COLUMN `user_phone`  varchar(20) NULL AFTER `user_address`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_sale`
ADD COLUMN `order_id`  bigint NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_distribution_detail`
ADD COLUMN `price`  int NULL AFTER `sku_name`;

-- ----------------------------
-- Table structure for `t_wms_ext_job_type`
-- ----------------------------
DROP TABLE IF EXISTS wmsext.`t_wms_ext_job_type`;
CREATE TABLE wmsext.`t_wms_ext_job_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `url_pattern` varchar(256) DEFAULT NULL,
  `dr` tinyint(4) DEFAULT NULL,
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wms_ext_job_type
-- ----------------------------
INSERT INTO wmsext.`t_wms_ext_job_type` VALUES ('1', '配送单-配送区域', '配送单-配送区域', null, '0', '2016-09-18 12:25:15');
INSERT INTO wmsext.`t_wms_ext_job_type` VALUES ('2', '配送单-缺货', '配送单-缺货', null, '0', '2016-09-18 13:25:38');
INSERT INTO wmsext.`t_wms_ext_job_type` VALUES ('3', '波次单-创建拣货单', '波次单-创建拣货单', null, '0', '2016-10-21 17:54:40');
INSERT INTO wmsext.`t_wms_ext_job_type` VALUES ('4', '订单-销售出库', '订单-销售出库', null, '0', '2016-11-16 16:23:12');

ALTER TABLE tmscore.`t_tms_pick_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec`;

ALTER TABLE tmscore.`t_tms_deliver_detail`
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_booking_delivery_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_inspection_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_order_storage_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_sale_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_product_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_requisitions_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_spoilage_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_stocktaking_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_storage_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_trade_service_shelving_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_transfer_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec_unit_id`;

ALTER TABLE wmsext.`t_wms_ext_booking_delivery_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_inspection_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_order_storage_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_sale_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_product_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_requisitions_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_spoilage_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_stocktaking_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_storage_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_trade_service_shelving_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_transfer_detail`
ADD COLUMN `spec`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_order_storage_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_sale_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_product_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_requisitions_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_spoilage_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_stocktaking_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_storage_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_trade_service_shelving_detail`
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_transfer_detail`
ADD COLUMN `position_old_code`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `position_new_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_distribution_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_pick_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_deliver_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_booking_delivery_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_inspection_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_order_storage_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_outgoing_sale_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_product_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_requisitions_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_spoilage_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_stocktaking_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_storage_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_trade_service_shelving_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmsext.`t_wms_ext_transfer_detail`
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`;

ALTER TABLE wmscore.`t_wms_manage_detail`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `spec`  int NULL AFTER `ts`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec`,
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`,
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE wmscore.`t_wms_inventory`
ADD COLUMN `sale_unit`  varchar(12) NULL AFTER `ts`,
ADD COLUMN `sale_unit_id`  bigint NULL AFTER `sale_unit`,
ADD COLUMN `spec_unit`  varchar(12) NULL AFTER `sale_unit_id`,
ADD COLUMN `spec_unit_id`  bigint NULL AFTER `spec_unit`,
ADD COLUMN `spec`  int NULL AFTER `ts`,
ADD COLUMN `sku_name`  varchar(64) NULL AFTER `spec`,
ADD COLUMN `sale_unit_type`  int NULL AFTER `ts`,
ADD COLUMN `position_code`  varchar(12) NULL AFTER `ts`;

ALTER TABLE tmscore.`t_tms_deliver_detail`
MODIFY COLUMN `sku_name`  varchar(64) NULL DEFAULT NULL AFTER `spec_unit_id`;

ALTER TABLE wmscore.`t_wms_manage_detail`
MODIFY COLUMN `position_code`  varchar(12) NULL DEFAULT NULL AFTER `ts`;

ALTER TABLE wmscore.`t_wms_inventory`
MODIFY COLUMN `position_code`  varchar(12) NULL DEFAULT NULL AFTER `ts`;
