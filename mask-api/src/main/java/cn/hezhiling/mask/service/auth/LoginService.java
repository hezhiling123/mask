package cn.hezhiling.mask.service.auth;

import cn.hezhiling.mask.model.user.dto.UserInfo;
import cn.hezhiling.mask.model.user.po.UserPO;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hezhiling
 */
@RequestMapping("/login")
public interface LoginService {
    /**
     * 通过token登录
     *
     * @param tokenStr  token
     * @return  {@link UserPO}
     */
    UserPO login(String tokenStr);

    /**
     * 通过token登录
     *
     * @param tokenStr  token
     * @return  {@link UserInfo}
     */
    UserInfo loginByToken(String tokenStr);
}
