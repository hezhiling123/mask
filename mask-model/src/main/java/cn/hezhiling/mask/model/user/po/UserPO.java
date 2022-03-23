package cn.hezhiling.mask.model.user.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author hezhiling
 */
@Data
@Builder
@AllArgsConstructor
public class UserPO {
    private Integer id;
    private String username;
    private String password;
    private Byte gender;
    private LocalDate birthday;
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private Byte userLevel;
    private String nickname;
    private String mobile;
    private String avatar;
    private String weiXinOpenid;
    private String sessionKey;
    private Byte status;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}