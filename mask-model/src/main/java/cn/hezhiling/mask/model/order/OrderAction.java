package cn.hezhiling.mask.model.order;

import lombok.Data;

@Data
public class OrderAction {

    /*
     * 用来标识是普通订单还是秒杀订单
     * P:普通订单
     * K:秒杀订单
     * */
    private String orderType;
    private Long actionId;
    private Long orderId;
    private String actionUser;
    private String tradeType;
    private String prepayId;
    private String codeUrl;
    private Integer orderStatus;
    private Integer shippingStatus;
    private Integer payStatus;
    private String actionNote;
    private Long logTime;
    private String statusDesc;
}