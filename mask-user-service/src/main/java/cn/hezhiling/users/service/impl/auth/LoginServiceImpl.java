package cn.hezhiling.users.service.impl.auth;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.hezhiling.core.utils.ResponseUtil;
import cn.hezhiling.mask.model.user.dto.UserInfo;
import cn.hezhiling.mask.model.user.dto.WxLoginInfo;
import cn.hezhiling.mask.model.user.po.UserPO;
import cn.hezhiling.sys.service.auth.LoginService;
import cn.hezhiling.users.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhiling
 */
@Slf4j
@RestController
@RequestMapping("/user/mask/service/login")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private WxMaService wxService;

    /**
     * 微信登录
     *
     * @param wxLoginInfo 请求内容，{ code: xxx, userInfo: xxx }
     * @return 登录结果
     **/
    @Override
    @PostMapping("loginByWeiXin")
    public Object loginByWeiXin(@RequestBody WxLoginInfo wxLoginInfo) {
        String code = wxLoginInfo.getCode();
        UserInfo userInfo = wxLoginInfo.getUserInfo();
        log.info(code);
        log.info(userInfo.toString());
        if (code == null) {
            return ResponseUtil.badArgument();
        }

        String sessionKey = null;
        String openId = null;

        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sessionKey == null || openId == null) {
            return ResponseUtil.fail();
        }

        UserPO user = userDao.getUserByOpenId(openId);
        if (user == null) {
            user = UserPO.builder()
                    .username(openId)
                    .nickname(openId)
                    .addTime(LocalDateTime.now())
                    .password(new BCryptPasswordEncoder().encode(openId))
                    .weiXinOpenid(openId)
                    .avatar("https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64")
                    .gender((byte) 0)
                    .userLevel((byte) 0)
                    .status((byte) 0)
                    .lastLoginIp("")
                    .lastLoginTime(LocalDateTime.now())
                    .sessionKey(sessionKey)
                    .build();
            userDao.addUser(user);

        } else {
            user.setLastLoginTime(LocalDateTime.now());
            user.setLastLoginIp("");
            user.setSessionKey(sessionKey);
            userDao.updateLoginMessage(user);
        }

        // token
//        String token = UserTokenManager.generateToken(user.getId());

        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", "token");
        result.put("userInfo", userInfo);
        return ResponseUtil.ok(result);
    }


