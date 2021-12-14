package cn.hezhiling.mask.label.label.bo.impl;

import cn.hezhiling.core.exception.MaskRuntimeException;
import cn.hezhiling.core.exception.ResultStatusCode;
import cn.hezhiling.mask.label.label.bo.LabelBO;
import cn.hezhiling.mask.label.mapper.LabelMapper;
import cn.hezhiling.mask.model.label.entity.LabelEntity;
import cn.hezhiling.mask.model.label.vo.LabelVO;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hezhiling
 * @version 1.0
 * @date 2021-10-13 20:59:10
 */
@Service
public class LabelBOImpl implements LabelBO {

    @Autowired
    private LabelMapper labelMapper;
    /**
     * 列出我所有的标签
     *
     * @param ownerId 拥有者id
     * @return 该拥有者所有的标签
     */
    @Override
    public List<LabelVO> listMyLabel(String ownerId) {
        if (StrUtil.isEmpty(ownerId)) {
            throw new MaskRuntimeException(ResultStatusCode.BAD_REQUEST, "ownerId不能为空");
        }
        return labelMapper.listLabelByOwnerId(ownerId);
    }

    /**
     * 增加一个标签
     *
     * @param labelEntity 标签
     */
    @Override
    public void addLabel(LabelEntity labelEntity) {
        if (ObjectUtil.isNull(labelEntity)) {
            throw new MaskRuntimeException(ResultStatusCode.BAD_REQUEST, "ownerId不能为空");
        }
        labelMapper.insertOne(labelEntity);
    }
}
