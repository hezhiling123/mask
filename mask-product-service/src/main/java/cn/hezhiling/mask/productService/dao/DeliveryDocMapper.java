package cn.hezhiling.mask.productService.dao;

import cn.hezhiling.mask.model.goods.DeliveryDoc;

import java.util.List;

public interface DeliveryDocMapper {
    int selectByOrderId(Integer id);

    int insert(DeliveryDoc record);

    int insertSelective(DeliveryDoc record);

    DeliveryDoc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryDoc record);

    int updateByPrimaryKeyWithBLOBs(DeliveryDoc record);

    int updateByPrimaryKey(DeliveryDoc record);

    List<DeliveryDoc> selectByOrderId(int orderId);
}