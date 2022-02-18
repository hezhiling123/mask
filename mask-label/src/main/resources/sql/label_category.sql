CREATE TABLE `mask`.`Untitled`  (
  `label_category_id` varchar(32) NOT NULL COMMENT '标签类型id',
  `label_category_name` varchar(128) NULL COMMENT '标签类型名称',
  `pic_url` varchar(512) NULL COMMENT '图片地址',
  `share_url` varchar(512) NULL COMMENT '分享地址',
  `on_sale` tinyint(2) NULL COMMENT '售卖状态',
  `new` tinyint(1) NULL COMMENT '新品',
  `hot` tinyint(2) NULL COMMENT '热卖',
  `creator_id` varchar(8) NULL COMMENT '创建者id',
  `creator_name` varchar(32) NULL COMMENT '创建者名称',
  `create_time` datetime(6) NULL COMMENT '创建时间',
  `updator_id` varchar(8) NULL COMMENT '更新者id',
  `updator_name` varchar(32) NULL COMMENT '更新者名称',
  `update_time` datetime(6) NULL COMMENT '更新时间',
  PRIMARY KEY (`label_category_id`)
);