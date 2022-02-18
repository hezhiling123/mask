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
	private Boolean onSale;

	/**
	 * 是否新上架
	 */
	private Boolean newFlag;

	/**
	 * 是否热卖
	 */
	private Boolean hotFlag;
}
