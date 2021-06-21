package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.GoodsAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsAttrMapper {
    int deleteByPrimaryKey(Integer goodsAttrId);
    int insert(GoodsAttr record);
    int insertSelective(GoodsAttr record);
    GoodsAttr selectByPrimaryKey(Integer goodsAttrId);
    int updateByPrimaryKeySelective(GoodsAttr record);
    int updateByPrimaryKeyWithBLOBs(GoodsAttr record);
    int updateByPrimaryKey(GoodsAttr record);
    List<GoodsAttr> selectByGoodsId(Integer goodsId);
    int deleteByGoodsId(@Param("goodsId") Integer goodsId, @Param("excludeList") List<Short> excludeList);
    int insertBatch(List<GoodsAttr> list);
}