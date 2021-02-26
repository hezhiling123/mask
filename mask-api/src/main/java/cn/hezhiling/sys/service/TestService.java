package cn.hezhiling.sys.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description:
 * @author: hezhiling
 * @create: 2021/2/26 11:00
 */
@RequestMapping("/user/sys/service/TestService")
public interface TestService {
	@RequestMapping(value = "/test", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	Map<String, Object> test(@RequestParam("userId") String userId);
}
