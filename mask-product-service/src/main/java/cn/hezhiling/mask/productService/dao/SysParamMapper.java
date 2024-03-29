package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.sys.model.SysParam;

public interface SysParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysParam record);

    int insertSelective(SysParam record);

    SysParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysParam record);

    int updateByPrimaryKey(SysParam record);

    SysParam selectByCode(String code);
}