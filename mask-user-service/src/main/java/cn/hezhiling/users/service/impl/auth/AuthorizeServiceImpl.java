package cn.hezhiling.users.service.impl.auth;

import cn.hezhiling.mask.model.system.Oauth2Client;
import cn.hezhiling.sys.service.auth.AuthorizeService;
import cn.hezhiling.users.dao.Oauth2ClientMapper;
import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 权限管理
 *
 * @author Jack
 * @date 2020/9/8
 */
@RestController
@ApiDoc
@RequestMapping("/user/sys/service/authorize")
public class AuthorizeServiceImpl implements AuthorizeService {

    @Resource
    private Oauth2ClientMapper oauth2ClientMapper;

    /**
     * 验证oauth2.0客户端是否存在
     *
     * @param clientId
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/checkClientId", method = RequestMethod.POST)
    @Override
    public boolean checkClientId(String clientId) {
        Oauth2Client oauth2Client = oauth2ClientMapper.findByClientId(clientId);
        return oauth2ClientMapper.findByClientId(clientId) != null;
    }

    /**
     * 验证oauth2.0密码是否存在
     *
     * @param clientSecret
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/checkClientSecret", method = RequestMethod.POST)
    @Override
    public boolean checkClientSecret(String clientSecret) {
        return oauth2ClientMapper.findBySecret(clientSecret) != null;
    }

    /**
     * 获取过期时间
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getExpireIn")
    @Override
    public long getExpireIn() {
        return 3600L;
    }

    /**
     * 根据客户端id获取鉴权客户端信息
     *
     * @param clientId
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/findClientByClientId", method = RequestMethod.POST)
    @Override
    public Oauth2Client findClientByClientId(String clientId) {
        return oauth2ClientMapper.findByClientId(clientId);
    }

    /**
     * 获取所有的鉴权客户端信息
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getClientMap")
    @Override
    public Map<String, Oauth2Client> getClientMap() {
        return oauth2ClientMapper.getAll4Map();
    }
}
