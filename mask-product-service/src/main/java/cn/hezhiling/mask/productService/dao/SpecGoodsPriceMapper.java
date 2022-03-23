package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.spec.SpecGoodsPrice;
import cn.hezhiling.mask.vo.GoodsSpecPriceDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecGoodsPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecGoodsPrice record);

    int insertSelective(SpecGoodsPrice record);

    SpecGoodsPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecGoodsPrice record);

    int updateByPrimaryKey(SpecGoodsPrice record);

    List<SpecGoodsPrice> selectByGoodsId(Integer goodsId);

    Integer selectDefaultIdByGoodsId(Integer goodsId);

    int deleteByGoodsId(@Param("goodsId") Integer goodsId, @Param("excludeList") List<Integer> excludeList);

    int insertBatch(List<SpecGoodsPrice> list);

    GoodsSpecPriceDetailVo selectDetailById(Integer id);
}