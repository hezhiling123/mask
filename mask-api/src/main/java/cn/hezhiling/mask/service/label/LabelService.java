package cn.hezhiling.mask.service.label;

import cn.hezhiling.mask.vo.label.LabelVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author hezhiling
 * @date 2021/6/24 11:06
 * @since V1.0
 */
@RequestMapping("/product/mask/service/label")
public interface LabelService {
    @RequestMapping(value = "/listAllMyLabel", method = RequestMethod.POST)
    List<LabelVO> listAllMyLabel(String userId);
}
