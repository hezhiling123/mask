package cn.hezhiling.mask.label.service.impl;

import cn.hezhiling.mask.label.mapper.LabelMapper;
import cn.hezhiling.mask.service.label.LabelService;
import cn.hezhiling.mask.vo.label.LabelVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hezhiling
 * @date 2021/6/24 11:05
 * @since V1.0
 */
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<LabelVO> listAllMyLabel(String userId) {
        return labelMapper.listAllMyLabel(userId);
    }
}
