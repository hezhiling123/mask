package cn.hezhiling.mask.model.label.vo;

import cn.hezhiling.mask.model.label.entity.LabelEntity;
import lombok.Data;

import java.util.List;

/**
 * @author hezhiling
 * @date 2021/8/31 16:06
 * @since V1.0
 */
@Data
public class LabelListVO {
	/**
	 * 标签类型id
	 */
	private String labelCategoryId;
	/**
	 * 标签类型名称
	 */
	private String labelCategoryName;
	/**
	 * 祖标签类型id
	 */
	private String rootCategoryId;
	/**
	 * 祖标签类型名称
	 */
	private String rootCategoryName;
	/**
	 * 是否在售
	 */
	private Boolean isOnSale;
	/**
	 * 排序顺序
	 */
	private Boolean sortOrder;
	/**
	 * 是新品
	 */
	private Boolean isNew;
	/**
	 * 热销商品
	 */
	private Boolean isHot;
	/**
	 * 标签列表
	 */
	private List<LabelEntity> labelList;
}
