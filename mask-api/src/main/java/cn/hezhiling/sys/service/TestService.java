package cn.hezhiling.sys.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description:
 * @author: hezhiling
 * @create: 2021/2/26 11:00
 */
public interface TestService {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	Map<String, Object> test(@RequestParam("userId") String userId);

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	Map<String, Object> test1(@RequestParam("userId") String userId);
}
