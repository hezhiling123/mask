package cn.hezhiling.mask.service.label;

import cn.hezhiling.mask.model.label.entity.LabelEntity;
import cn.hezhiling.mask.model.label.vo.LabelVO;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hezhiling
 * @date 2021/6/24 11:06
 * @since V1.0
 */
@RequestMapping("/mask/service/label")
public interface LabelService {
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
