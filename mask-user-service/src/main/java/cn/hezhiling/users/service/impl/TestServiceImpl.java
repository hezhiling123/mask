package cn.hezhiling.users.service.impl;

import cn.hezhiling.mask.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: hezhiling
 * @create: 2021/2/26 11:03
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestServiceImpl implements TestService {
	@Override
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Map<String, Object> test(String userId) {
		Map<String, Object> result = new HashMap<>(1);
		log.info(userId);
		result.put("userId", userId);
		return result;
	}
}
