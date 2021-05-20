package cn.hezhiling.mask.model.goods;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GoodsCategory {
    private Integer id;
    private String name;
    private String mobileName;
    private Integer parentId;
    private String parentIdPath;
    private Short level;
    private Short sortOrder;
    private Boolean isShow;
    private String image;
    private Boolean isHot;
    private Boolean catGroup;
    private Boolean commissionRate;
}