package cn.hezhiling.mask.service.impl;

import cn.hezhiling.mask.dao.SysParamMapper;
import cn.hezhiling.sys.model.SysParam;
import cn.hezhiling.sys.service.SysParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysParamServiceImpl implements SysParamService {

    @Resource
    private SysParamMapper sysParamMapper;

    @Override
    public SysParam selectByCode(String code) {
        return sysParamMapper.selectByCode(code);
    }
}
