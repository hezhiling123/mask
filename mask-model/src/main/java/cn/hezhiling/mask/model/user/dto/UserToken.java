package cn.hezhiling.mask.model.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hezhiling
 */
@Data
public class UserToken {
    private Integer userId;
    private String token;
    private String sessionKey;
    private LocalDateTime expireTime;
    private LocalDateTime updateTime;
}
