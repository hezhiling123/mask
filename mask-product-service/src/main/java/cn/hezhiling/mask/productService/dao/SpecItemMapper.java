package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.spec.SpecItem;

import java.util.List;

public interface SpecItemMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(SpecItem record);
    int insertSelective(SpecItem record);
    SpecItem selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(SpecItem record);
    int updateByPrimaryKey(SpecItem record);
    List<SpecItem> selectListBySpecId(Integer specId);
    void deleteBySpecId(int specId);

}