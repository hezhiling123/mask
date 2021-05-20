package cn.hezhiling.mask.dao;

import cn.hezhiling.mask.model.spec.Spec;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Spec record);
    int insertSelective(Spec record);
    Spec selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Spec record);
    int updateByPrimaryKey(Spec record);
    List<Spec> selectListByTypeId(Integer typeId);

    PageList<Spec> queryByPage(@Param("name") String name, @Param("typeId") Integer typeId, PageBounds pageBounds);

    Integer queryByPageTotalCount(@Param("name") String name, @Param("typeId") Integer typeId);
}