//    @Override
//    @PostMapping("register")
//    public Object register(@RequestBody String body, HttpServletRequest request) {
//        String username = JacksonUtil.parseString(body, "username");
//        String password = JacksonUtil.parseString(body, "password");
//        String mobile = JacksonUtil.parseString(body, "mobile");
//        String code = JacksonUtil.parseString(body, "code");
//
//        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)
//                || StringUtils.isEmpty(code)) {
//            return ResponseUtil.badArgument();
//        }
//
//        UserPO userPo = userDao.getUserByUserName(username);
//        if (ObjectUtil.isNotNull(userPo)) {
//            throw new MaskRuntimeException(ResultStatusCode.HTTP_ERROR_500.getCode(), "该用户已被注册");
//        }
//
//        if (userDao.checkPhoneExist(mobile) != 0) {
//            throw new MaskRuntimeException(ResultStatusCode.HTTP_ERROR_500.getCode(), "手机号已被注册");
//        }
//        if (!RegexUtil.isMobileSimple(mobile)) {
//            throw new MaskRuntimeException(ResultStatusCode.HTTP_ERROR_500.getCode(), "手机号格式错误");
//        }
//        //判断验证码是否正确
////        String cacheCode = CaptchaCodeManager.getCachedCaptcha(mobile);
////        if (cacheCode == null || cacheCode.isEmpty() || !cacheCode.equals(code)) {
////            return ResponseUtil.fail(AUTH_CAPTCHA_UNMATCH, "验证码错误");
////        }
//
//        String openId = "";
//        // 如果是小程序注册，则必须非空
//        // 其他情况，可以为空
//        String wxCode = JacksonUtil.parseString(body, "wxCode");
//        // 非空，则是小程序注册
//        // 继续验证openid
//        if(!StringUtils.isEmpty(wxCode)) {
//            try {
//                WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(wxCode);
//                openId = result.getOpenid();
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new MaskRuntimeException(ResultStatusCode.HTTP_ERROR_500.getCode(), "openId获取失败");
//            }
//            UserPO user = userDao.getUserByOpenId(openId);
//
//            if (ObjectUtil.isNotNull(user)) {
//                if (!user.getUsername().equals(openId) || !user.getPassword().equals(openId)) {
//                    throw new MaskRuntimeException(ResultStatusCode.HTTP_ERROR_500.getCode(), "该openId已被绑定");
//                }
//            }
//        }
//
//        UserPO  user = UserPO.builder()
//                .username(username)
//                .nickname(username)
//                .addTime(LocalDateTime.now())
//                .password(new BCryptPasswordEncoder().encode(password))
//                .mobile(mobile)
//                .weiXinOpenid(openId)
//                .avatar("https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64")
//                .gender((byte)0)
//                .userLevel((byte)0)
//                .status((byte)0)
//                .lastLoginIp("")
//                .lastLoginTime(LocalDateTime.now())
//                .build();
//        userDao.addUser(user);
//
//        // userInfo
//        UserInfo userInfo = new UserInfo();
//        userInfo.setNickName(username);
//        userInfo.setAvatarUrl(user.getAvatar());
//
//        // token
//
//        Map<Object, Object> result = new HashMap<Object, Object>();
//        result.put("token", "token");
//        result.put("userInfo", userInfo);
//        return ResponseUtil.ok(result);
//    }
//
//    @Override
//    @PostMapping("logout")
//    public Object logout(Integer userId) {
//        if (userId == null) {
//            return ResponseUtil.unlogin();
//        }
//        return ResponseUtil.ok();
//    }
//
//    @Override
//    @GetMapping("info")
//    public Object info(Integer userId) {
//        if (userId == null) {
//            return ResponseUtil.unlogin();
//        }
//
//        UserInfo user = userDao.getUserInfoById(userId);
//        Map<Object, Object> data = new HashMap<Object, Object>();
//        data.put("nickName", user.getNickName());
//        data.put("avatar", user.getAvatarUrl());
//        data.put("gender", user.getGender());
//
//        return ResponseUtil.ok(data);
//    }

    /**
     * 通过token登录
     *
     * @param tokenStr token
     * @return {@link UserPO}
     */
    @Override
    @PostMapping("login")
    public UserPO login(String tokenStr) {
        return null;
    }

    /**
     * 通过token登录
     *
     * @param tokenStr token
     * @return {@link UserInfo}
     */
    @Override
    @PostMapping("loginByToken")
    public UserInfo loginByToken(String tokenStr) {
//        log.info(tokenStr);
//        System.out.println(tokenStr);
//        UsernamePasswordToken usernamePasswordToken = JSONObject.parseObject(tokenStr, UsernamePasswordToken.class);
//        UserInfo user = null;
//        String loginAccount;
//        String password;
//        Map<String, Object> paramMap = new HashMap<>();
//        //微信登录
//        UsernamePasswordToken sysToken = usernamePasswordToken;
//        loginAccount = sysToken.getUsername();
//        password = new String(sysToken.getPassword());
//        log.info(password);
//        paramMap.put("loginAccount", loginAccount);
//        user = userDao.getUserInfoById(1);
//        String md5Password = MD5Util.generateMD5(password, user.getPasswordRand());
//        log.info("md5Password:" + md5Password);
//        log.info("user.getPassword():" + user.getPassword());
//        //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
//        if (!md5Password.equals(user.getPassword()) && !password.equals(user.getPassword())) {
//            // 密码错误
//            throw new MaskRuntimeException(ResponseCodeConstant.USER_LOGIN_FAIL,
//                    ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
//        }
//        if (user.getStatus() == CommonConstant.USER_STATUS_NO_ACTIVATION) {
//            // 用户未激活
//            throw new MaskRuntimeException(ResponseCodeConstant.USER_LOGIN_FAIL,
//                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_ACTIVATION_MSG);
//        }
//        if (user.getStatus() == CommonConstant.USER_STATUS_FREEZE) {
//            // 用户已冻结
//            throw new MaskRuntimeException(ResponseCodeConstant.USER_LOGIN_FAIL,
//                    ResponseCodeConstant.USER_LOGIN_FAIL_FREEZEED_MSG);
//        }
//        if (user.getStatus() == CommonConstant.USER_STATUS_CANCEL) {
//            // 用户已作废
//            throw new MaskRuntimeException(ResponseCodeConstant.USER_LOGIN_FAIL,
//                    ResponseCodeConstant.USER_LOGIN_FAIL_CANCELED_MSG);
//        }
//
//        return resultUser;
        return null;
    }
}