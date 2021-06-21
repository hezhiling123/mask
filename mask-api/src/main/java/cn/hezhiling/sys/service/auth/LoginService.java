package cn.hezhiling.sys.service.auth;

import cn.hezhiling.mask.model.user.dto.UserInfo;
import cn.hezhiling.mask.model.user.dto.WxLoginInfo;
import cn.hezhiling.mask.model.user.po.UserPO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hezhiling
 */
@RequestMapping("/user/mask/service/login")
public interface LoginService {

    /**
     * 微信登录
     *
     * @param wxLoginInfo 请求内容，{ code: xxx, userInfo: xxx }
     * @return 登录结果
     */
    @PostMapping("loginByWeiXin")
    Object loginByWeiXin(@RequestBody WxLoginInfo wxLoginInfo);

    /**
     * 通过token登录
     *
     * @param tokenStr token
     * @return {@link UserPO}
     */
    @PostMapping("login")
    UserPO login(String tokenStr);

    /**
     * 通过token登录
     *
     * @param tokenStr token
     * @return {@link UserInfo}
     */
    @PostMapping("loginByToken")
    UserInfo loginByToken(String tokenStr);
//
//    /**
//     * 注册
//     *
//     * @param body  body
//     * @param request request
//     * @return
//     */
//    Object register(String body, HttpServletRequest request);
//
//    /**
//     * 登出
//     *
//     * @param userId    用户id
//     * @return  登出结果
//     */
//    Object logout(Integer userId);
//
//    /**
//     * 获取用户信息
//     *
//     * @param userId    用户id
//     * @return  用户信息
//     */
//    Object info(Integer userId);
}
