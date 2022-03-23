package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.GoodsAttribute;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

public interface GoodsAttributeMapper {
    int deleteByPrimaryKey(Integer attrId);

    int insert(GoodsAttribute record);

    int insertSelective(GoodsAttribute record);

    GoodsAttribute selectByPrimaryKey(Integer attrId);

    int updateByPrimaryKeySelective(GoodsAttribute record);

    int updateByPrimaryKeyWithBLOBs(GoodsAttribute record);

    int updateByPrimaryKey(GoodsAttribute record);

    PageList<GoodsAttribute> queryByPage(GoodsAttribute param, PageBounds pageBounds);

    Integer queryByPageTotalCount(GoodsAttribute param);

    List<GoodsAttribute> selectListByTypeId(Short typeId);
}