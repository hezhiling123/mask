package cn.hezhiling.mask.model.system;

import lombok.Data;

@Data
public class Oauth2Client {
    private Integer id;
    private String clientName;
    private String clientId;
    private String clientSecret;
    private String logoutUrl;
}