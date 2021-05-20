package cn.hezhiling.mask.model.spec;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SpecGoodsPrice {
    private Integer id;
    private Integer goodsId;
    private String key;
    private String keyName;
    private BigDecimal price;
    private Integer storeCount;
    private String barCode;
    private String sku;
    private List<SpecGoodsImage> specGoodsImagesList;
}