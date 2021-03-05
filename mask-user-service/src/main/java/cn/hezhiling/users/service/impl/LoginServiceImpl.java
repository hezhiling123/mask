package cn.hezhiling.users.service.impl;


import cn.hezhiling.core.exception.BusinessException;
import cn.hezhiling.core.utils.CommonConstant;
import cn.hezhiling.core.utils.MD5Util;
import cn.hezhiling.core.utils.response.ResponseCodeConstant;
import cn.hezhiling.sys.model.MenuModel;
import cn.hezhiling.sys.model.SysUser;
import cn.hezhiling.sys.security.OpenApiToken;
import cn.hezhiling.sys.service.LoginService;
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
import java.util.List;
import java.util.Map;

/**
 * 用户登录模块
 *
 * @author Jack
 */
@Slf4j
@RestController
@RequestMapping("/user/sys/service/loginService")
public class LoginServiceImpl implements LoginService {
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
    public Map<String, Object> loginByToken(@RequestBody AuthenticationToken token) {
        SysUser user = null;
        Map<String, Object> paramMap = new HashMap<>();
        //微信登录
        if (token instanceof OpenApiToken) {
            OpenApiToken sysToken = (OpenApiToken) token;
            user = sysUserMapper.selectByPrimaryKey(sysToken.getUserId());
            paramMap.put("loginAccount", user.getEmail());
        } else if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken sysToken = (UsernamePasswordToken) token;
            String password = new String(sysToken.getPassword());
            paramMap.put("loginAccount", sysToken.getUsername());
            user = sysUserMapper.getUserByAccount(paramMap);
            //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
            if (!MD5Util.generateMD5(password, user.getPasswordRand()).equals(user.getPassword()) && !password.equals(user.getPassword())) {
                // 密码错误
                throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                        ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
            }
        }
        checkUserStatus(user);
        return getUserHeadIcon(user, paramMap);
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
        UsernamePasswordToken sysToken = JSONObject.parseObject(token, UsernamePasswordToken.class);
        Map<String, Object> paramMap = new HashMap<>();
        //微信登录
        String password = new String(sysToken.getPassword());
        paramMap.put("loginAccount", sysToken.getUsername());
        SysUser user = sysUserMapper.getUserByAccount(paramMap);
        //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
        if (!MD5Util.generateMD5(password, user.getPasswordRand()).equals(user.getPassword())
                && !password.equals(user.getPassword())) {
            // 密码错误
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
        }
        checkUserStatus(user);
        return getUserHeadIcon(user, paramMap);
    }

    private Map<String, Object> getUserHeadIcon(SysUser user, String loginAccount) {
        Map<String, Object> resultUser = sysUserMapper.getUserByAccountWithLogin(loginAccount);
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

        checkUserStatus(user);
        String md5Password = MD5Util.generateMD5(password, user.getPasswordRand());

        //!password.equals(user.getPassword()) 是为了自动登陆取不到用户的真实密码使用
        if (!md5Password.equals(user.getPassword()) && !password.equals(user.getPassword())) {
            // 密码错误
            throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
                    ResponseCodeConstant.USER_LOGIN_FAIL_PASSWORD_FAIL_MSG);
        }

        return getUserHeadIcon(user, paramMap);
    }

    @Override
    public List<MenuModel> queryMenus(String userId, String parentId) {
        return null;
    }

    /**
     * 查询权限
     *
     * @param user
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/queryPermissionList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<MenuModel> queryPermissionList(@RequestBody SysUser user) {
        return null;
    }

    /**
     * 查询权限
     *
     * @param userStr
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/queryPermissionListStr", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<MenuModel> queryPermissionList(String userStr) {
        return null;
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
    @Override
    public SysUser login(String loginAccount) {
        SysUser user = null;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("loginAccount", loginAccount);
        user = sysUserMapper.getUserByAccount(paramMap);
        //如果是微信登录，传进来的loginAccount将会是userId，所以再查一次
        if (user == null) {
            user = sysUserMapper.selectByPrimaryKey(loginAccount);
        }
        checkUserStatus(user);
        return user;
    }

    private void checkUserStatus(SysUser user) {
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
    }

    private String getResAccessUrl(String storePath) {
        String fileUrl = dfsUrl + storePath;
        return fileUrl;
    }
}
