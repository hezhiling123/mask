package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.GoodsType;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Short id);
    int insert(GoodsType record);
    int insertSelective(GoodsType record);
    GoodsType selectByPrimaryKey(Short id);
    int updateByPrimaryKeySelective(GoodsType record);
    int updateByPrimaryKey(GoodsType record);
    PageList<GoodsType> queryByPage(@Param("name") String name, PageBounds pageBounds);
    Integer queryByPageTotalCount(@Param("name") String name);
    List<GoodsType> queryAll();
}