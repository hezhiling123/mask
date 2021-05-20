package cn.hezhiling.mask.model.spec;

import lombok.Data;

import java.util.List;

@Data
public class Spec {
    private Integer id;
    private Integer typeId;
    private String name;
    private Integer order;
    private Boolean searchIndex;
    private List<SpecItem> specItemList;
}