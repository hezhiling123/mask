package cn.hezhiling.mask.model.goods;

import lombok.Data;

@Data
public class GoodsAttribute {
    private Integer attrId;
    private String attrName;
    private Short typeId;
    private Byte attrIndex;
    private Byte attrType;
    private Byte attrInputType;
    private Byte order;
    private String attrValues;
}