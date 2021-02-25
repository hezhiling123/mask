package cn.hezhiling.sys.service;

import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/user/sys/service/ILoginService")
public interface ILoginService {
    @RequestMapping(value = "/loginByToken", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> login(@RequestBody AuthenticationToken token);

    @RequestMapping(value = "/loginByTokenStr", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> loginByStrToken(@RequestParam("token") String token);

    @RequestMapping(value = "/loginByAccount", method = RequestMethod.POST)
    Map<String, Object> login(@RequestParam("loginAccount") String loginAccount, @RequestParam("password") String password);
}
