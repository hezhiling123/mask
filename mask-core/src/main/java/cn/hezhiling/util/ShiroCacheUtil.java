package cn.hezhiling.util;

import cn.hezhiling.mask.constant.RedisCacheNames;
import cn.hezhiling.mask.constant.SsoConstants;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Ray
 * @date 2018/3/29.
 */
public class ShiroCacheUtil {

    private Cache<String, Object> cache;
    @Resource
    private CacheManager cacheManager;


    @PostConstruct
    public void init(){
        this.cache = cacheManager.getCache(RedisCacheNames.CODE_CACHE);
    }


    public void addAuthCode(String authCode, String username) {
        cache.put(authCode, username);
    }


    public void addAccessToken(String accessToken, String username) {
        cache.put(accessToken, username);
    }


    public void removeAccessToken(String accessToken) {
        cache.remove(accessToken);
    }

    /**
     * 获取到用户名之后code就不用了，扔掉
     * @param authCode
     * @return
     */
    public String getUsernameByAuthCode(String authCode) {
        String userName = (String)cache.get(authCode);
        cache.remove(authCode);
        return userName;
    }


    public String getUsernameByAccessToken(String accessToken) {
        return (String)cache.get(accessToken);
    }

    /**
     * 检查code是否合法
     * @param authCode
     * @return
     */
    public boolean checkAuthCode(String authCode) {
        return cache.get(authCode) != null;
    }


    public boolean checkAccessToken(String accessToken) {
        return cache.get(accessToken) != null;
    }


    public void put(String key, String value){
        cache.put(key, value);
    }

    public void removeKey(String key){
        cache.remove(key);
    }

    public void putUser(Integer userId, String value){
        cache.put(SsoConstants.SSO_USERS + ":" + userId, value);
    }

    public String getUser(Integer userId){
        return (String )cache.get(SsoConstants.SSO_USERS + ":" + userId);
    }

    public void removeUser(Integer userId){
        cache.remove(SsoConstants.SSO_USERS + ":" + userId);
    }

    public long getExpireIn() {
        return 3600L;
    }
}
