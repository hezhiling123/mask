package cn.hezhiling.users.dao;

import cn.hezhiling.sys.model.KeyIdentity;

public interface KeyIdentityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_identity
     *
     * @mbggenerated Tue Aug 22 16:22:04 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_identity
     *
     * @mbggenerated Tue Aug 22 16:22:04 CST 2017
     */
    int insert(KeyIdentity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_identity
     *
     * @mbggenerated Tue Aug 22 16:22:04 CST 2017
     */
    int insertSelective(KeyIdentity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_identity
     *
     * @mbggenerated Tue Aug 22 16:22:04 CST 2017
     */
    KeyIdentity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_identity
     *
     * @mbggenerated Tue Aug 22 16:22:04 CST 2017
     */
    int updateByPrimaryKeySelective(KeyIdentity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_identity
     *
     * @mbggenerated Tue Aug 22 16:22:04 CST 2017
     */
    int updateByPrimaryKey(KeyIdentity record);

    KeyIdentity selectByKeyCode(String key);
}