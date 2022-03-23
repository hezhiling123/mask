package cn.hezhiling.users.dao;

import cn.hezhiling.mask.model.user.dto.UserInfo;
import cn.hezhiling.mask.model.user.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hezhiling
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名称获取用户信息
     *
     * @param userName 用户名称
     * @return {@link UserPO}
     */
    UserPO getUserByUserName(@Param("userName") String userName);

    /**
     * 根据用户id获取用户信息
     *
     * @param userId 用户id
     * @return {@link UserInfo}
     */
    UserInfo getUserInfoById(@Param("id") Integer userId);

    /**
     * 新增用户
     *
     * @param userPo {@link UserPO}
     */
    void addUser(@Param("userPo") UserPO userPo);

    /**
     * 通过手机号获取用户信息
     *
     * @param phone 手机号
     * @return {@link UserInfo}
     */
    UserInfo getUserInfoByPhone(@Param("phone") String phone);

    /**
     * 根据开放id查询用户信息
     *
     * @param openId 微信开放id
     * @return {@link }
     */
    UserPO getUserByOpenId(@Param("openId") String openId);

    /**
     * 更新用户登录信息
     *
     * @param userPo {#{@link UserPO}}
     */
    void updateLoginMessage(@Param("user") UserPO userPo);

    /**
     * 检查手机号是否被注册
     *
     * @param phone 手机号
     * @return 0否1是
     */
    Integer checkPhoneExist(@Param("phone") String phone);
}
