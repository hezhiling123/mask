package cn.hezhiling.mask.label.service.impl;

import cn.hezhiling.mask.label.mapper.LabelMapper;
import cn.hezhiling.mask.model.label.entity.LabelEntity;
import cn.hezhiling.mask.model.label.vo.LabelListVO;
import cn.hezhiling.mask.model.label.vo.LabelVO;
import cn.hezhiling.mask.service.label.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hezhiling
 * @date 2021/6/24 11:05
 * @since V1.0
 */
@RestController
@RequestMapping("/mask/service/label")
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelMapper labelMapper;

	/**
	 * 列出我所有的标签
	 *
	 * @param ownerId 拥有者id
	 * @return 该拥有者所有的标签
	 */
	@RequestMapping(value = "/listMyLabel", method = RequestMethod.POST)
	@Override
	public List<LabelVO> listMyLabel(String ownerId) {
		return labelMapper.listLabelByOwnerId(ownerId);
	}

	/**
	 * 增加一个标签
	 *
	 * @param labelEntity 标签
	 */
	@Override
	public void addLabel(LabelEntity labelEntity) {
		labelMapper.insertOne(labelEntity);
	}

}
