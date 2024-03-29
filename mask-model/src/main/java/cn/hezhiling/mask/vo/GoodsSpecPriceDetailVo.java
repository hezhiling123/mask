package cn.hezhiling.mask.vo;

import cn.hezhiling.mask.model.spec.SpecGoodsPrice;

import java.io.Serializable;

public class GoodsSpecPriceDetailVo extends SpecGoodsPrice implements Serializable {
    private String goodsName;
    private String originalImg;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOriginalImg() {
        return originalImg;
    }

    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg;
    }
}
