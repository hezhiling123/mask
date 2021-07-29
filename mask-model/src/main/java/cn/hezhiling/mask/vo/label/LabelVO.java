package cn.hezhiling.mask.vo.label;

import lombok.Data;

import java.util.Date;

@Data
public class LabelVO {
    private String labelId;
    private String labelName;
    private String labelCategoryId;
    private String labelCategoryName;
    private Date createTime;
    private Date openTime;
    private Date closeTime;
    private boolean isOpen;
}
