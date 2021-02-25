package cn.hezhiling.users.service.impl;


import cn.hezhiling.core.exception.BusinessException;
import cn.hezhiling.core.utils.CommonConstant;
import cn.hezhiling.core.utils.MD5Util;
import cn.hezhiling.core.utils.response.ResponseCodeConstant;
import cn.hezhiling.sys.model.SysUser;
import cn.hezhiling.sys.security.OpenApiToken;
import cn.hezhiling.sys.service.ILoginService;
import cn.hezhiling.users.dao.SysUserMapper;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录模块
 *
 * @author Jack
 */
@Slf4j
@RestController
@RequestMapping("/user/sys/service/ILoginService")
public class LoginServiceImpl implements ILoginService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Value("${dfs.url}")
    private String dfsUrl;

    /**
     * 用户登录
     *
     * @param token
     * @return
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/loginByToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Map<String, Object> login(@RequestBody AuthenticationToken token) {
        SysUser user = null;
        String loginAccount;
        String password;
        Map<String, Object> paramMap = new HashMap<>();
        //微信登录
        if (token instanceof OpenApiToken) {
            OpenApiToken sysToken = (OpenApiToken) token;
            user = sysUserMapper.selectByPrimaryKey(sysToken.getUserId());
            paramMap.put("loginAccount", user.getEmail());
        } else if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken sysToken = (UsernamePasswordToken) token;
            loginAccount = sysToken.getUsername();
            password = new String(sysToken.getPassword());

            paramMap.put("loginAccount", loginAccount);
            user = sysUserMapper.getUserByAccount(paramMap);
            String md5Password = MD5Util.generateMD5(password, user.getPasswordRand());

            //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
            if (!md5Password.equals(user.getPassword()) && !password.equals(user.getPassword())) {
                // 密码错误
                throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                        ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
            }
        }
        if (user == null) {
            // 用户不存在
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_USER_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_NO_ACTIVATION) {
            // 用户未激活
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_ACTIVATION_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_FREEZE) {
            // 用户已冻结
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_FREEZEED_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_CANCEL) {
            // 用户已作废
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_CANCELED_MSG);
        }

        Map<String, Object> resultUser = sysUserMapper.getUserByAccountWithLogin(paramMap);
        Object icon = resultUser.get("icon");
        if (icon != null) {
            icon = getResAccessUrl(icon.toString());
            resultUser.put("icon", icon);
        }
        resultUser.put("user", user);
        return resultUser;
    }

    /**
     * 用户登录
     *
     * @param token
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/loginByTokenStr", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Map<String, Object> loginByStrToken(@RequestParam("token") String token) {
        log.info(token);
        System.out.println(token);
        UsernamePasswordToken usernamePasswordToken = JSONObject.parseObject(token, UsernamePasswordToken.class);
        SysUser user = null;
        String loginAccount;
        String password;
        Map<String, Object> paramMap = new HashMap<>();
        //微信登录
        UsernamePasswordToken sysToken = usernamePasswordToken;
        loginAccount = sysToken.getUsername();
        password = new String(sysToken.getPassword());
        log.info(password);
        paramMap.put("loginAccount", loginAccount);
        user = sysUserMapper.getUserByAccount(paramMap);
        String md5Password = MD5Util.generateMD5(password, user.getPasswordRand());
        log.info("md5Password:" + md5Password);
        log.info("user.getPassword():" + user.getPassword());
        //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
        if (!md5Password.equals(user.getPassword()) && !password.equals(user.getPassword())) {
            // 密码错误
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
        }
        if (user == null) {
            // 用户不存在
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_USER_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_NO_ACTIVATION) {
            // 用户未激活
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_ACTIVATION_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_FREEZE) {
            // 用户已冻结
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_FREEZEED_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_CANCEL) {
            // 用户已作废
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_CANCELED_MSG);
        }

        Map<String, Object> resultUser = sysUserMapper.getUserByAccountWithLogin(paramMap);
        Object icon = resultUser.get("icon");
        if (icon != null) {
            icon = getResAccessUrl(icon.toString());
            resultUser.put("icon", icon);
        }
        resultUser.put("user", user);
        return resultUser;
    }

    /**
     * 根据账号密码登录
     *
     * @param loginAccount
     * @param password
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/loginByAccount", method = RequestMethod.POST)
    @Override
    public Map<String, Object> login(String loginAccount, String password) {
        SysUser user = null;

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("loginAccount", loginAccount);
//		paramMap.put("sysCode",sysCode);
        user = sysUserMapper.getUserByAccount(paramMap);

        if (user == null) {
            // 用户不存在
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_USER_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_NO_ACTIVATION) {
            // 用户未激活
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_ACTIVATION_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_FREEZE) {
            // 用户已冻结
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_FREEZEED_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_CANCEL) {
            // 用户已作废
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_CANCELED_MSG);
        }
        String md5Password = MD5Util.generateMD5(password, user.getPasswordRand());

        //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
        if (!md5Password.equals(user.getPassword()) && !password.equals(user.getPassword())) {
            // 密码错误
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
        }

        Map<String, Object> resultUser = sysUserMapper.getUserByAccountWithLogin(paramMap);
        Object icon = resultUser.get("icon");
        if (icon != null) {
            icon = getResAccessUrl(icon.toString());
            resultUser.put("icon", icon);
        }
        resultUser.put("user", user);
        return resultUser;
    }

    /**
     * 账号登录
     *
     * @param loginAccount
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @Override
    public SysUser login(String loginAccount) {
        SysUser user = null;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("loginAccount", loginAccount);
        user = sysUserMapper.getUserByAccount(paramMap);
        //如果是微信登录，传进来的loginAccount将会是userId，所以再查一次
        if (user == null) {
            user = sysUserMapper.selectByPrimaryKey(loginAccount);
        }
        if (user == null) {
            // 用户不存在
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_USER_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_NO_ACTIVATION) {
            // 用户未激活
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_NO_ACTIVATION_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_FREEZE) {
            // 用户已冻结
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_FREEZEED_MSG);
        }
        if (user.getStatus() == CommonConstant.USER_STATUS_CANCEL) {
            // 用户已作废
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_CANCELED_MSG);
        }
        return user;
    }

    private String getResAccessUrl(String storePath) {
        String fileUrl = dfsUrl + storePath;
        return fileUrl;
    }
}
