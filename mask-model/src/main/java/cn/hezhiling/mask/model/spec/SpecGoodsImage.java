package cn.hezhiling.mask.model.spec;

import lombok.Data;

import java.util.Date;

@Data
public class SpecGoodsImage {
    private Integer id;
    private Integer specGoodsId;
    private String src;
    private Date createTime;
}