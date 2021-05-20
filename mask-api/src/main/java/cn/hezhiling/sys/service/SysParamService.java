package cn.hezhiling.sys.service;

import cn.hezhiling.sys.model.SysParam;

/**
 * Created by VULCAN on 2019/4/11.
 */
public interface SysParamService {
    SysParam selectByCode(String code);
}
