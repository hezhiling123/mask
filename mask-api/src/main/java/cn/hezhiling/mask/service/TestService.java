package cn.hezhiling.mask.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description:
 * @author: hezhiling
 * @create: 2021/2/26 11:00
 */
@RequestMapping("/test")
public interface TestService {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	Map<String, Object> test(@RequestParam("userId") String userId);
}
