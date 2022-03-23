package cn.hezhiling.mask.model.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class Oauth2Client implements Serializable {
    private Integer id;
    private String clientName;
    private String clientId;
    private String clientSecret;
    private String logoutUrl;
}