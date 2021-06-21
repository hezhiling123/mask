package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.GoodsImages;

import java.util.List;

public interface GoodsImagesMapper {
    int deleteByPrimaryKey(Integer imgId);
    int insert(GoodsImages record);
    int insertSelective(GoodsImages record);
    GoodsImages selectByPrimaryKey(Integer imgId);
    int updateByPrimaryKeySelective(GoodsImages record);
    int updateByPrimaryKey(GoodsImages record);
    List<GoodsImages> selectByGoodsId(Integer goodsId);
    int deleteByGoodsId(Integer goodsId);
    int insertBatch(List<GoodsImages> list);
}