package cn.hezhiling.sys.controller;

import cn.hezhiling.config.Config;
import cn.hezhiling.core.utils.response.HttpResponseBody;
import cn.hezhiling.sys.controller.BaseController;
import cn.hezhiling.util.ShiroCacheUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统管理
 * @author Jack
 * @date 2017/10/16
 */
@RestController
@RequestMapping("/api/sys")
public class SystemController extends BaseController {

    @Resource
    private Config config;
    @Resource
    private ShiroCacheUtil shiroCacheUtil;

    /**
     * 获取工程配置信息
     *
     * @return  {@link Config}
     */
    @GetMapping(value = "/config")
    public HttpResponseBody<Config> getConfig(){
        return HttpResponseBody.successResponse("ok", config);
    }

    /**
     * 用户登出
     *
     * @param request   request
     * @param response  response
     * @return  body
     */
    @RequestMapping(value = "logout", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpResponseBody logout(HttpServletRequest request, HttpServletResponse response){
        if(this.getSessionUser() != null) {
            shiroCacheUtil.removeUser(this.getSessionUser().getId());
        }
        SecurityUtils.getSubject().logout();

        Cookie cookie = new Cookie("JSESSIONID","");
        response.addCookie(cookie);
        return HttpResponseBody.successResponse("登出成功");
    }

}
