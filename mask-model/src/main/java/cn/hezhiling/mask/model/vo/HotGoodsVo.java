package cn.hezhiling.mask.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Ray
 * @date 2018/2/11.
 */
@Data
public class HotGoodsVo {
    private int id;
    private String name;
    private List<GoodsPageVo> list;
}
