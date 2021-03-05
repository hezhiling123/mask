package cn.hezhiling.sys.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by admin on 2017/8/16.
 */
public class OpenApiToken extends UsernamePasswordToken {

    public static String password = "12346578";

    public String getPassWrod() {
        return password;
    }

    private String userId;

    public OpenApiToken(String userId, boolean rememberMe) {
        super(userId, password, rememberMe);
        super.setRememberMe(rememberMe);
        this.userId = userId;
        this.setUsername(userId);
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
