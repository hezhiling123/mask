package cn.hezhiling.mask.model.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderGoods {

    /*
     * 用来标识是普通订单还是秒杀订单
     * P:普通订单
     * K:秒杀订单
     * */
    private String orderType;
    private Long recId;
    private Long orderId;
    private Integer specGoodsId;
    private Integer goodsId;
    private String goodsName;
    private String goodsSn;
    private Short goodsNum;
    private BigDecimal marketPrice;
    private BigDecimal goodsPrice;
    private BigDecimal costPrice;
    private BigDecimal memberGoodsPrice;
    private Integer giveIntegral;
    private String specKey;
    private String specKeyName;
    private String barCode;
    private Boolean isComment;
    private Boolean promType;
    private Integer promId;
    private Boolean isSend;
    private Integer deliveryId;
    private String sku;
    private String originalImg;
}