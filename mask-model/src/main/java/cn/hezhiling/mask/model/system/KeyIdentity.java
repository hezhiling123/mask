package cn.hezhiling.mask.model.system;

import lombok.Data;

import java.util.Date;

/**
 * @author hezhiling
 */
@Data
public class KeyIdentity {
    private String id;
    private String keyCode;
    private Date createTime;
    private Long codeIndex;
}