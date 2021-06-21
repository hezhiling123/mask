package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.GoodsCategory;
import cn.hezhiling.mask.model.goods.RecommendGoods;
import cn.hezhiling.mask.vo.CategoryTree;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Short id);
    int insert(GoodsCategory record);
    int insertSelective(GoodsCategory record);
    GoodsCategory selectByPrimaryKey(Short id);
    int updateByPrimaryKeySelective(GoodsCategory record);
    int updateByPrimaryKey(GoodsCategory record);

    List<CategoryTree> selectCategoryTree(@Param("parentId") String parentId, @Param("keywords") String keywords);
    List<CategoryTree> selectCategoryTree3(@Param("parentId") String parentId, @Param("keywords") String keywords);
    List<CategoryTree> selectCategoryByParentId(@Param("parentId") Integer parentId, @Param("isHot") Integer isHot);

    List<GoodsCategory> selectSubCategoryByParentId(@Param("parentId") Integer parentId);

    List<Map> selectGoods();

    List<GoodsCategory> selectAll();

    List<GoodsCategory> selectList(GoodsCategory param);

    List<Integer> selectIdByName(@Param("name") String name);

    PageList<GoodsCategory> queryByPage(@Param("parentId") String parentId, @Param("categoryName") String categoryName, PageBounds pageBounds);

    Integer queryByPageCount(@Param("parentId") String parentId, @Param("categoryName") String categoryName);

    /**
     * 列出所有推荐商品信息
     *
     * @return list of {@link RecommendGoods}
     */
    List<RecommendGoods> listRecommendGoods();
}