package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.KillGoodsPrice;
import cn.hezhiling.mask.vo.KillGoodsSpecPriceDetailVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

public interface KillGoodsPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KillGoodsPrice record);

    int selectCountBySpecGoodId(Integer specGoodsId);
    KillGoodsPrice selectByPrimaryKey(Integer id);
    KillGoodsPrice selectBySpecGoodsId(Integer specGoodsId);
    KillGoodsSpecPriceDetailVo detailBySpecGoodId(Integer specGoodsId);
    KillGoodsSpecPriceDetailVo detail(Integer id);

    int updateByPrimaryKey(KillGoodsPrice record);

    int updateSecKill(KillGoodsPrice record);

    int updateBySpecGoodsId(KillGoodsPrice record);

    PageList<KillGoodsSpecPriceDetailVo> select(@Param("keyword") String keyword, PageBounds pageBounds);

    Integer selectTotalCount(@Param("keyword") String keyword);
    PageList<KillGoodsSpecPriceDetailVo> selectView(PageBounds pageBounds);

    Integer selectViewTotalCount();
}