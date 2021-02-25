package cn.hezhiling.users.dao;

import cn.hezhiling.sys.model.SysUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Fri Jul 08 11:27:36 CST 2016
	 */
	int deleteByPrimaryKey(String id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Fri Jul 08 11:27:36 CST 2016
	 */
	int insert(SysUser record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Fri Jul 08 11:27:36 CST 2016
	 */
	int insertSelective(SysUser record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Fri Jul 08 11:27:36 CST 2016
	 */
	SysUser selectByPrimaryKey(String id);

	SysUser selectByEmail(String email);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Fri Jul 08 11:27:36 CST 2016
	 */
	int updateByPrimaryKeySelective(SysUser record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Fri Jul 08 11:27:36 CST 2016
	 */
	int updateByPrimaryKey(SysUser record);
	/**
     * 根据loginAccount去查找帐户信息
	 * @param parameterMap
	 *       loginAccount 帐户名称
	 *       sysCode 前后台代码
     * @return
     */
    SysUser getUserByAccount(Map<String, Object> parameterMap);

	Map<String,Object> getUserByAccountWithLogin(Map<String, Object> parameterMap);

   int checkUniqueness(@Param("cancelStatus") String cancelStatus, @Param("accountCode") String accountCode);

	String selectInIds(List<String> userList);

    int getUserByMobile(String mobileNum);

	void updateUserInfo(@Param("captcha") String captcha, @Param("captchaTime") Date captchaTime, @Param("mobileNum") String mobileNum, @Param("sysCode") String sysCode);

    SysUser getByMobileAndCaptcha(@Param("mobileNum") String mobileNum, @Param("sysCode") String sysCode);

    int isExistByOrgcode(String orgCode);

	int checkMobileAndEmail(@Param("status") int status, @Param("email") String email, @Param("mobile") String mobile, @Param("sysCode") String sysCode, @Param("userId") String userId);

    void batchDeleteUsers(List<String> ids);

	List<SysUser> queryByPage(@Param("loginAccount") String loginAccount, @Param("identityCode") String identityCode, PageBounds pageBounds);

	List<SysUser> queryByPage(@Param("loginAccount") String loginAccount);

	List<SysUser> queryList();

	SysUser getUserByIdentityCode(String identityCode);

	List<Map<String,Object>>  queryTimeExtraPage(@Param("loginAccount") String loginAccount, PageBounds pageBounds);

	List<SysUser> queryContacts(@Param("realName") String realName, PageBounds pageBounds);

	List<SysUser> selectAllEmail(@Param("userId") String userId);

	List<String> selectByRoleCode(@Param("roleCode") String roleCode);
	/**
	 * 通过角色编码 查询帐户信息
	 * @param roleCode  角色编码
	 */
	List<Map<String,Object>> selectUserByRoleCode(@Param("roleCode") String roleCode);
}