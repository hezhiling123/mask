package cn.hezhiling.users.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "wx")
public class WxMaProperties {
    private String appId;
    private String appSecret;
    private String wxRedirectUri;
//    @Value("${wx.redirect-uri}")
//    private String token;
//    @Value("${wx.aesKey")
//    private String aesKey;
//    @Value("${wx.msgDataFormat")
//    private String msgDataFormat;
}
