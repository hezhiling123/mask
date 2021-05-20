package cn.hezhiling.mask.dao;

import cn.hezhiling.mask.model.spec.SpecGoodsImage;

import java.util.List;

public interface SpecGoodsImageMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(SpecGoodsImage record);
    int insertSelective(SpecGoodsImage record);
    SpecGoodsImage selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(SpecGoodsImage record);
    int updateByPrimaryKey(SpecGoodsImage record);
    List<SpecGoodsImage> selectBySpecGoodsId(Integer specGoodsId);
    int deleteByGoodsId(Integer goodsId);
    int insertBatch(List<SpecGoodsImage> list);
}