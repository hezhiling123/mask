package cn.hezhiling.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author hezhiling
 */
@Component
public class Config {

    @Value("${dfs.url}")
    private String dfsUrl;

    @Value("${wx.appId}")
    private String wxAppId;

    @Value("${wx.redirect_uri}")
    private String wxRedirectUri;


    public String getDfsUrl() {
        return dfsUrl;
    }

    public void setDfsUrl(String dfsUrl) {
        this.dfsUrl = dfsUrl;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxRedirectUri() {
        return wxRedirectUri;
    }

    public void setWxRedirectUri(String wxRedirectUri) {
        this.wxRedirectUri = wxRedirectUri;
    }
}
