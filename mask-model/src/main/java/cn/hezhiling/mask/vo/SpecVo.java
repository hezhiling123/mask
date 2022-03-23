package cn.hezhiling.mask.vo;

import cn.hezhiling.mask.model.spec.Spec;

import java.io.Serializable;

/**
 * @author Ray
 * @date 2018/3/14.
 */
public class SpecVo extends Spec implements Serializable {

    private static final long serialVersionUID = 4605734741336139142L;
    private String goodsType;

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }
}
