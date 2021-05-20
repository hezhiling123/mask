package cn.hezhiling.mask.model.goods;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryDoc {
    private Integer id;
    private Long orderId;
    private String orderSn;
    private String userId;
    private String adminId;
    private String consignee;
    private String zipcode;
    private String mobile;
    private Integer country;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String shippingCode;
    private String shippingName;
    private BigDecimal shippingPrice;
    private String invoiceNo;
    private String tel;
    private Integer bestTime;
    private Integer createTime;
    private Boolean isDel;
    private String note;
}