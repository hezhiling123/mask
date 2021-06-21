package cn.hezhiling.sys.service.user;

import cn.hezhiling.mask.model.user.dto.UserInfo;
import cn.hezhiling.mask.model.user.po.UserPO;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hezhiling
 */
@RequestMapping("/user")
public interface UserService {
    /**
     * 根据用户名称获取用户信息
     *
     * @param userName  用户名称
     * @return  {@link UserInfo}
     */
    UserInfo getUserInfoById(String userName);

    /**
     * 添加用户
     *
     * @param user  {@link UserPO}
     */
    void addUser(UserPO user);
}
