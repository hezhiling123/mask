package cn.hezhiling.mask.model.system;

import lombok.Data;

@Data
public class MessageLog {
    private Long messageId;

    private String message;

    private Integer tryCount;

    private Integer status;

    private Long delayTime;

    private Long createTime;

    private Long updateTime;
}
