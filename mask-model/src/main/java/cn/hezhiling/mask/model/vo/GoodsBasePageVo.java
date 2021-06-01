package cn.hezhiling.mask.model.vo;

import cn.hezhiling.mask.SysPropUtil;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsBasePageVo {
    private Integer goodsId;//商品id
    private String goodsName;//商品名称
    private String goodsRemark;//商品描述
    private Short storeCount;//商品库存
    private Short commentCount;//评论数
    private BigDecimal shopPrice;//店面价
    private String originalImg;//商品上传原始图

    private Boolean isRecommend;//是否推荐
    private Boolean isNew;//是否新品
    private Boolean isHot;//是否热卖

    public String getOriginalImg() {
        return SysPropUtil.getPicDomain(originalImg) ;
    }
}

