package cn.hezhiling.sys.feign;

import cn.hezhiling.sys.service.user.UserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MASK-USER-SERVICE",path = "/user")
public interface UserServiceClient extends UserService {
}
