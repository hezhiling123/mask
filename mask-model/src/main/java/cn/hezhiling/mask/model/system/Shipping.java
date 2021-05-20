package cn.hezhiling.mask.model.system;

import lombok.Data;

@Data
public class Shipping {
    private Byte shippingId;
    private String shippingCode;
    private String shippingName;
    private String shippingDesc;
    private String insure;
    private Boolean enabled;
}