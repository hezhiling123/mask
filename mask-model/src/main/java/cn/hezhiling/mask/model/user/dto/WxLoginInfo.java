package cn.hezhiling.mask.model.user.dto;

import lombok.Data;

/**
 * @author hezhiling
 */
@Data
public class WxLoginInfo {
    private String code;
    private UserInfo userInfo;
}
