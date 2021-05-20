package cn.hezhiling.mask.model.user;

import lombok.Data;

/**
 * @author hezhiling
 */
@Data
public class UserVO {
    private Integer id;
    private String username;
    private Byte gender;
    private Byte userLevel;
    private String nickname;
    private String mobile;
    private String avatar;
    private String weiXinOpenid;
    private String sessionKey;
    private Byte status;
    private Boolean deleted;
}
