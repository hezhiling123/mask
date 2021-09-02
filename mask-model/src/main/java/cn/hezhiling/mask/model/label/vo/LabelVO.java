package cn.hezhiling.mask.model.label.vo;

import cn.hezhiling.mask.model.label.entity.LabelEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hezhiling
 * @date 2021/9/2 16:12
 * @since V1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LabelVO extends LabelEntity {
	/**
	 * 标签类型名称
	 */
	private String labelCategoryName;
	/**
	 * 祖标签类型id
	 */
	private Integer rootCategoryId;
	/**
	 * 图片url
	 */
	private String picUrl;
	/**
	 * 分享url
	 */
	private String shareUrl;
	/**
	 * 是否在售
	 */
	private Boolean isOnSale;
	/**
	 * 是否为新的
	 */
	private Boolean isNew;
	/**
	 * 是否是热销
	 */
	private Boolean isHot;
}
