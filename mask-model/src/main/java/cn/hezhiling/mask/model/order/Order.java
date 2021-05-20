package cn.hezhiling.mask.model.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {

    /*
    * 用来标识是普通订单还是秒杀订单
    * P:普通订单
    * K:秒杀订单
    * */
    private String orderType;
    private Long orderId;
    private String orderSn;
    private String userId;
    private Integer orderStatus;
    private Integer shippingStatus;
    private Integer payStatus;
    private String consignee;
    private String area;
    private String address;
    private String zipcode;
    private String mobile;
    private String email;
    private String shippingCode;
    private String shippingName;
    private String payCode;
    private String payName;
    private String invoiceTitle;
    private BigDecimal goodsPrice;
    private BigDecimal shippingPrice;
    private BigDecimal userMoney;
    private BigDecimal couponPrice;
    private Integer integral;
    private BigDecimal integralMoney;
    private BigDecimal orderAmount;
    private BigDecimal totalAmount;
    private Long addTime;
    private Long shippingTime;
    private Long confirmTime;
    private Long payTime;
    private Short orderPromId;
    private BigDecimal orderPromAmount;
    private BigDecimal discount;
    private String userNote;
    private String adminNote;
    private String parentSn;
    private Boolean isDistribut;
    private Long receiveTime;

}