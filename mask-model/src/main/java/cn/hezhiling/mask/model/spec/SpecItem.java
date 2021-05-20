package cn.hezhiling.mask.model.spec;

import lombok.Data;

@Data
public class SpecItem {
    private Integer id;
    private Integer specId;
    private String item;
    private boolean checked;
}