package cn.hezhiling.sys.feign;

import cn.hezhiling.sys.service.auth.LoginService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MASK-USER-SERVICE", path = "/user")
public interface LoginServiceClient extends LoginService {
}
