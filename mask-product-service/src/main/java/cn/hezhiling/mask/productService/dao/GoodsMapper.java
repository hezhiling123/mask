package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.Goods;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAll();

    int deteteBatch(Integer[] goodsIds);

    PageList<Goods> queryListPageFromDB(@Param("subCatList") List<Integer> subCatList,
                                        @Param("keywords") String keyword, PageBounds pageBounds);

    List<Goods> queryListPageFromDB(@Param("subCatList") List<Integer> subCatList, @Param("keywords") String keyword);

    Integer queryListPageFromDBTotalCount(@Param("subCatList") List<Integer> subCatList, @Param("keywords") String keyword);

    Goods selectDetailByGoodsId(Integer goodsId);

}