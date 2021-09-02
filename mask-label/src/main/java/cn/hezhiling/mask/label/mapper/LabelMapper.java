package cn.hezhiling.mask.label.mapper;

import cn.hezhiling.mask.model.label.entity.LabelEntity;
import cn.hezhiling.mask.model.label.vo.LabelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hezhiling
 * @date 2021/8/31 16:13
 * @since V1.0
 */
@Mapper
@Repository
public interface LabelMapper {
	/**
	 * 列出该拥有者下面的所有的标签
	 *
	 * @param ownerId	拥有方id
	 * @return	该拥有方拥有的所有标签
	 */
	List<LabelVO> listLabelByOwnerId(@Param("ownerId") String ownerId);

	/**
	 * 插入一条标签信息
	 *
	 * @param labelEntity	插入一条标签信息
	 */
	void insertOne(LabelEntity labelEntity);
}
