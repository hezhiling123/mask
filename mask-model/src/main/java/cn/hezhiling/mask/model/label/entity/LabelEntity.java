package cn.hezhiling.mask.model.label.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hezhiling
 * @date 2021/8/31 15:40
 * @since V1.0
 */
@Data
public class LabelEntity {
	/**
	 * 标签id
	 */
	private String labelId;
	/**
	 * 拥有者id
	 */
	private String ownerId;
	/**
	 * 标签名称
	 */
	private String labelName;
	/**
	 * 标签类型id
	 */
	private String labelCategoryId;
	/**
	 * 标签类型名称
	 */
	private String labelCategoryName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 开始访问时间
	 */
	private Date openTime;
	/**
	 * 二维码
	 */
	private String qrCode;
	/**
	 * 是否开放
	 */
	private Boolean open;
	/**
	 * 标签图片地址
	 */
	private String iconImageUrl;
}
