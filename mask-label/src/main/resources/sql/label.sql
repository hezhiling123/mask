CREATE TABLE `mask`.`label` (
  `id` INT NOT NULL,
  `label_category_id` INT NULL,
  `label_name` VARCHAR(45) NULL,
  `owner_id` INT NULL,
  `create_time` TIMESTAMP(6) NULL,
  `open_time` TIMESTAMP(6) NULL,
  `open` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`));