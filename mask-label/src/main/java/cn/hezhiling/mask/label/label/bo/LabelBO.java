package cn.hezhiling.mask.label.label.bo;

import cn.hezhiling.mask.model.label.entity.LabelEntity;
import cn.hezhiling.mask.model.label.vo.LabelVO;

import java.util.List;

public interface LabelBO {

    /**
     * 列出我所有的标签
     *
     * @param ownerId 拥有者id
     * @return 该拥有者所有的标签
     */
    List<LabelVO> listMyLabel(String ownerId);

    /**
     * 增加一个标签
     *
     * @param labelEntity 标签
     */
    void addLabel(LabelEntity labelEntity);
}
