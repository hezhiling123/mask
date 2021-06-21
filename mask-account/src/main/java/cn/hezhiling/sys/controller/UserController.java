package cn.hezhiling.sys.controller;

import cn.hezhiling.core.utils.response.HttpResponseBody;
import cn.hezhiling.mask.model.user.dto.UserInfo;
import cn.hezhiling.mask.model.user.po.UserPO;
import cn.hezhiling.sys.service.user.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户管理
 *
 * @author Jack
 */
@RestController
@RequestMapping("/api/user/")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param user  {@link UserPO}
     * @return  body
     */
    @PostMapping("addUser")
    public HttpResponseBody addUser(UserPO user) {
        userService.addUser(user);
        return HttpResponseBody.successResponse("新增成功");
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId    用户id
     * @return  body
     */
    @RequestMapping(value = "getUserById", method = {RequestMethod.GET, RequestMethod.POST})
    public HttpResponseBody<UserInfo> getUserById(String userId) {
        UserInfo user = userService.getUserInfoById(userId);
        return HttpResponseBody.successResponse("查询成功", user);
    }

    @GetMapping("getUserInfo")
    public HttpResponseBody getUserInfo() {
        logger.info("----------getUserInfo:----------");
        String sessionUserId = getSessionUserId();
        logger.info("--------sessionUserId:" + sessionUserId);
        UserInfo userInfo = userService.getUserInfoById(sessionUserId);
        logger.info("----------sysUser:" + JSONObject.toJSONString(userInfo));
        if (userInfo == null) {
            return HttpResponseBody.failResponse("请重新登录");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("userInfo", userInfo);
        return HttpResponseBody.successResponse("查询成功", result);
    }

}
