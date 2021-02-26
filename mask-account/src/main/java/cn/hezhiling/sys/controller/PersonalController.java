package cn.hezhiling.sys.controller;

import cn.hezhiling.core.utils.response.HttpResponseBody;
import cn.hezhiling.sys.model.SysUser;
import cn.hezhiling.sys.service.ILoginService;
import cn.hezhiling.sys.service.IUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/api/personal/")
public class PersonalController extends BaseController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ILoginService iLoginService;

    /**
     * 获取用户详细信息
    * @author Jack
    * @date 2020/9/9
    * @throws Exception
    * @return
    * @version
    */
    @GetMapping("getPersonalInfo")
    public HttpResponseBody<Map<String, Object>> getPersonInfo() {
        SysUser sysUser = iUserService.selectByPrimaryKey(getSessionUserId());
        if (sysUser == null) {
            return HttpResponseBody.failResponse("请重新登录");
        }
        sysUser.setPassword(null);
        sysUser.setPasswordRand(null);
        Map<String, Object> result = new HashMap<>();
        result.put("userInfo", sysUser);
        return HttpResponseBody.successResponse("查询成功", result);
    }

    /**
     * 修改用户、部门、角色信息
    * @param user
     * @param departIds
     * @param roleIds
    * @author Jack
    * @date 2020/9/9
    * @throws Exception
    * @return
    * @version
    */
    @PostMapping("updatePersonalInfo")
    public HttpResponseBody updatePersonalInfo(SysUser user, @RequestParam(name = "departIds", required = false, defaultValue = "") String[] departIds,
                                               @RequestParam(name = "roleIds", required = false, defaultValue = "") String[] roleIds) {
        iUserService.update(user, JSONObject.toJSONString(departIds), JSONObject.toJSONString(roleIds));
        return HttpResponseBody.successResponse("修改成功");
    }

    /**
     * 修改用户信息
    * @param user
    * @author Jack
    * @date 2020/9/9
    * @throws Exception
    * @return
    * @version
    */
    @PostMapping("updateUserInfo")
    public HttpResponseBody updateUserInfo(SysUser user) {
        user.setId(getSessionUserId());
        iUserService.updateUserInfo(user);
        return HttpResponseBody.successResponse("修改成功");
    }


}
